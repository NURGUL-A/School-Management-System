package kz.enu.School.Management.System.controller;

import kz.enu.School.Management.System.entities.School;
import kz.enu.School.Management.System.entities.Student;
import kz.enu.School.Management.System.entities.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final AtomicLong nextStudentId = new AtomicLong(1);

    public SchoolController() {
        students.add(new Student(1L, "Ayazkan Nurgul", 19));
        students.add(new Student(2L, "Ayazkan Aruzhan", 22));
        students.add(new Student(3L, "Bekbergen Islam", 20));

        teachers.add(new Teacher(1L, "Kamila Tanyrbergenova", "Java"));

        long maxId = students.stream()
                .map(Student::getId)
                .filter(id -> id != null)
                .max(Comparator.naturalOrder())
                .orElse(0L);
        nextStudentId.set(maxId + 1);
    }

    @GetMapping("/info")
    public School getSchool() {
        return new School(1L, "ENU", "Astana", students, teachers);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        student.setId(nextStudentId.getAndIncrement());
        students.add(student);
        return student;
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                updatedStudent.setId(id);
                students.set(i, updatedStudent);
                return updatedStudent;
            }
        }
        return null;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean removed = students.removeIf(s -> s.getId().equals(id));
        return removed ? "Student deleted successfully" : "Student not found";
    }
}
