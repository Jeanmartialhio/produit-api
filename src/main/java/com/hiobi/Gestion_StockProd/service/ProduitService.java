package com.hiobi.Gestion_StockProd.service;


import com.hiobi.Gestion_StockProd.model.Produit;
import com.hiobi.Gestion_StockProd.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {

        this.produitRepository = produitRepository;
    }

    public List<Produit> getAllProduits() {

        return produitRepository .findAll();
    }


    // Ajouter un  produit
    public Produit createProduit(Produit produit) {
        return produitRepository .save(produit);
    }
    // Rechercher un produit
    public Produit getProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if(optionalProduit.isEmpty()){
            throw  new RuntimeException("désolé le produit n'existe pas");
        }
        return optionalProduit.get();
    }


    // Supprimer un produit
    public String deleteProduitById(long idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);

        if(optionalProduit.isEmpty()){
            throw  new RuntimeException("Suppression impossible le produit n'existe pas");
        }
        produitRepository.delete(optionalProduit.get());
        return "Produit supprimé avec succès";
    }

    // Modifier un produit
    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if(optionalProduit.isEmpty()){
            throw  new RuntimeException("Modification impossible le produit n'existe pas");
        }
        Produit produitAModifier= optionalProduit.get();
        produitAModifier.setNom(produit.getNom());
        produitAModifier.setQuantite(produit.getQuantite());
        produitAModifier.setPrix(produit.getPrix());

        return produitRepository.save(produitAModifier);
    }
}
