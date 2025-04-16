package org.kfokam48.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.kfokam48.gestiondestockbackend.model.Client;
import org.kfokam48.gestiondestockbackend.model.LigneCommandeClient;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {

    @NotNull(message = "le code de la commande du client ne doit pas être null")
    @NotBlank(message = "le code de la commande du client ne doit pas être vide")
    private String code;
    private Instant dateCommande;
    @NotNull(message = "le client est obligatoire")
    private ClientDto client;

    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClients;
}
