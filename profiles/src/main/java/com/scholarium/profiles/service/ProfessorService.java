package com.scholarium.profiles.service;

import com.scholarium.profiles.dto.professor.CreateProfessorDTO;
import com.scholarium.profiles.dto.professor.EditProfessorDTO;
import com.scholarium.profiles.dto.professor.ProfessorDTO;
import com.scholarium.profiles.model.Professor;
import com.scholarium.profiles.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public ProfessorDTO findById(Long id){
        Professor professor = professorRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new NoSuchElementException("Professor not found."));
        return convertToDTO(professor);
    }

    public Professor create(CreateProfessorDTO dto){
        return professorRepository.save(new Professor(dto));
    }

    public void deleteById(Long id){
        Professor professor = professorRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new NoSuchElementException("Professor not found."));

        professor.setDeleted(true);

        professorRepository.save(professor);
    }

    public ProfessorDTO convertToDTO (Professor professor){
        return new ProfessorDTO(
                professor.getId(),
                professor.getName(),
                professor.getCpf()
        );
    }

    public void changeAddress(Long id, EditProfessorDTO dto){
        Professor professor = professorRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new NoSuchElementException("Professor not found."));
        professor.setAddress(dto.address());

        professorRepository.save(professor);
    }
}

