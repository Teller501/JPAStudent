package dk.kea.jpastudent.service;

import dk.kea.jpastudent.dto.StudentDTO;
import dk.kea.jpastudent.exception.StudentNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void getAllStudents() {
        //Act
        List<StudentDTO> studentDTOS = studentService.getAllStudents();
        //Assert
        assertEquals(1,studentDTOS.size());
    }

    @Test
    void getStudentById() {
        //Act
        StudentDTO studentDTO = studentService.getStudentById(1);

        //Assert
        assertEquals("Anders", studentDTO.name());
    }
}