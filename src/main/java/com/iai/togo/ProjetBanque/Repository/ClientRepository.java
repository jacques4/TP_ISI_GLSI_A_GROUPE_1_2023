package com.iai.togo.ProjetBanque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iai.togo.ProjetBanque.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
}
