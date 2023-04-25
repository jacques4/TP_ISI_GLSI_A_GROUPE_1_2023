package com.iai.togo.ProjetBanque.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.iai.togo.ProjetBanque.enums.TypeCompte;
import java.time.LocalDate;
@Entity
@Table(name="Comptes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name="numCompte")
    private String numCompte;
    @Column(name="typeCompte")
    private TypeCompte typeCompte;
    @Column(name="datecreation")
    private LocalDate dateCreation;
    @Column(name="soldeCompte")
    private Double soldeCompte;
    @ManyToOne
    @JoinColumn(name="IdClient")
    private Client proprietaire;
}
