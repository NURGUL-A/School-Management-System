package kz.enu.School.Management.System.entities;

import java.util.List;

public class School {
    private Long id;
    private String schoolName;
    private String city;
    private List<Student> students;
    private List<Teacher> teachers;

    // 1. Пустой конструктор
    public School() {
    }

    // 2. Конструктор со ВСЕМИ 5 полями (именно его ищет контроллер)
    public School(Long id, String schoolName, String city, List<Student> students, List<Teacher> teachers) {
        this.id = id;
        this.schoolName = schoolName;
        this.city = city;
        this.students = students;
        this.teachers = teachers;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public List<Teacher> getTeachers() { return teachers; }
    public void setTeachers(List<Teacher> teachers) { this.teachers = teachers; }
}