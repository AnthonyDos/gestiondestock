package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner le nom d'utilisateur");
            errors.add("veuillez renseigner le prénom d'utilisateur");
            errors.add("veuillez renseigner l'email d'utilisateur");
            errors.add("veuillez renseigner le mot de passe utilisateur");
            errors.add("veuillez renseigner la date de naissance d'utilisateur");
            errors.add("veuillez renseigner l' adresse d'utilisateur");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("veuillez renseigner le prénom d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("veuillez renseigner l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getMotDePasse())) {
            errors.add("veuillez renseigner le mot de passe utilisateur");
        }
        if (dto.getDateDeNaissance() == null) {
            errors.add("veuillez renseigner la date de naissance d'utilisateur");
        }
        if (dto.getAdresse() == null) {
            errors.add("veuillez renseigner l' adresse d'utilisateur");
        }else {
            if (!StringUtils.hasLength(dto.getAdresse().getAdresse1())) {
                errors.add("le champ adresse 1 est obligatoire");
            }
            if (!StringUtils.hasLength(dto.getAdresse().getCodePostal())) {
                errors.add("le champ code postal est obligatoire");
            }
            if (!StringUtils.hasLength(dto.getAdresse().getVille())) {
                errors.add("le champ ville est obligatoire");
            }
            if (!StringUtils.hasLength(dto.getAdresse().getPays())) {
                errors.add("le champ pays est obligatoire");
            }
        }
        return errors;
    }
}
