//package com.demo.gestiondestock.validator;
//
//import com.demo.gestiondestock.dto.LigneVenteDto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LigneVenteValidator {
//
//    public static List<String> validator(LigneVenteDto dto) {
//
//        List<String> errors = new ArrayList<>();
//
//        if (dto == null) {
//            errors.add("veuillez renseigner la vente");
//            errors.add("veuillez renseigner le prix unitaire");
//            errors.add("veuillez renseigner la quantité");
//
//            return errors;
//        }
//
//        if (dto.getVentes() == null) {
//            errors.add("veuillez renseigner la vente");
//        }
//        if (dto.getPrixUnitaire() == null) {
//            errors.add("veuillez renseigner le prix unitaire");
//        }
//        if (dto.getQuantite() == null) {
//            errors.add("veuillez renseigner la quantité");
//        }
//
//
//        return errors;
//    }
//}
