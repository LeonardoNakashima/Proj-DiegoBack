package org.example.apidiogo.Service;

import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Aluno;
import org.example.apidiogo.Model.Professor;
import org.example.apidiogo.Repository.AdminRepository;
import org.example.apidiogo.Repository.AlunoRepository;
import org.example.apidiogo.Repository.ProfessorRepository;
import org.example.apidiogo.Security.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginService(
            AlunoRepository alunoRepository,
            ProfessorRepository professorRepository,
            AdminRepository adminRepository,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider
    ) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public String login(String login, String senha) {

        if (login.matches("\\d+")) {
            Long matricula = Long.valueOf(login);
            Optional<Aluno> optionalAluno = alunoRepository.findAlunoByMatricula(matricula);
            Aluno aluno = optionalAluno.orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

            if (!passwordEncoder.matches(senha, aluno.getSenha())) {
                throw new IllegalArgumentException("Senha inválida");
            }

            return jwtProvider.generateTokenAluno(aluno);

        } else if (login.matches("^(?!admin$).+\n")) {
            Optional<Professor> optionalProfessor = professorRepository.findByUsuario(login);
            Professor professor = optionalProfessor.orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));

            if (!passwordEncoder.matches(senha, professor.getSenha())) {
                throw new IllegalArgumentException("Senha inválida");
            }

            return jwtProvider.generateTokenProfessor(professor);
        }
        else {
            Optional<Admin> op = adminRepository.findByUsuario(login);
            Admin adm = op.orElseThrow(() -> new IllegalArgumentException("Administrador não encontrado"));
            if (!passwordEncoder.matches(senha, adm.getSenha())) {
                throw new IllegalArgumentException("Senha inválida");
            }
            return jwtProvider.generateTokenAdmin(adm);
        }
    }
}
