package org.example.apidiogo.Repository;

import org.example.apidiogo.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByUsuario(String usuario);

    @Modifying
    @Transactional
    @Query(
            value = "CALL inserir_professor_com_disciplina(:nome, :usuario, :senha, :disciplina)",
            nativeQuery = true
    )
    void inserirProfessorComDisciplina(
            @Param("nome") String nome,
            @Param("usuario") String usuario,
            @Param("senha") String senha,
            @Param("disciplina") String disciplina
    );
}

