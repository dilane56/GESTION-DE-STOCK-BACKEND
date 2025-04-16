package org.kfokam48.gestiondestockbackend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.kfokam48.gestiondestockbackend.model.Article;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    @NotNull(message = "l'article est obligatoire")
    private ArticleDto article;
    @NotNull(message = "la commande est obligatoire")
    private CommandeClientDto commandeClient;
    @NotNull(message = "la quantité ne doit pas être null")
    @Min(value = 1, message = "La quantité minimale est de 1")
    private BigDecimal quantite;
    @NotNull(message = "le prix ne doit pas être null")
    private BigDecimal prixUnitaire;
}
