package org.kfokam48.gestiondestockbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {
    @NotNull(message = "l'adresse1 est obligatoire")
    @NotBlank(message = "veiller renseigner l'adresse")
    private String adresse1;
    private String adresse2;
    @NotNull(message = "le champ ville est obligatoire")
    @NotBlank(message = "Veillez renseigner la ville")
    private String ville;
    private String postalCode;
    @NotNull(message = "le pays est obligatoire")
    @NotBlank(message = "veiller renseigner le pays")
    private String pays;
}
