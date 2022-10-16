package com.demo.gestiondestock.controller.api;

import com.demo.gestiondestock.dto.ArticleDto;
import com.demo.gestiondestock.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.demo.gestiondestock.utils.Constants.APP_ROOT;

public interface EntrepriseApi {

    @PostMapping(value = APP_ROOT + "/entreprise/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(value = APP_ROOT + "/entreprise/{idEntreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(value = APP_ROOT + "/entreprise/{codeFiscal}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByCodeFiscal(@PathVariable("codeFiscal") String codeFiscal);

    @GetMapping(value = APP_ROOT + "/entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/entreprise/delete/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);
}
