package org.kfokam48.gestiondestockbackend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.kfokam48.gestiondestockbackend.model.Category;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {

    @NotNull(message = "le code de l'article ne doit pas être null")
    @NotBlank(message = "le code de l'article ne doit pas être vide")
    private String codeArticle;
    private String designation;
    @NotNull(message = "Le prix de l'article ne doit pas être null")
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxTVA;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    @NotNull(message = "la catégorie est obligatoire")
    private CategoryDto category;

}
