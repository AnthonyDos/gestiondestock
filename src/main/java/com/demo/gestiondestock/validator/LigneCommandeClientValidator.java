package com.demo.gestiondestock.validator;

import com.demo.gestiondestock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validator(LigneCommandeClientDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("veuillez renseigner l'article");
            errors.add("veuillez renseigner le client");
            errors.add("veuillez renseigner la quantité");
            errors.add("veuillez renseigner le prix unitaire");
            return errors;
        }

        if (dto.getArticle() == null) {
            errors.add("veuillez renseigner l'article");
        }
        if (dto.getCommandeClient().getClient() == null){
            errors.add("veuillez renseigner le client");
        }
        if (dto.getQuantite() == null){
            errors.add("veuillez renseigner la quantité");
        }
        if (dto.getPrixUnitaire() == null){
            errors.add("veuillez renseigner le prix unitaire");
        }

        return errors;
    }
}
