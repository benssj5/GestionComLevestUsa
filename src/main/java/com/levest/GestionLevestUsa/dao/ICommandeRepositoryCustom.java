package com.levest.GestionLevestUsa.dao;

import java.util.List;

import com.levest.GestionLevestUsa.entities.Commande;

public interface ICommandeRepositoryCustom {


	public List<Commande> selector(Long idCommande, Long idClient, int confirm,
			String startDate, String endDate);

}


