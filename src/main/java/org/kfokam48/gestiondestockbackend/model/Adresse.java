package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse implements Serializable {
    private String adresse1;
    private String adresse2;
    private String ville;
    private String postalCode;
    private String pays;
}
