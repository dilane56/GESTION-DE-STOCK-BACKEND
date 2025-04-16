package org.kfokam48.gestiondestockbackend.dto;


import jakarta.validation.constraints.NotNull;
import org.kfokam48.gestiondestockbackend.model.TypeMvtStk;

import java.math.BigDecimal;
import java.time.Instant;

public class MvtStkDto {
    @NotNull(message = "l'article est obligatoire")
    private ArticleDto article;

    private Instant dateMvt;
    private BigDecimal quantite;
    private TypeMvtStk typeMvt;
}
