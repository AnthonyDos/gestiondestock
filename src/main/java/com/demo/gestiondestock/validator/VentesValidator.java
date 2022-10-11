package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.VentesDto;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {

    public static List<String> validator(VentesDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner le code de vente");
            errors.add("veuillez renseigner la date de vente");
            errors.add("veuillez renseigner le commentaire de vente");

            return errors;
        }

        if (dto.getCode() == null) {
            errors.add("veuillez renseigner le code de vente");
        }
        if (dto.getDateVente() == null) {
            errors.add("veuillez renseigner la date de vente");
        }
        if (dto.getCommentaire() == null) {
            errors.add("veuillez renseigner le commentaire de vente");
        }

        return errors;
    }
 }
