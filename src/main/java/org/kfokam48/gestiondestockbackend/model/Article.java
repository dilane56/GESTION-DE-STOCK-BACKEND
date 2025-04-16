package org.kfokam48.gestiondestockbackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Article  extends AbstractEntity{

   private String codeArticle;
   private String designation;
   private BigDecimal prixUnitaireHt;
   private BigDecimal tauxTVA;
   private BigDecimal prixUnitaireTtc;
   private String photo;
   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;



}
