package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MvtStk extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private Instant dateMvt;
    private BigDecimal quantite;
    private TypeMvtStk typeMvt;
}
