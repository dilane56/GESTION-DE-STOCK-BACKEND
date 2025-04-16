package org.kfokam48.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {
    @NotNull(message = "le code de la commande du fournisseur ne doit pas être null")
    @NotBlank(message = "le code de la commande du fournisseur ne doit pas être vide")
    private String code;
    private Instant dateComande;
    @NotNull(message = "le fournisseur est obligatoire")
    private FournisseurDto fournisseur;
    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseur;

}
