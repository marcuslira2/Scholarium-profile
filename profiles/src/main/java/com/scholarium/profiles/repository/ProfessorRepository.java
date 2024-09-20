package com.scholarium.profiles.repository;

import com.scholarium.profiles.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    Optional<Professor> findByIdAndDeletedFalse(Long id);

    Optional<Professor> findByNameAndDeletedFalse(String name);
}
