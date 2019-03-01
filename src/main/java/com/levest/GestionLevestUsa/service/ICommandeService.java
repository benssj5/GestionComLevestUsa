package com.levest.GestionLevestUsa.service;

import java.util.Date;
import java.util.List;

import com.levest.GestionLevestUsa.entities.Commande;

public interface ICommandeService {

	public Commande create(Commande c);
	public Commande selectById(Long id);
	public void delete(Long id);
	public List<Commande> listCommandes();
	
	public Commande selectByDate(Long idClient, Date date);
	
}
