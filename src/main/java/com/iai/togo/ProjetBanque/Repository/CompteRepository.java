package com.iai.togo.ProjetBanque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iai.togo.ProjetBanque.entities.Compte;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findByNumCompte(String numCompte);

}
