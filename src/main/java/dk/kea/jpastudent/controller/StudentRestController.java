package dk.kea.jpastudent.controller;

import dk.kea.jpastudent.dto.StudentConverter;
import dk.kea.jpastudent.dto.StudentDTO;
import dk.kea.jpastudent.model.Student;
import dk.kea.jpastudent.repositories.StudentRepository;
import dk.kea.jpastudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        return new ResponseEntity<>(studentDTOList, HttpStatus.OK) ;
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> postStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") int id){
        StudentDTO studentDTO = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDTO> putStudent(@PathVariable("id") int id, @RequestBody StudentDTO studentDTO){
        StudentDTO updatedStudentDTO = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updatedStudentDTO);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@GetMapping("/students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name){
        return studentRepository.findAllByName(name);
    }*/

}