package kz.enu.School.Management.System.entities;

public class Student {
    private Long id;
    private String name;
    private int age;

    // Пустой конструктор ОБЯЗАТЕЛЕН
    public Student() {}

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Геттеры и сеттеры должны быть именно такими:
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}