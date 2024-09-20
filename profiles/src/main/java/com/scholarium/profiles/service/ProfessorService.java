package com.scholarium.profiles.service;

import com.scholarium.profiles.dto.CreateProfessorDTO;
import com.scholarium.profiles.model.Professor;
import com.scholarium.profiles.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor findById(Long id){
        return professorRepository.findByIdAndDeletedFalse(id).orElseThrow(()-> new NoSuchElementException("Professor not found."));
    }

    public Professor create(CreateProfessorDTO dto){
        return professorRepository.save(new Professor(dto));
    }

    public void deleteById(Long id){
        Professor professor = findById(id);

        professor.setDeleted(true);

        professorRepository.save(professor);
    }
}

