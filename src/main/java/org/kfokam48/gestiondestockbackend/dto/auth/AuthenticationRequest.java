package org.kfokam48.gestiondestockbackend.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthenticationRequest {

    @NotNull(message = "L'email ne doit pas être null")
    @NotBlank(message = "L'email ne dit pas être vide")
    private String login;
    @NotNull(message = "Le mot de passe ne doit pas être null")
    @NotBlank(message = "Le mot de passe ne doit pas être vide")
    private String password;
}
