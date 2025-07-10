package com.hiobi.Gestion_StockProd.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Table(name = "produits")

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String nom;
    private int quantite;
    private double prix;

    public Produit() {

    }

    public Produit(String nom, long id, int quantite, double prix) {
        this.nom = nom;
        this.id = id;
        this.quantite = quantite;
        this.prix = prix;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
