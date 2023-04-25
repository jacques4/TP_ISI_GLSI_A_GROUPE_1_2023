package com.iai.togo.ProjetBanque.transaction;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Retrait {

    public  String numCompte;
    public Double montant;
}
