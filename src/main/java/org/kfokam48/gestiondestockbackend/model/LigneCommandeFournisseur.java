package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {

//    @ManyToOne
//    @JoinColumn(name = "fournisseur_id")
//    private Fournisseur fournisseur;
    @ManyToOne
    @JoinColumn(name = "commandefournisseur_id")
    private CommandeFournisseur commandeFournisseur;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private BigDecimal quantite;
    private BigDecimal prixUnitaire;

}
