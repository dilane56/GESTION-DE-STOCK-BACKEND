package org.kfokam48.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.kfokam48.gestiondestockbackend.model.Adresse;
import org.kfokam48.gestiondestockbackend.model.Utilisateur;

import java.util.List;

public class EntrepriseDto {
    @NotNull(message = "le nom de l'entreprise ne doit pas être null")
    @NotBlank(message = "le nom de l'entreprise ne doit pas être vide")
    private String nom;
    private String description;
    private AdresseDto adresse;
    private String codeFiscal;
    private String photo;
    @NotNull(message = "le mail de l'entreprise ne doit pas être null")
    @NotBlank(message = "le mail de l'entreprise ne doit pas être vide")
    private String mail;
    private String telephone;
    private String siteWeb;
    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;
}
