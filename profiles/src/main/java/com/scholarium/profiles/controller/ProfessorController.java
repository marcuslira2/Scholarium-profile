package com.scholarium.profiles.controller;

import com.scholarium.profiles.dto.CreateProfessorDTO;
import com.scholarium.profiles.model.Professor;
import com.scholarium.profiles.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdAndDeletedFalse(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(professorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody CreateProfessorDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        professorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }


}
