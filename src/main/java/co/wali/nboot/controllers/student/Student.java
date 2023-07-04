package co.wali.nboot.controllers.student;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")
    private Long id;
    private int rollId;
    private String fname;
    private String lname;
    private String dob;
    private String cls_grade;
    private String cls_section;


    public Student() {
    }

    public Student(int rollId, String fname, String lname, String dob, String cls_grade, String cls_section) {
        super();
        this.rollId = rollId;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.cls_grade = cls_grade;
        this.cls_section = cls_section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRollId() {
        return rollId;
    }

    public void setRollId(int rollId) {
        this.rollId = rollId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCls_grade() {
        return cls_grade;
    }

    public void setCls_grade(String cls_grade) {
        this.cls_grade = cls_grade;
    }

    public String getCls_section() {
        return cls_section;
    }

    public void setCls_section(String cls_section) {
        this.cls_section = cls_section;
    }
}
