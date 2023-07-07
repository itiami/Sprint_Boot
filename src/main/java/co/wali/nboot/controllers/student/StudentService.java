package co.wali.nboot.controllers.student;

import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Component
public class StudentService {
    private StudentRepository studentRepository;
    private final List<Student> studentList = new ArrayList<>();

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        /*studentList.add(new Student(51051, "Jamal","Miah", dateFormat(new Date(2012,02,25)), "3eme", "A"));
        studentList.add(new Student(51052, "Nasim","Ali", dateFormat(new Date(2012,02,25)), "5eme", "A"));
        studentList.add(new Student(51053, "Jamal","Khan", dateFormat(new Date(2012,02,25)), "5eme", "A"));
        studentList.add(new Student(51054, "Nasim","Khan", dateFormat(new Date(2012,02,25)), "3eme", "A"));
        studentList.add(new Student(51055, "Amin","Miah", dateFormat(new Date(2012,02,25)), "2nd", "A"));
        studentList.add(new Student(51056, "Haydar","Khan", dateFormat(new Date(2012,02,25)), "6eme", "A"));*/
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll(Sort.by("lname"));
    }

    public String getEmail(Student student) {
        return student.getEmail();
    }


    public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email has Taken");
        } else {
            studentRepository.save(student);
            System.out.println(student);
        }
    }

    public void deleteStd(Long id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }


    @Transactional
    public void updateStudent(Long id, Integer rollId, String fname, String lname, LocalDate dob,
                              String cls_grade, String cls_section, String email) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                "Student With ID: " + id + " does not exists"
        ));

        if (rollId != null && rollId > 0 && rollId != student.getRollId()) {
            student.setRollId(rollId);
        }

        if (fname != null && fname.length() > 0 && !Objects.equals(student.getFname(), fname)) {
            student.setFname(fname);
        }
        if (lname != null && lname.length() > 0 &&!Objects.equals(student.getLname(), lname)) {
            student.setLname(lname);
        }
        if (dob !=null && !dob.isEqual(student.getDob())) {
            student.setDob(dob);
        }

        if (cls_grade != null && cls_grade.length() > 0 &&!Objects.equals(student.getCls_grade(), cls_grade)) {
            student.setCls_grade(cls_grade);
        }
        if (cls_section != null && cls_section.length() > 0 &&!Objects.equals(student.getCls_section(), cls_section)) {
            student.setCls_section(cls_section);
        }
        if (email != null && email.length() > 0 &&!Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }
    }

    public void saveOrUpdate(Long id ,Student student) {
        Student existsId = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                "Student With ID: " + id + " does not exists"
        ));

        Student existsStudent = studentRepository.findById(id).get();

        if (student.getRollId() != null && student.getRollId() > 0 && student.getRollId() != existsId.getRollId()) {
            existsStudent.setRollId(student.getRollId());
        }


        if (student.getFname() != null && student.getFname().length() > 0 && !Objects.equals(student.getFname(), existsId.getFname())) {
            existsStudent.setFname(student.getFname());
        }
        if (student.getLname() != null && student.getLname().length() > 0 &&!Objects.equals(student.getLname(), existsId.getLname())) {
            existsStudent.setLname(student.getLname());
        }
        if (student.getDob() !=null && !student.getDob().isEqual(existsId.getDob())) {
            existsStudent.setDob(student.getDob());
        }

        if (student.getCls_grade() != null && student.getCls_grade().length() > 0 &&!Objects.equals(student.getCls_grade(), existsId.getCls_grade())) {
            existsStudent.setCls_grade(student.getCls_grade());
        }
        if (student.getCls_section() != null && student.getCls_section().length() > 0 &&!Objects.equals(student.getCls_section(), existsId.getCls_section())) {
            existsStudent.setCls_section(student.getCls_section());
        }
        if (student.getEmail() != null && student.getEmail().length() > 0 &&!Objects.equals(student.getEmail(), existsId.getEmail())) {
            existsStudent.setEmail(student.getEmail());
        }
            studentRepository.save(existsStudent);
    }
}
