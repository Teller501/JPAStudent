package dk.kea.jpastudent.repositories;

import dk.kea.jpastudent.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @BeforeEach
    void init(){
        Student s1 = new Student(42, "Anders", LocalDate.of(2002,8,18), LocalTime.of(10,11,12));
        repository.save(s1);
        Student s2 = new Student(43, "Bruce", LocalDate.of(2002,8,18), LocalTime.of(10,11,12));
        repository.save(s2);
    }

    @Test
    void testFindByName(){
        //Act
        List<Student> students = repository.findAllByName("Anders");

        //Assert
        assertEquals(1, students.size());
    }

    @Test
    void testFindAll(){
        //Act
        List<Student> students = repository.findAll();

        //Assert
        assertEquals(2, students.size());
        assertThat(students, containsInAnyOrder(
                hasProperty("name", is("Anders")),
                hasProperty("name", is("Bruce"))));
    }


}