package org.kfokam48.gestiondestockbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commandeclient")
public class CommandeClient  extends AbstractEntity{

    private String code;
    private Instant dateCommande;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
