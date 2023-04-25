package com.iai.togo.ProjetBanque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iai.togo.ProjetBanque.Service.CompteService;
import com.iai.togo.ProjetBanque.entities.*;
import com.iai.togo.ProjetBanque.transaction.*;


@RestController
public class CompteController {

    @Autowired
    CompteService compteService;

    @GetMapping("/comptes")
    public ResponseEntity<ApiResponse> showComptes(){
        return  new ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Liste des comptes" ,compteService.getCompte()),HttpStatus.OK);
    }

    @GetMapping("/compte/{id}")
    public ResponseEntity<ApiResponse> oneCompte(@PathVariable Integer id){
        compteService.getCompteById(id);
        return  new ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Compte" ,compteService.getCompteById(id)),HttpStatus.OK);
    };

    @PostMapping("/compte")
    public ResponseEntity<ApiResponse> saveCompte(@RequestBody Compte compte){
        System.err.println("Compte" + compte);
        compteService.addCompte(compte);
       return  new ResponseEntity<ApiResponse>(
               new ApiResponse(HttpStatus.OK.value(),"Compte Enregistré" ,compteService.getCompte()),HttpStatus.OK
       );
    }

    @PutMapping("/compte/{numCompte}")
    public ResponseEntity<ApiResponse> updateCompte(@RequestBody Compte compte , @PathVariable String numCompte){
        compte.setNumCompte(numCompte);
        compteService.getCompteByNumCpmte(numCompte);
        System.err.println(numCompte + ' '+compte);
        compteService.UpdateCompte(numCompte,compte);
        return  new ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Compte Modifié" ,compteService.getCompte()),HttpStatus.OK);
    }

    @PutMapping("/compte/depot/{numCompte}")
    public  ResponseEntity<ApiResponse> depotCompte(@RequestBody Depot depot, @PathVariable String numCompte){

        Compte compte= compteService.getCompteByNumCpmte(numCompte);
        Double somme = depot.getMontant() + compte.getSoldeCompte();
        compte.setSoldeCompte(somme);
        System.err.println( somme);
        System.err.println(numCompte +' '+ compte);
        compteService.UpdateCompteVersement(numCompte,compte);
        return  new ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Compte Débité" ,compteService.getCompte()),HttpStatus.OK);
    }

    @PutMapping("/compte/retrait/{numCompte}")
    public  ResponseEntity<ApiResponse> retraitCompte(@RequestBody Retrait retrait, @PathVariable String numCompte){
        Compte compte = compteService.getCompteByNumCpmte(numCompte);
        if(retrait.getMontant() >= compte.getSoldeCompte()  || retrait.getMontant() < 0 ){
            throw new RuntimeException("Solde mal Renseigné ou  Insuffisant");
        }
        else{
            Double moins =  compte.getSoldeCompte() - retrait.getMontant() ;
            compte.setSoldeCompte(moins);
            System.err.println( moins);
            System.err.println(numCompte +' '+ compte);
            compteService.UpdateCompteRetrait(numCompte,compte);
            return  new ResponseEntity<ApiResponse>(
                    new ApiResponse(HttpStatus.OK.value(),"Compte Crédité" ,compteService.getCompte()),HttpStatus.OK);
        }
    }
    @PutMapping("/compte/{numeroCompteSource}/virement/{numeroCompteDest}")
    public  ResponseEntity<ApiResponse> VirementCompte(@RequestBody virement virement,@PathVariable String numeroCompteSource, @PathVariable String numeroCompteDest){
        Compte compteSource = compteService.getCompteByNumCpmte(numeroCompteSource);
        Compte compteDestination = compteService.getCompteByNumCpmte(numeroCompteDest);
        System.err.println(virement.getMontant());
        System.err.println("/n Numero de compte source: "+numeroCompteSource+"/n Numero de compte de destination: "+numeroCompteDest+"/n Solde viree: "+virement.getMontant());
        compteService.UpdateCompteVirement(numeroCompteSource,numeroCompteDest,virement.getMontant());
        return  new ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Montant Transferé" ,compteService.getCompte()),HttpStatus.OK);

    }

    @DeleteMapping("/compte/{id}")
    public void deleteCompte(@PathVariable Integer id){
        compteService.deleteCompte(id);
        System.err.println("Compte Supprimer");
    }
}
