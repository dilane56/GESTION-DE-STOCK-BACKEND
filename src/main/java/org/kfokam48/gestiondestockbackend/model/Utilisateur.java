package org.kfokam48.gestiondestockbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Utilisateur extends AbstractEntity {

    private String nom;
    private String prenom;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private Instant dateNaissance;
    @Embedded
    private Adresse adresse;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.EAGER)
    private List<Roles> roles;
}
