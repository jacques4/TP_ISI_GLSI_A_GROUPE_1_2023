package com.iai.togo.ProjetBanque.transaction;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class virement {

    public  String numCompteDebit;
    public  String numCompteCredit;
    public Double montant;
}
