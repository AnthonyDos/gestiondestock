//package com.demo.gestiondestock.validator;
//
//import com.demo.gestiondestock.dto.CommandeClientDto;
//import org.springframework.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CommandeClientValidator {
//
//    public static List<String> validator(CommandeClientDto dto) {
//
//        List<String> errors = new ArrayList<>();
//
//        if (dto == null) {
//            errors.add("veuillez renseigner le code de commande");
//            errors.add("veuillez renseigner la date de commande");
//            errors.add("veuillez renseigner le client de la commande");
//            errors.add("le champ nom client est obligatoire");
//            errors.add("le champ prénom client est obligatoire");
//            errors.add("le champ numéro client est obligatoire");
//            errors.add("le champ email client est obligatoire");
//            return errors;
//        }
//        if (dto.getCode() == null) {
//            errors.add("veuillez renseigner le code de commande");
//        }
//        if (dto.getDateCommande() == null) {
//            errors.add("veuillez renseigner la date de commande");
//        }
//        if (dto.getClient() == null) {
//            errors.add("veuillez renseigner le client de la commande");
//        }else {
//            if (!StringUtils.hasLength(dto.getClient().getNom())) {
//                errors.add("le champ nom client est obligatoire");
//            }
//            if (!StringUtils.hasLength(dto.getClient().getPrenom())) {
//                errors.add("le champ prénom client est obligatoire");
//            }
//            if (!StringUtils.hasLength(dto.getClient().getNumTel())) {
//                errors.add("le champ numéro client est obligatoire");
//            }
//            if (!StringUtils.hasLength(dto.getClient().getEmail())) {
//                errors.add("le champ email client est obligatoire");
//            }
//        }
//
//        return errors;
//    }
//}
