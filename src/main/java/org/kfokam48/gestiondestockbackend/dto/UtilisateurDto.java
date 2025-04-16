package org.kfokam48.gestiondestockbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.Instant;
import java.util.List;

@Data
public class UtilisateurDto {
    @NotNull(message = "le nom de l'utilisateur ne doit pas être null")
    @NotBlank(message = "le nom de l'utilisateur ne doit pas être vide")
    private String nom;
    private String prenom;
    @NotNull(message = "le mail de l'utilisateur ne doit pas être null")
    @NotBlank(message = "le mail de l'utilisateur ne doit pas être vide")
    private String email;
    @NotNull(message = "le password de l'utilisateur ne doit pas être null")
    @NotBlank(message = "le password de l'utilisateur ne doit pas être vide")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La date doit être dans le passé")
    private Instant dateNaissance;
    private AdresseDto adresse;
    private String photo;
    @NotNull(message = "l'entreprise est obligatoire")
    private EntrepriseDto entreprise;
    @JsonIgnore
    private List<RoleDto> roles;
}
