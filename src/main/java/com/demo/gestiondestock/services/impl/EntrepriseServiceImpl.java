package com.demo.gestiondestock.services.impl;

import com.demo.gestiondestock.dto.ArticleDto;
import com.demo.gestiondestock.dto.EntrepriseDto;
import com.demo.gestiondestock.exception.EntityNotFoundException;
import com.demo.gestiondestock.exception.ErrorCodes;
import com.demo.gestiondestock.exception.InvalidEntityException;
import com.demo.gestiondestock.model.Article;
import com.demo.gestiondestock.model.Entreprise;
import com.demo.gestiondestock.repository.ArticleRepository;
import com.demo.gestiondestock.repository.EntrepriseRepository;
import com.demo.gestiondestock.services.EntrepriseService;
import com.demo.gestiondestock.validator.ArticleValidator;
import com.demo.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entreprise is not valid", dto);
            throw new InvalidEntityException("l'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_FOUND, errors);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Entreprise Id is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException(
                "Aucune entreprise avec l'id = " + id + "n'a été trouver dans la bdd",
                ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public EntrepriseDto findByCodeFiscal(String codeFiscal) {
        if (!StringUtils.hasLength(codeFiscal)) {
            log.error("Entreprise code is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByCodeFiscal(codeFiscal);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException(
                "Aucune entreprise avec le code = " + codeFiscal + "n'a été trouver dans la bdd",
                ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {

        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Entreprise Id is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
