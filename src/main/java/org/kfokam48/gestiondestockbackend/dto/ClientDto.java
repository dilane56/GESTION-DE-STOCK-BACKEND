package org.kfokam48.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.kfokam48.gestiondestockbackend.model.CommandeClient;

import java.util.List;

@Data
@Builder
public class ClientDto {
    @NotNull(message = "Le nom du client ne doit pas être null")
    @NotBlank(message = "\"Le nom du client ne doit pas être vide")
    private String nom;
    private String prenom;
    private String mail;
    private String photo;
    @NotNull(message = "Le tel du client ne doit pas être null")
    @NotBlank(message = "Le tel du client ne doit pas être vide")
    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandes;
}
