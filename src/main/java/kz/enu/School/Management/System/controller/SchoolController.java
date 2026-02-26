package kz.enu.School.Management.System.controller;

import kz.enu.School.Management.System.entities.School;
import kz.enu.School.Management.System.entities.Student;
import kz.enu.School.Management.System.entities.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/school")
public class SchoolController {

    // 1️⃣ GET — тексеру
    @GetMapping
    public String hello() {
        return "School Management System Working";
    }

    // 2️⃣ GET — дайын School JSON
    @GetMapping("/info")
    public School getSchool() {

        Student s1 = new Student(1L, "Ayzkan Nurgul", 19);
        Student s2 = new Student(2L, "Salybek Aruzhan", 20);

        Teacher t1 = new Teacher(1L, "Kamila Tanyrbergenova", "Java");
        Teacher t2 = new Teacher(2L, "Samat Akshabaevich", "Veb");

        return new School(
                1L,
                "ENU",
                "Astana",
                Arrays.asList(s1, s2),
                Arrays.asList(t1, t2)
        );
    }

    // 3️⃣ POST — параметр қабылдау
    @PostMapping("/specific")
    public Student createStudent(@RequestParam String name) {
        return new Student(
                3L,
                name,
                19
        );
    }

    // 4️⃣ PUT — объект жаңарту
    @PutMapping("/update")
    public School updateSchool(@RequestBody School school) {
        return school;
    }

    // 5️⃣ DELETE — id арқылы жою
    @DeleteMapping("/delete")
    public String deleteSchool(@RequestParam Long id) {
        return "School with id " + id + " deleted";
    }
}