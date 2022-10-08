package com.demo.gestiondestock.dto;

import com.demo.gestiondestock.model.Article;
import com.demo.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    private ArticleDto article;

    private CommandeClientDto commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
}
