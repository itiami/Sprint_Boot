package co.wali.nboot.controllers.student;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    public void deleteStd(Long id){
            studentRepository.deleteById(id);
    }

    public String dateFormat(Date date){
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        return DateFor.format(date);
    }
}
