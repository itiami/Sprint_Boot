package wali.co.nboot.controllers.student;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService {
    private final List<Student> studentList = new ArrayList<>();

    public StudentService() {
        studentList.add(new Student(1, "Jamal Khan", 12));
        studentList.add(new Student(2, "Amin Khan", 22));
        studentList.add(new Student(3, "Alex Murphy", 12));
        studentList.add(new Student(4, "Wali Abdullah", 14));
        studentList.add(new Student(5, "Abdullah Wafi", 14));
    }


    public List<Student> getAllStrudent() {
        return studentList;
    }
}
