package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Fournisseur extends  AbstractEntity {

    private String nom;
    private String prenom;
    private String adresse;
    @Column(unique = true, nullable = false)
    private String mail;
    private String numTel;
    private String photo;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
