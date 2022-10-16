package com.demo.gestiondestock.controller;

import com.demo.gestiondestock.controller.api.ClientApi;
import com.demo.gestiondestock.dto.CategoryDto;
import com.demo.gestiondestock.dto.ClientDto;
import com.demo.gestiondestock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientController implements ClientApi {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
