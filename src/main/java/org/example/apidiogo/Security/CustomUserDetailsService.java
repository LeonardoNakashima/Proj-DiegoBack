package org.example.apidiogo.Security;

import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Aluno;
import org.example.apidiogo.Model.Professor;
import org.example.apidiogo.Repository.AdminRepository;
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
    private final AdminRepository adminRepository;

    public CustomUserDetailsService(AlunoRepository alunoRepository, ProfessorRepository professorRepository,  AdminRepository adminRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.matches("\\d+")) {
            Aluno aluno = alunoRepository.findAlunoByMatricula(Long.valueOf(username))
                    .orElseThrow(() -> new UsernameNotFoundException("Aluno não encontrado"));
            return User.withUsername(aluno.getMatricula().toString())
                    .password(aluno.getSenha())
                    .authorities("ROLE_ALUNO")
                    .build();
        } else if (username.matches("^(?!admin$).+\n")) {
            Professor professor = professorRepository.findByUsuario(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Professor não encontrado"));
            return User.withUsername(professor.getUsuario())
                    .password(professor.getSenha())
                    .authorities("ROLE_PROFESSOR")
                    .build();
        }
        else{
            Admin admin = adminRepository.findByUsuario(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Administrador não encontrado"));
            return User.withUsername(admin.getUsuario())
                    .password(admin.getSenha())
                    .authorities("ADM")
                    .build();
        }
    }
}
