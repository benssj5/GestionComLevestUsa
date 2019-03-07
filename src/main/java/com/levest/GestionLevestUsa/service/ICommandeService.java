package com.levest.GestionLevestUsa.service;

import java.util.List;

import com.levest.GestionLevestUsa.entities.Commande;
import com.levest.GestionLevestUsa.entities.LigneCommande;

public interface ICommandeService {

	public Commande create(Commande c);
	public Commande update(Commande c);
	public Commande selectById(Long id);
	public void delete(Long id);
	public void deleteLigneCommande(Long id);
	public List<Commande> listCommandes();
	public List<LigneCommande> getAllLigneCommandeById(Long id);
	
	public List<Commande> selectByCriterias(Long idCommande, Long idClient, int confirm, String startDate, String endDate);
	
}
