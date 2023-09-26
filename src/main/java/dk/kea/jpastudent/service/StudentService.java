package dk.kea.jpastudent.service;

import dk.kea.jpastudent.dto.StudentConverter;
import dk.kea.jpastudent.dto.StudentDTO;
import dk.kea.jpastudent.exception.StudentNotFoundException;
import dk.kea.jpastudent.model.Student;
import dk.kea.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter){
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentConverter.toDTO(studentOptional.get());
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }

    public StudentDTO createStudent(StudentDTO studentDTO){
        Student studentToSave = studentConverter.toEntity(studentDTO);

        // ensure its a create
        studentToSave.setId(0);
        Student savedStudent = studentRepository.save(studentToSave);

        return studentConverter.toDTO(savedStudent);
    }

    public StudentDTO updateStudent(int id, StudentDTO studentDTO){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student studentToUpdate = studentConverter.toEntity(studentDTO);
            studentToUpdate.setId(id);
            Student savedStudent = studentRepository.save(studentToUpdate);
            return studentConverter.toDTO(savedStudent);
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }
}
