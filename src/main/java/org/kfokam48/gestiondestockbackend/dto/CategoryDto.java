package org.kfokam48.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
public class CategoryDto {

    @NotNull(message = "Le code de la catégorie ne doit pas être null")
    @NotBlank(message = "Le code de la catégorie ne doit pas être vide")
    private String code;
    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;


}
