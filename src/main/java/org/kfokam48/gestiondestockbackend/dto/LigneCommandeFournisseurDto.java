package org.kfokam48.gestiondestockbackend.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;


import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    @NotNull(message = "la commande du fournisseur est obligatoire")
    private CommandeFournisseurDto commandeFournisseur;
    @NotNull(message = "l'article est obligatoire")
    private ArticleDto article;
    @NotNull(message = "la quantité ne doit pas être null")
    @Min(value = 1, message = "La quantité minimale est de 1")
    private BigDecimal quantite;
    @NotNull(message = "le prix ne doit pas être null")
    private BigDecimal prixUnitaire;

}
