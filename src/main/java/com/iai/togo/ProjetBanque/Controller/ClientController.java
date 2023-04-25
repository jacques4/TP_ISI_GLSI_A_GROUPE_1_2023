package com.iai.togo.ProjetBanque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iai.togo.ProjetBanque.Service.ClientService;
import com.iai.togo.ProjetBanque.entities.ApiResponse;
import com.iai.togo.ProjetBanque.entities.Client;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/clients")
    public ResponseEntity<ApiResponse> showClients() {
        return new ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Liste des clients" ,clientService.getClient()),HttpStatus.OK);

    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ApiResponse> oneClient(@PathVariable Integer id){
        return new ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Client" ,clientService.findClientById(id)),HttpStatus.OK);
    }


    @PostMapping("/client")
    public ResponseEntity<ApiResponse> saveClient(@RequestBody Client client){
        clientService.addClient(client);
        return new ResponseEntity<ApiResponse>(
        new ApiResponse(HttpStatus.OK.value(),"Client Enregistré" ,clientService.getClient()),HttpStatus.OK);
    }

    @PutMapping("client/{id}")
    public  ResponseEntity<ApiResponse> updateClient (@RequestBody Client client , @PathVariable Integer id){
        client.setId(id);
        clientService.addClient(client);
        return  new  ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Client Modifié" ,clientService.getClient()),HttpStatus.OK);

    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<ApiResponse> deleteClient(@PathVariable Integer id){

        clientService.deleteClient(id);
        return  new  ResponseEntity<ApiResponse>(
                new ApiResponse(HttpStatus.OK.value(),"Client Supprimer" ,clientService.getClient()),HttpStatus.OK);
    }

}
