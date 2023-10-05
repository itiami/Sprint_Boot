package co.wali.nboot.modules.student;


import co.wali.nboot.modules.address.Address;
import co.wali.nboot.modules.address.AddressRepository;
import co.wali.nboot.modules.address.AddressService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Component
public class StudentService {
    List<Student> studentList = new ArrayList<>();
    private final StudentRepository studentRepository;
    private final AddressService addressService;
    /*@Autowired
    public StudentService(StudentRepository studentRepository) {
        //studentList.add(new Student(51100, "wali", "abdullah", LocalDate.of(2023,4,23),"5eme","A","email.mail.com", List.of(new PhoneNumber("2154545"))));
        this.studentRepository = studentRepository;
    }*/

    @Autowired
    public StudentService(StudentRepository studentRepository, AddressService addressService) {
        //studentList.add(new Student(51100, "wali", "abdullah", LocalDate.of(2023,4,23),"5eme","A","email.mail.com", List.of(new PhoneNumber("2154545"))));
        this.studentRepository = studentRepository;
        this.addressService = addressService;
    }

    public List<Student> findAll() {
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
            studentRepository.saveAndFlush(student);
            //System.out.println(student);
        }
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }


    @Transactional
    public void updateStudent(Long id, Integer rollId, String fname, String lname, Date dob,
                              String cls_grade, String cls_section, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Student With ID: " + id + " does not exists"
        ));

        if (rollId != null && rollId > 0 && rollId != student.getRollId()) {
            student.setRollId(rollId);
        }

        if (fname != null && fname.length() > 0 && !Objects.equals(student.getFname(), fname)) {
            student.setFname(fname);
        }
        if (lname != null && lname.length() > 0 && !Objects.equals(student.getLname(), lname)) {
            student.setLname(lname);
        }
        if (dob != null && dob != student.getDob()) {
            student.setDob(dob);
        }

        if (cls_grade != null && cls_grade.length() > 0 && !Objects.equals(student.getCls_grade(), cls_grade)) {
            student.setCls_grade(cls_grade);
        }
        if (cls_section != null && cls_section.length() > 0 && !Objects.equals(student.getCls_section(), cls_section)) {
            student.setCls_section(cls_section);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }
    }

    /*
        Explained saveOrUpdate() method..
        1. Long id = is a parameter created to user input.
        2. Student student = is created from the Student Class. where all properties of the Student class will be pass to
            the browser for user input.
            these above 2 props are forwarded to StudentController which also forward to the Browser for user input.
            Long id will use in Browser URL. and
            Student student instance will be useing as Browser's json payload
            the we've create 2 more instance from the Student Class
        3. Student existsId = receive id from brower user input and pass it to studentRepository to check if Id exists.
            if not, a IllegalStateException err is created with custom message
        4. Student existsStudent = is created as Entiry means Instance of Student of the user input id.
        5. as the existsStudent is an Instance of Student class. we can user setter to set the value sent by Browser i.g. in step 2.
        6. and at the end the existsStudent Instance will be save. means we are creating a constructor with value from Student class.
            and the values are comming from step 2.
        7. apart from Above................. all the if conditions are use for data validation..
            e.g. setter will call if example rollId is not null and grater then 0 and if not Exits..
                else rollId will not change..
    */

    public void saveOrUpdate(Long id, Student student) {

        Student existsId = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Student With ID: " + id + " does not exists"
        ));

        Student existsStudent = studentRepository.findById(id).get();

        if (student.getRollId() != null &&
                student.getRollId() > 0 &&
                !Objects.equals(student.getRollId(), existsId.getRollId())) {
            existsStudent.setRollId(student.getRollId());
        }


        if (student.getFname() != null &&
                student.getFname().length() > 0 &&
                !Objects.equals(student.getFname(), existsId.getFname())) {
            existsStudent.setFname(student.getFname());
        }
        if (student.getLname() != null &&
                student.getLname().length() > 0 &&
                !Objects.equals(student.getLname(), existsId.getLname())) {
            existsStudent.setLname(student.getLname());
        }
        if (student.getDob() != null && student.getDob() != existsId.getDob()) {
            existsStudent.setDob(student.getDob());
        }

        if (student.getCls_grade() != null &&
                student.getCls_grade().length() > 0 &&
                !Objects.equals(student.getCls_grade(), existsId.getCls_grade())) {
            existsStudent.setCls_grade(student.getCls_grade());
        }
        if (student.getCls_section() != null &&
                student.getCls_section().length() > 0 &&
                !Objects.equals(student.getCls_section(), existsId.getCls_section())) {
            existsStudent.setCls_section(student.getCls_section());
        }

        if (student.getEmail() != null &&
                student.getEmail().length() > 0 &&
                !Objects.equals(student.getEmail(), existsId.getEmail())) {
            existsStudent.setEmail(student.getEmail());
        }

        studentRepository.save(existsStudent);
    }
}
