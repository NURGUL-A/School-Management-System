package kz.enu.School.Management.System.entities;

public class Student {

    private Long id;
    private String fullname;
    private int age;

    public Student() {
    }

    public Student(Long id, String fullname, int age) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}