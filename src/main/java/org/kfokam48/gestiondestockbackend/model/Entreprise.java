package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Entreprise extends AbstractEntity {
    private String nom;
    private String description;
    @Embedded
    private Adresse adresse;
    private String codeFiscal;
    private String photo;
    private String mail;
    private String telephone;
    private String siteWeb;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

}
