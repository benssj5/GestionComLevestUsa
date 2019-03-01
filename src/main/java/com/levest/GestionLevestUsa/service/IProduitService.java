package com.levest.GestionLevestUsa.service;

import java.util.List;

import com.levest.GestionLevestUsa.entities.Produit;

public interface IProduitService {

	public Produit create(Produit p);
	public Produit selectById(Long id);
	public Produit update(Produit p);
	public void delete(Long id);

	public List<Produit> getListProduits();
	public List<Produit> produitsParMotCle(String mc);

}