package org.kfokam48.gestiondestockbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Adresse {
    private String adresse1;
    private String adresse2;
    private String ville;
    private String postalCode;
    private String pays;
}
