package com.hiobi.Gestion_StockProd.controller;


import com.hiobi.Gestion_StockProd.model.Produit;
import com.hiobi.Gestion_StockProd.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/version1/produits")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }
    //  Liste  des produits
    @GetMapping("/all")
    public List<Produit> getAllProduit(){
        return produitService.getAllProduits();
    }

    // Ajouter un  produit
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }

    // Rechercher un produit
     @GetMapping("{id}")
    public Produit getProduitById(@PathVariable long id){
        return produitService.getProduitById(id);
     }

     // Modifier un produit
    @PutMapping("{id}")
    public Produit editProduit(@PathVariable long id, @RequestBody Produit produit){
        return produitService.editProduit(id,  produit);
    }


     // Supprimer un produit
    @DeleteMapping("{id}")
    public String deleteProduitById(@PathVariable("id") long idProduit){
        return produitService.deleteProduitById(idProduit);

    }

}
