package com.levest.GestionLevestUsa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LigneCommande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigneCommande;
	@ManyToOne
	@JoinColumn(name = "idProduit")
	private Produit produit;
	private double prix;
	private int quantite;
	@ManyToOne
	@JoinColumn(name = "idCommande")
	private Commande commande;

	/**
	 * 
	 * @return id de LigneCommande
	 */
	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	/**
	 * 
	 * @param id
	 */
	public void setIdLigneCommande(Long id) {
		this.idLigneCommande = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public LigneCommande() {
		super();
	}

	public LigneCommande(Produit produit,int quantite, Long idCommande) {
		super();
		this.quantite = quantite;
		this.produit = produit;
		this.commande = new Commande(idCommande);
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}