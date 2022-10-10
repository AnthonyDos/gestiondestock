package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner le nom de l'entreprise");
            errors.add("veuillez renseigner la description de l'entreprise");
            errors.add("veuillez renseigner l'email de l'entreprise");
            errors.add("veuillez renseigner l' adresse de l'entreprise");
            errors.add("veuillez renseigner le code fiscal de l'entreprise");
            errors.add("veuillez renseigner la photo de l'entreprise");
            errors.add("veuillez renseigner l' email de l'entreprise");
            errors.add("veuillez renseigner le numéro de l'entreprise");
            errors.add("veuillez renseigner l' adresse du site de l'entreprise");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("veuillez renseigner la description de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("veuillez renseigner l'email de l'entreprise");
        }
        if (dto.getAdresse() == null) {
            errors.add("veuillez renseigner l' adresse de l'entreprise");
        }
        if (dto.getCodeFiscal() == null) {
            errors.add("veuillez renseigner le code fiscal de l'entreprise");
        }
        if (dto.getPhoto() == null) {
            errors.add("veuillez renseigner la photo de l'entreprise");
        }
        if (dto.getEmail() == null) {
            errors.add("veuillez renseigner l' email de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("veuillez renseigner le numéro de l'entreprise");
        }
        if (dto.getSiteWeb() == null) {
            errors.add("veuillez renseigner l' adresse du site de l'entreprise");
        }

        return errors;
    }
}
