package kz.enu.School.Management.System.service;

import kz.enu.School.Management.System.entities.User;
import kz.enu.School.Management.System.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            EmailService emailService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public void registerUser(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered.");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password is required.");
        }
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            user.setUsername(user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);

        try {
            emailService.sendEmail(
                    user.getEmail(),
                    "Welcome",
                    "Your account has been created successfully."
            );
        } catch (RuntimeException ex) {
            // Ignore email failures so registration still succeeds.
        }
    }
}
