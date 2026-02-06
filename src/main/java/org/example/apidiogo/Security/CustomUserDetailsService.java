package org.example.apidiogo.Security;

import org.example.apidiogo.Model.Aluno;
import org.example.apidiogo.Model.Professor;
import org.example.apidiogo.Repository.AlunoRepository;
import org.example.apidiogo.Repository.ProfessorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;

    public CustomUserDetailsService(AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.matches("\\d+")) { // matrícula é numérica → aluno
            Aluno aluno = alunoRepository.findAlunoByMatricula(Long.valueOf(username))
                    .orElseThrow(() -> new UsernameNotFoundException("Aluno não encontrado"));
            return User.withUsername(aluno.getMatricula().toString())
                    .password(aluno.getSenha())
                    .authorities("ROLE_ALUNO") // ⚡ necessário mesmo sem role no banco
                    .build();
        }

        Professor professor = professorRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Professor não encontrado"));
        return User.withUsername(professor.getUsuario())
                .password(professor.getSenha())
                .authorities("ROLE_PROFESSOR") // ⚡ hardcoded
                .build();
    }
}
