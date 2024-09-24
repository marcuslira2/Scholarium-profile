package com.scholarium.profiles.service;

import com.scholarium.profiles.dto.student.CreateStudentDTO;
import com.scholarium.profiles.dto.student.EditStudentDTO;
import com.scholarium.profiles.dto.student.StudentDTO;
import com.scholarium.profiles.model.Student;
import com.scholarium.profiles.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    private static final  String STUDENT_NOT_FOUNT = "Student not found";


    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO findById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException(STUDENT_NOT_FOUNT));
        return convertToDTO(student);
    }

    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(
                student.getName(),
                student.getCpf(),
                student.isRegular()
        );
    }

    public Student create(CreateStudentDTO dto){
        return studentRepository.save(new Student(dto));
    }

    public void deleteById (Long id){
        studentRepository.findById(id).orElseThrow(()-> new NoSuchElementException(STUDENT_NOT_FOUNT));
    }

    public void changeAddress(Long id, EditStudentDTO dto){
        Student student = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException(STUDENT_NOT_FOUNT));

        student.setAddress(dto.address());
        studentRepository.save(student);

    }
}
