package org.kfokam48.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.kfokam48.gestiondestockbackend.model.Article;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    @NotNull(message = "le code de la catégorie ne doit pas être null")
    @NotBlank(message = "le code de la catégorie ne doit pas être vide")
    private String code;
    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;
}
