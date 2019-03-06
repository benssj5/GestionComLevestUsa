package com.levest.GestionLevestUsa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.levest.GestionLevestUsa.entities.Commande;
import com.levest.GestionLevestUsa.entities.LigneCommande;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {

	@Query("select lc from LigneCommande lc where lc.commande.idCommande =:x")
	public List<LigneCommande> getAllLigneCommandeById(@Param("x") long commandeId);
	

	
}
