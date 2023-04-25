package com.iai.togo.ProjetBanque.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iai.togo.ProjetBanque.Repository.ClientRepository;
import com.iai.togo.ProjetBanque.entities.Client;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client){
        return clientRepository.save(client);}

    public Client findClientById(Integer id){
        return clientRepository.findById(id).get();
    }

    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    public Client updateClient(Integer clientid, Client clientUpd){
        return clientRepository.findById(clientid)
                .map(c-> {
                    c.setNom(clientUpd.getNom());
                    c.setPrenom(clientUpd.getPrenom());
                    c.setDateNaiss(clientUpd.getDateNaiss());
                    c.setSexe(clientUpd.getSexe());
                    c.setAdresse(clientUpd.getAdresse());
                    c.setTelephone(clientUpd.getTelephone());
                    c.setCourriel(clientUpd.getCourriel());
                    c.setNationalite(clientUpd.getNationalite());
                    return clientRepository.save(c);
                }).orElseThrow(()-> new RuntimeException(" Client non trouvé"));
    }
}
