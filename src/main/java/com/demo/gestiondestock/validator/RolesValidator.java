package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.RolesDto;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validator(RolesDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner le role utilisateur");
            errors.add("veuillez renseigner l'utilisateur");

            return errors;
        }

        if (dto.getRoleName() == null) {
            errors.add("veuillez renseigner le role utilisateur");
        }
        if (dto.getUtilisateur() == null) {
            errors.add("veuillez renseigner l'utilisateur");
        }
        return errors;
    }
}
