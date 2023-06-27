package wali.co.nboot.controllers.student;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/student")
@CrossOrigin(origins = "http://192.168.1.235:4200")
@RestController
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    public StudentController() {
        studentList.add(new Student(1, "Jamal Khan", 12));
        studentList.add(new Student(2, "Amin Khan", 22));
        studentList.add(new Student(3, "Alex Murphy", 12));
        studentList.add(new Student(4, "Wali Abdullah", 14));
        studentList.add(new Student(4, "Abdullah Wafi", 14));
    }


    @GetMapping("all")
    public List findAll() {
        System.out.println("findOne: "+findOne("Wali Abdullah"));
        System.out.println("findTextContains: "+findTextContains("Abdullah"));
        //delete(3); // to delete Alex
        return studentList;
    }


    public Student findOne(String name){
        for (Student x : studentList) {
            if (x.getName().equals(name)){
                return x;
            };
        }
            return null;
    }

    public List<Student> findTextContains(String name){
        List<Student> dt = new ArrayList<>();
        for (Student x : studentList) {
            if (x.getName().contains(name)){
                dt.add(x);
            };
        }
            return dt;
    }

    @DeleteMapping
    public void delete(int id) {
        studentList.removeIf(student -> student.getId() == id);
    }

}
