package com.scholarium.profiles.controller;

import com.scholarium.profiles.dto.student.CreateStudentDTO;
import com.scholarium.profiles.dto.student.EditStudentDTO;
import com.scholarium.profiles.dto.student.StudentDTO;
import com.scholarium.profiles.model.Student;
import com.scholarium.profiles.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findByIdAndDeletedFalse(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody CreateStudentDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateAddressById(@PathVariable Long id, @RequestBody EditStudentDTO dto){
        studentService.changeAddress(id,dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
