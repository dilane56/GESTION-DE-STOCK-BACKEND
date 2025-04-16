package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends AbstractEntity {

    private String code;
     private Instant dateComande;

     @ManyToOne()
     @JoinColumn(name = "fournisseur_id")
     private Fournisseur fournisseur;
     @OneToMany(mappedBy = "commandeFournisseur")
     private List<LigneCommandeFournisseur>ligneCommandeFournisseur;



}
