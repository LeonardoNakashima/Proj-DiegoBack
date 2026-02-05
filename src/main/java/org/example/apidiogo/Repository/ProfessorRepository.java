package org.example.apidiogo.Repository;

import org.example.apidiogo.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByUsuario(String usuario);
}
