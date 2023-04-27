# TP_ISI_GLSI_A_GROUPE_1_2023

Il s'agit d'un projet de gestion d'une banque en quelque sorte . 

La base de donnee utilisé est H2 .
Le lien d'acces aux routes est celci :
 
 http://localhost:8080/egapirest

L'API permet donc de: 
Créer un client ,
Créer un compte a ce dernier avec un montant par defaut 00 fr,
Faire un versement sur le compte de ce dernier ,
Faire un retrait sur le compte de ce dernier,
Faire un virement de son compte vers un autre compte.


Liens d'acces aux routes

*OPERATIONS PORTANT SUR LE CLIENT CLIENTS

Listes des clients(GET)         http://localhost:8080/egapirest/clients
Client particulier(GET)         http://localhost:8080/egapirest/client/id
Enregistrer un client(POST)     http://localhost:8080/egapirest/client
Modifier un client(PUT)         http://localhost:8080/egapirest/client/id
Supprimer un client(DELETE)     http://localhost:8080/egapirest/client/id


*OPERATIONS PORTANT SUR LE COMPTE

Listes des comptes(GET)         http://localhost:8080/egapirest/comptes
Compte particulier(GET)         http://localhost:8080/egapirest/compte/numCompte
Enregistrer un compte(POST)     http://localhost:8080/egapirest/compte
Modifier un client(PUT)         http://localhost:8080/egapirest/compte/numCompte
Supprimer un client(DELETE)     http://localhost:8080/egapirest/compte/numCompte
Faire un versement (PUT)        http://localhost:8080/egapirest/compte/numCompte
Faire un depot(PUT)             http://localhost:8080/egapirest/compte/numCompte
Faire un virement(PUT)          http://localhost:8080/egapirest/compte/numCompteSource/virement/numComteDest


