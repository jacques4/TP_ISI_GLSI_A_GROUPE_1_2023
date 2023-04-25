package com.iai.togo.ProjetBanque.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.iai.togo.ProjetBanque.Repository.CompteRepository;
import com.iai.togo.ProjetBanque.entities.Compte;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;
    Compte compte;

    public List <Compte> getCompte(){
        return compteRepository.findAll();
    }

    public Compte getCompteById(Integer compteId){
        return compteRepository.findById(compteId).
                orElseThrow(()-> new RuntimeException("Compte non trouvé"));
    }

        public Compte getCompteByNumCpmte(String numCompte){
        return compteRepository.findByNumCompte(numCompte).
                orElseThrow(()-> new RuntimeException("Compte non trouvé"));
    }
    public Compte addCompte(Compte compte){
        compte.setSoldeCompte(0.0);
        compte.setDateCreation(LocalDate.now());
        compte.setNumCompte(compte.genereNumCompte());
        return compteRepository.save(compte);
    }

    public Compte UpdateCompte(String numCompte, Compte compteupd){
        return compteRepository.findByNumCompte(numCompte)
                .map(com-> {
                    com.setTypeCompte(compteupd.getTypeCompte());
                    return compteRepository.save(com);
                }).orElseThrow(()-> new RuntimeException(" Compte non trouvé"));
    }
    public Compte UpdateCompteVersement(String numCompte, Compte compteupd){
        return compteRepository.findByNumCompte(numCompte)
                .map(com-> {
                    com.setTypeCompte(compteupd.getTypeCompte());
                    return compteRepository.save(com);
                }).orElseThrow(()-> new RuntimeException(" Compte non trouvé"));
    }

    public Compte UpdateCompteRetrait(String numCompte, Compte compteupd){
        return compteRepository.findByNumCompte(numCompte)
                .map(com-> {
                    com.setTypeCompte(compteupd.getTypeCompte());
                    return compteRepository.save(com);
                }).orElseThrow(()-> new RuntimeException(" Compte non trouvé"));
    }
    public void UpdateCompteVirement(String numCompteSource, String numCompteDest,Double montant){
        Compte compteSource = compteRepository.findByNumCompte(numCompteSource)
                .orElseThrow(() -> new RuntimeException("Compte source introuvable"));
        Compte compteDest = compteRepository.findByNumCompte(numCompteDest)
                .orElseThrow(() -> new RuntimeException("Compte destination introuvable"));
        double nouveauSoldeSource = compteSource.getSoldeCompte() - montant;
        if (nouveauSoldeSource < 0) {
            throw new RuntimeException("Solde insuffisant sur le compte source");
        }
        double nouveauSoldeDest = compteDest.getSoldeCompte()  + montant;
        compteSource.setSoldeCompte(nouveauSoldeSource);
        compteDest.setSoldeCompte(nouveauSoldeDest);
        compteRepository.saveAll(Arrays.asList(compteSource, compteDest));
    }



    public void deleteCompte(Integer compteId) { compteRepository.deleteById(compteId);}

    /*public  Compte versement( Compte compte){
       compte.getSoldeCompte()
    }*/
}
