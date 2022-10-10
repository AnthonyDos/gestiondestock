package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner le nom du fournisseur");
            errors.add("veuillez renseigner le prénom du fournisseur");
            errors.add("veuillez renseigner l'email du fournisseur");
            errors.add("veuillez renseigner le numéro du fournisseur");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("veuillez renseigner le prénom du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("veuillez renseigner l'email du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("veuillez renseigner le numéro du fournisseur");
        }

        return errors;
    }
}
