package co.wali.nboot.controllers.student;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")
    private Long id;
    private Integer rollId;
    private String fname;
    private String lname;
    private LocalDate dob;
    @Transient
    private Integer age;
    private String cls_grade;
    private String cls_section;
    private String email;


    public Student() {
    }

    public Student(Integer rollId, String fname, String lname, LocalDate dob, String cls_grade, String cls_section) {
        super();
        this.rollId = rollId;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.cls_grade = cls_grade;
        this.cls_section = cls_section;
    }

    public Student(Long id, Integer rollId, String fname, String lname, LocalDate dob, Integer age, String cls_grade, String cls_section, String email) {
        this.id = id;
        this.rollId = rollId;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.age = age;
        this.cls_grade = cls_grade;
        this.cls_section = cls_section;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRollId() {
        return rollId;
    }

    public void setRollId(Integer rollId) {
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String dateFormat(Date date){
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        return DateFor.format(date);
    }
}
