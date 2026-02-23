package org.example.apidiogo.Repository;

import org.example.apidiogo.Model.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletimRepository extends JpaRepository<Boletim, Integer> {

    Optional<Boletim> findById(Long Id);
}
