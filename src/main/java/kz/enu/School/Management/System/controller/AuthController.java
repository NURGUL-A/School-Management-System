package kz.enu.School.Management.System.controller;

import kz.enu.School.Management.System.entities.User;
import kz.enu.School.Management.System.security.CustomUserDetailsService;
import kz.enu.School.Management.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    private final UserService userService;
    private final CustomUserDetailsService userDetailsService;

    public AuthController(UserService userService, CustomUserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
        String rawPassword = user.getPassword();
        try {
            userService.registerUser(user);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "register";
        }
        try {
            request.login(user.getUsername(), rawPassword);
        } catch (Exception e) {
            return "redirect:/login";
        }
        return "redirect:/students";
    }

    @Controller
    public class HomeController {

        @GetMapping("/home")
        public String home() {
            return "home";
        }
    }

    @RestController
    @RequestMapping("/api/auth")
    public class AuthApiController {

        @Autowired
        private UserService userService;

        @PostMapping("/register")
        public String register(@RequestBody User user) {
            userService.registerUser(user);
            return "User registered and email sent.";
        }
    }
}
