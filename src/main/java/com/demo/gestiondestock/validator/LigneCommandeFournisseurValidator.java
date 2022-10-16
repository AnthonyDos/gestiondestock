//package com.demo.gestiondestock.validator;
//
//
//import com.demo.gestiondestock.dto.LigneCommandeFournisseurDto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LigneCommandeFournisseurValidator {
//
//    public static List<String> validator(LigneCommandeFournisseurDto dto) {
//
//        List<String> errors = new ArrayList<>();
//
//        if (dto == null) {
//            errors.add("veuillez renseigner l'article");
//            errors.add("veuillez renseigner la commande fournisseur");
//            errors.add("veuillez renseigner la  quantité");
//            errors.add("veuillez renseigner le prix unitaire");
//
//            return errors;
//        }
//
//        if (dto.getArticle() == null) {
//            errors.add("veuillez renseigner l'article");
//        }
//        if (dto.getCommandeFournisseur() == null) {
//            errors.add("veuillez renseigner la commande fournisseur");
//        }
//        if (dto.getQuantite() == null) {
//            errors.add("veuillez renseigner la  quantité");
//        }
//        if (dto.getPrixUnitaire() == null) {
//            errors.add("veuillez renseigner le prix unitaire");
//        }
//
//        return errors;
//    }
//}
