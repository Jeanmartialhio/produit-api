package com.hiobi.Gestion_StockProd.repository;

import com.hiobi.Gestion_StockProd.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository <Produit, Long> {

}
