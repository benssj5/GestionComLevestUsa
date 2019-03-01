package com.levest.GestionLevestUsa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.levest.GestionLevestUsa.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long> {

	@Query("select p from Produit p where p.description like %:x% ")
	public List<Produit> produitsParMotCle(@Param("x") String mc);
	
}
