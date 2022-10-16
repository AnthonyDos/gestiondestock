package com.demo.gestiondestock.repository;

import com.demo.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Integer, Article> {


}
