package co.wali.nboot.controllers.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
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

    @PostMapping("add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("findAll")
    public List findAll() {
        return studentService.getAllStudent();
    }


    @GetMapping("findOne")
    public Student findOne(@RequestParam("lname") String name) {
        for (Student x : studentService.getAllStudent()) {
            if (x.getLname().equals(name)) {
                return x;
            }
        }
        return null;
    }

    // http://192.168.1.235:99/api/student/id?id=103
    @GetMapping("id")
    public Student findById(@RequestParam("id") Long id) {
        return studentService.findById(id).get();
    }

    @GetMapping("match")
    public List<Student> findTextContains(@RequestParam("lname") String name) {
        List<Student> dt = new ArrayList<>();
        for (Student x : studentService.getAllStudent()) {
            if (x.getLname().contains(name)) {
                dt.add(x);
            }
        }
        return dt;
    }

    @DeleteMapping("del")
    public void delete(@RequestParam("id") Long id) {
        for (Student std : studentService.getAllStudent()) {
            if (id.equals(std.getId())) {
                studentService.deleteStd(id);
            }
        }
    }

    // Update using @RequestParam..
    // to call in url will be..
    //http://192.168.1.235:99/api/student/553?rollId=512221&fname=A Wali
    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestParam(required = false) Integer rollId,
                       @RequestParam(required = false) String fname,
                       @RequestParam(required = false) String lname,
                       @RequestParam(required = false) LocalDate dob,
                       @RequestParam(required = false) String cls_grade,
                       @RequestParam(required = false) String cls_section,
                       @RequestParam(required = false) String email) {
        studentService.updateStudent(id, rollId, fname, lname, dob,
                cls_grade, cls_section, email);
    }

    // Update using @RequestBody..

    // but if want to create Json format to update we needs to call @RequestBody()
    @PutMapping("update/{stdId}")
    public void updateEntiy(@PathVariable Long stdId ,@RequestBody Student student) {
        studentService.saveOrUpdate(stdId, student);
    }

    /*
    to call this method the RequestBody will be the complete means all fields ass of Student Constructor
        {
            "id": 53,
            "rollId": 51117,
            "fname": "Saif Ali",
            "lname": "Khan",
            "cls_grade": "6eme",
            "cls_section": "B",
            "email": "saifAli@email.com",
            "dob": "2008-05-14"
        }
    */
}
