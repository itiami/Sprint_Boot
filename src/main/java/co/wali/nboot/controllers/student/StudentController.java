package co.wali.nboot.controllers.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/student")
@CrossOrigin(origins = "http://192.168.1.235:4200")
@RestController
public class StudentController {
    public final StudentService studentService;

    // here @Autowired is a Dependency Injection that Inject StudentService Object into StudentController..
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("findAll")
    public List findAll() {
        System.out.println(findOne("Wali Abdullah"));
        return studentService.getAllStrudent();
    }


    @GetMapping("findOne")
    public Student findOne(@RequestParam("lname") String name) {
        for (Student x : studentService.getAllStrudent()) {
            if (x.getLname().equals(name)) {
                return x;
            }
            ;
        }
        return null;
    }

    @GetMapping("match")
    public List<Student> findTextContains(@RequestParam("lname") String name) {
        List<Student> dt = new ArrayList<>();
        for (Student x : studentService.getAllStrudent()) {
            if (x.getLname().contains(name)) {
                dt.add(x);
            }

        }
        return dt;
    }

    @DeleteMapping("del")
    public void delete(@RequestParam("id") int id) {
        studentService.getAllStrudent().removeIf(student -> student.getRollId() == id);
        System.out.println(studentService.getAllStrudent());
    }

}
