package dk.kea.jpastudent.dto;

import dk.kea.jpastudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentConverterTest {

    @Autowired
    StudentConverter studentConverter;

    StudentDTO studentDTOTest = new StudentDTO(1, "test", LocalDate.of(2002,12,12), LocalTime.of(12,12,12));

    Student studentTest = new Student(1, "test", LocalDate.of(2002,12,12), LocalTime.of(12,12,12));

    @Test
    void toEntityTest() {
        //Act
        Student resultStudent = studentConverter.toEntity(studentDTOTest);

        //Assert
        assertEquals(studentDTOTest.id(), resultStudent.getId());
    }

    @Test
    void toDTOTest() {
        //Act
        StudentDTO resultStudentDTO = studentConverter.toDTO(studentTest);

        //Assert
        assertEquals(studentTest.getId(), resultStudentDTO.id());
    }
}