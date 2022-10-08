package com.demo.gestiondestock.dto;

import com.demo.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    private Ventes ventes;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
}
