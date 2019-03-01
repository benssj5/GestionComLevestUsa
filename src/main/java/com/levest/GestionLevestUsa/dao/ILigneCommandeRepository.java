package com.levest.GestionLevestUsa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levest.GestionLevestUsa.entities.LigneCommande;

public interface ILigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

}
