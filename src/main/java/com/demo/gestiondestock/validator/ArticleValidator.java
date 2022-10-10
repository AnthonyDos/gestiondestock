package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la designation de l'article");
            errors.add("Veuillez renseigner le prix unitaire ht de l'article");
            errors.add("Veuillez renseigner la tva de l'article");
            errors.add("Veuillez renseigner la catégorie de l'article");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getCodeArticle())){
            errors.add("Veuillez renseigner le code de l'article");
        }
        if (!StringUtils.hasLength(dto.getDesignation())){
            errors.add("Veuillez renseigner la designation de l'article");
        }
        if (dto.getPrixUnitaireHt() == null){
            errors.add("Veuillez renseigner le prix unitaire ht de l'article");
        }
        if (dto.getTauxTva() == null){
            errors.add("Veuillez renseigner la tva de l'article");
        }
        if (dto.getCategory() == null){
            errors.add("Veuillez renseigner la catégorie de l'article");
        }
        return errors;
    }
}
