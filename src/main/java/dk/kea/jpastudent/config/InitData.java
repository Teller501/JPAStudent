package dk.kea.jpastudent.config;

import dk.kea.jpastudent.model.Student;
import dk.kea.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Anders");
        s1.setBornDate(LocalDate.of(2002,8,18));
        s1.setBornTime(LocalTime.of(10,11,12));
        repository.save(s1);
        /*s1.setName("Bruce");
        repository.save(s1);
        repository.save(s1);*/
    }
}
