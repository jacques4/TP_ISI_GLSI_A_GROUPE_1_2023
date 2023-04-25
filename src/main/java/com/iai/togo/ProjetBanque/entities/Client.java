package com.iai.togo.ProjetBanque.entities;
import jakarta.persistence.*;
import lombok.*;
import com.iai.togo.ProjetBanque.enums.Sexe;
@Entity
@Table(name="Clients")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name="nomClient")
    private String nom ;
    @Column(name="prenomClient")
    private String prenom ;
    @Column(name="dateNaiss")
    private String dateNaiss;
    @Column(name="sexe")
    private Sexe sexe ;
    @Column(name="adresse")
    private String adresse ;
    @Column(name="telephone")
    private String telephone ;
    @Column(name="courriel")
    private String courriel ;
    @Column(name="nationalite")
    private String nationalite ;
}
