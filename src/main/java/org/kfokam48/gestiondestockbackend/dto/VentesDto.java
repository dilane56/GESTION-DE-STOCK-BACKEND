package org.kfokam48.gestiondestockbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class VentesDto {
    @NotNull(message = "le code  ne doit pas être null")
    @NotBlank(message = "le code  ne doit pas être vide")
    private String code;
    private Instant dateVente;
    private String commentaire;
}
