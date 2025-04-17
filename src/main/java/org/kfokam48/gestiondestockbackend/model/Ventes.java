package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ventes extends AbstractEntity{

    private String code;
    private Instant dateVente;
    private String commentaire;
}
