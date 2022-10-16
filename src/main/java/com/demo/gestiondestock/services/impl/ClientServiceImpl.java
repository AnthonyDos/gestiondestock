package com.demo.gestiondestock.services.impl;

import com.demo.gestiondestock.dto.ClientDto;
import com.demo.gestiondestock.exception.EntityNotFoundException;
import com.demo.gestiondestock.exception.ErrorCodes;
import com.demo.gestiondestock.exception.InvalidEntityException;
import com.demo.gestiondestock.model.Client;
import com.demo.gestiondestock.repository.ClientRepository;
import com.demo.gestiondestock.services.ClientService;
import com.demo.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is Not valid", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_FOUND, errors);
        }

        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client Id is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);

        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() -> new EntityNotFoundException(
                "Aucun client avec l'id" + id + "n'a été trouver dans la bdd",
                ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {

        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client Id is null");
            return;
        }

        clientRepository.deleteById(id);
    }
}
