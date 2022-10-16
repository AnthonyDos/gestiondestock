package com.demo.gestiondestock.repository;

import com.demo.gestiondestock.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<Integer, MvtStk> {
}
