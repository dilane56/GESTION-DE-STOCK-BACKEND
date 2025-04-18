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
@Table(name = "lignecommandeclient")
public class LigneCommandeClient extends AbstractEntity {

   @ManyToOne
   @JoinColumn(name = "article_id")
    private Article article;

   @ManyToOne
   @JoinColumn(name = "commandeclient_id")
   private CommandeClient commandeClient;

   private BigDecimal quantite;
   private BigDecimal prixUnitaire;


}
