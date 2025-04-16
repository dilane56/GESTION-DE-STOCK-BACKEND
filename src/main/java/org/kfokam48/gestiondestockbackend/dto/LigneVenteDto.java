package org.kfokam48.gestiondestockbackend.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {
    private VentesDto vente;
    @NotNull(message = "la quantité ne doit pas être null")
    @Min(value = 1, message = "La quantité minimale est de 1")
    private BigDecimal quantite;
    @NotNull(message = "le prix ne doit pas être null")
    private BigDecimal prixUnitaire;
}
