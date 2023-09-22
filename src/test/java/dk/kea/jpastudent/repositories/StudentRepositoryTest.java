package dk.kea.jpastudent.repositories;

import dk.kea.jpastudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @Test
    void testOneTim(){
        List<Student> lst = repository.findAllByName("Bruce");
        assertEquals(1, lst.size());
    }


}