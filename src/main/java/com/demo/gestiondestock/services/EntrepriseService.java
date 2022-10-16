package com.demo.gestiondestock.services;

import com.demo.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByCodeFiscal(String codeFiscal);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
