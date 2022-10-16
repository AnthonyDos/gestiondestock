package com.demo.gestiondestock.repository;

import com.demo.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise> {
}
