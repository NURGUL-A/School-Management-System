package kz.enu.School.Management.System.controller;

import kz.enu.School.Management.System.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/students")
    public String studentsPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin-students";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userRepository.findById(id).ifPresent(user -> {
            if (!"ADMIN".equalsIgnoreCase(user.getRole())) {
                userRepository.deleteById(id);
            }
        });
        return "redirect:/admin/students";
    }
}
