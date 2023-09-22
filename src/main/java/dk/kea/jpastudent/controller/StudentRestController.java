package dk.kea.jpastudent.controller;

import dk.kea.jpastudent.dto.StudentConverter;
import dk.kea.jpastudent.dto.StudentDTO;
import dk.kea.jpastudent.model.Student;
import dk.kea.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentRestController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentConverter studentConverter;

    @GetMapping("/students")
    public List<StudentDTO> students() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        students.forEach(s -> studentDTOS.add(studentConverter.toDTO(s)));
        return studentDTOS;
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student){
        System.out.println(student);
        return studentRepository.save(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putStudent(@RequestBody Student student, @PathVariable("id") int id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            student.setId(id);
            studentRepository.save(student);
            //return new ResponseEntity<>(student, HttpStatus.OK);
            return ResponseEntity.ok(student);
        } else {
            //return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

    @GetMapping("/students/{name}")
    public List<Student> getStudentsByName(@PathVariable String name){
        return studentRepository.findAllByName(name);
    }
}
