package org.kfokam48.gestiondestockbackend.model;

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
@Entity
public class Category extends  AbstractEntity {
    private String code;
    private String designation;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
