package org.kfokam48.gestiondestockbackend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;

@Data
public class RoleDto {
    @NotNull(message = "le role ne doit pas être null")
    @NotBlank(message = "le role ne doit pas être vide")
    private String roleName;
    @NotNull(message = "l'utilisateur est obligatoire")
    private UtilisateurDto utilisateur;
}
