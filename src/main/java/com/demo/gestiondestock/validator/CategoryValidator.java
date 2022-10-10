package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    //il prend une liste de validation
    public static List<String>validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        //vérification si code est null ou vide
        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            //ajout d'un message d'erreur
            errors.add("veuillez remplir le code de la catégorie");
        }
        return errors;
    }
}
