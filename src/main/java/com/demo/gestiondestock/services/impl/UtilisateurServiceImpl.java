package com.demo.gestiondestock.services.impl;

import com.demo.gestiondestock.dto.FournisseurDto;
import com.demo.gestiondestock.dto.UtilisateurDto;
import com.demo.gestiondestock.exception.EntityNotFoundException;
import com.demo.gestiondestock.exception.ErrorCodes;
import com.demo.gestiondestock.exception.InvalidEntityException;
import com.demo.gestiondestock.model.Fournisseur;
import com.demo.gestiondestock.model.Utilisateur;
import com.demo.gestiondestock.repository.UtilisateurRepository;
import com.demo.gestiondestock.services.UtilisateurService;
import com.demo.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid", dto);
            throw new InvalidEntityException("l'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_FOUND, errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("utilisateur id is null");
            return null;
        }

        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() -> new EntityNotFoundException(
                "Aucun utilisateur avec l'id = " + id + "n'a été trouver dans la bdd",
                ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {

        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("utilisateur Id is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }
}
