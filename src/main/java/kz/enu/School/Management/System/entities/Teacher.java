package kz.enu.School.Management.System.entities;

public class Teacher {

    private Long id;
    private String fullname;
    private String subject;

    public Teacher() {
    }

    public Teacher(Long id, String fullname, String subject) {
        this.id = id;
        this.fullname = fullname;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getSubject() {
        return subject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}