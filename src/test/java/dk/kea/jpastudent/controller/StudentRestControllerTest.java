package dk.kea.jpastudent.controller;

import dk.kea.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRestControllerTest {
    @Autowired
    StudentRepository studentRepository;



}