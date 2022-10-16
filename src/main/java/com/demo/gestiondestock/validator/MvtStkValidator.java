//package com.demo.gestiondestock.validator;
//
//import com.demo.gestiondestock.dto.MvtStkDto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MvtStkValidator {
//
//    public static List<String> validator(MvtStkDto dto) {
//
//        List<String> errors = new ArrayList<>();
//
//        if (dto == null) {
//            errors.add("veuillez renseigner la date MvtStk");
//            errors.add("veuillez renseigner la quantité");
//            errors.add("veuillez renseigner l'article");
//            errors.add("veuillez renseigner le type MvtStk");
//            return errors;
//        }
//
//        if (dto.getDateMvt() == null) {
//            errors.add("veuillez renseigner la date MvtStk");
//        }
//        if (dto.getQuantite() == null) {
//            errors.add("veuillez renseigner la quantité");
//        }
//        if (dto.getArticle() == null) {
//            errors.add("veuillez renseigner l'article");
//        }
//        if (dto.getTypeMvtStk() == null) {
//            errors.add("veuillez renseigner le type MvtStk");
//        }
//        return errors;
//    }
//}
