package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("students")
public class StudentController {

    // Spring Boot GET API
    // http://localhost:8080/student
    // @GetMapping("/student")
    // public Student getStudent() {
    // Student student = new Student(1, "Rick", "Yang");
    // return student;
    // }
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Rick", "Yang");
        // return new ResponseEntity<>(student, HttpStatus.OK);
        // ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "rick").body(student);
    }

    // Spring Boot GET API
    // http://localhost:8080/students
    // @GetMapping("students")
    // public List<Student> getStudents() {
    // List<Student> students = new ArrayList<Student>();
    // students.add(new Student(1, "Rick", "Yang"));
    // students.add(new Student(2, "Aris", "Lien"));
    // students.add(new Student(3, "Amy", "Yang"));
    // return students;
    // }
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Rick", "Yang"));
        students.add(new Student(2, "Aris", "Lien"));
        students.add(new Student(3, "Amy", "Yang"));
        return ResponseEntity.ok(students);
    }

    // Spring Boot GET API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/100/rick/yang
    // @GetMapping("students/{id}/{first-name}/{last-name}")
    // public Student studentPathVariable(@PathVariable int id,
    // @PathVariable("first-name") String firstName,
    // @PathVariable("last-name") String lastName) {
    // return new Student(id, firstName, lastName);
    // }
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot GET API with Request Parameters
    // http://localhost:8080/students/query?id=1&firstName=Rick&lastName=Yang
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName,
            @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    // Spring Boot POST API Request
    // http://localhost:8080/students/create
    // @PostMapping("students/create")
    // @ResponseStatus(HttpStatus.CREATED)
    // public Student createStudent(@RequestBody Student student) {
    // System.out.println(student.getId());
    // System.out.println(student.getFirstName());
    // System.out.println(student.getLastName());
    // return student;
    // }
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring Boot PUT API Request
    // http://localhost:8080/students/update
    @PutMapping("{id}/update")
    public Student updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring Boot DELETE API Request
    // http://localhost:8080/students/1/delete
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable int id) {
        System.out.println(id);
        return "Student " + id + " deleted successfully!";
    }

}
