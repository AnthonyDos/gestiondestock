package com.demo.gestiondestock.services;

import com.demo.gestiondestock.dto.ArticleDto;

import java.util.List;

//les interfaces defini un contrat de service
public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
