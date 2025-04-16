package org.kfokam48.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.kfokam48.gestiondestockbackend.model.CommandeFournisseur;

import java.util.List;

@Data
@Builder
public class FournisseurDto {
    @NotNull(message = "le nom du fournisseur ne doit pas être null")
    @NotBlank(message = "le nom du fournisseur ne doit pas être vide")
    private String nom;
    private String prenom;
    private String adresse;
    private String mail;
    @NotNull(message = "le tel du fournisseur ne doit pas être null")
    @NotBlank(message = "le tel du fournisseur ne doit pas être vide")
    private String numTel;
    private String photo;
    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurs;
}
