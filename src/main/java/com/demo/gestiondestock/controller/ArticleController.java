package com.demo.gestiondestock.controller;

import com.demo.gestiondestock.controller.api.ArticleApi;
import com.demo.gestiondestock.dto.ArticleDto;
import com.demo.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    //3 types d'injection possible
    //Field injection : injection par champs ou par variable
//    @Autowired
//    private ArticleService articleService;

    //Getter injection : injection par champs ou par variable et sera injecter lorsque l on fait appel articleService
//    @Autowired
//    public ArticleService getArticleService(){
//        return articleService;
//    }

    //Constructor injection : autowired permet d injecter ou de créer des instances

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
