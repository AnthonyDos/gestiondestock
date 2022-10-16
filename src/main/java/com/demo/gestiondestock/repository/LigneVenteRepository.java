package com.demo.gestiondestock.repository;

import com.demo.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVenteRepository extends JpaRepository<Integer, LigneVente> {
}
