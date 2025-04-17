package org.kfokam48.gestiondestockbackend.repository;

import org.kfokam48.gestiondestockbackend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByCodeArticle(String code);
}
