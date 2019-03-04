package com.levest.GestionLevestUsa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.levest.GestionLevestUsa.entities.Client;
import com.levest.GestionLevestUsa.entities.Commande;
import com.levest.GestionLevestUsa.entities.Produit;

public interface IClientRepository extends JpaRepository<Client, Long> {

	@Query("select c from Commande c where c.client.idClient =:x")
	public List<Commande> getAllCommandeByClientId(@Param("x") long clientId);
	
	@Query("select c from Client c where c.nomClient like %:x% OR c.adresse like %:x% OR c.commentaire like %:x% ")
	public List<Client> getClientParMotCle(@Param("x") String mc);

	
}
