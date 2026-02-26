package kz.enu.School.Management.System.entities;

import java.util.List;

public class School {

    private Long id;
    private String name;
    private String city;
    private List<Student> students;
    private List<Teacher> teachers;

    public School() {
    }

    public School(Long id, String name, String city,
                  List<Student> students,
                  List<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.students = students;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}