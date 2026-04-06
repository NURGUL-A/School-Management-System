package kz.enu.School.Management.System.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentsPageController {

    @GetMapping("/students")
    public String studentsPage() {
        return "students";
    }
}
