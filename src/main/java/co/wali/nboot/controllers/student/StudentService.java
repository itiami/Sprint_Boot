package co.wali.nboot.controllers.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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
        }else {
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


}
