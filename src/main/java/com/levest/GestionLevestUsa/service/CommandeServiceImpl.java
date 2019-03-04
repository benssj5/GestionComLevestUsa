package com.levest.GestionLevestUsa.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levest.GestionLevestUsa.dao.ICommandeRepository;
import com.levest.GestionLevestUsa.dao.ILigneCommandeRepository;
import com.levest.GestionLevestUsa.entities.Commande;
import com.levest.GestionLevestUsa.entities.LigneCommande;

@Service
public class CommandeServiceImpl implements ICommandeService {

	@Autowired
	private ICommandeRepository commandeDao;
	
	@Autowired
	private ILigneCommandeRepository lignesCommandesDao;
	
	@Override
	public Commande create(Commande commande) {
		Commande c = null;
		c = commandeDao.save(commande);
		return c;
	}
	
	@Override
	public Commande update(Commande commande) {
		Commande c = null;
		c = commandeDao.save(commande);
		return c;
	}

	@Override
	public Commande selectById(Long id) {
		
		Commande c = commandeDao.getOne(id);
		return c;
	}

	
	@Override
	public void delete(Long id) {
		System.out.println("TEST DELETE Commande id : " +id);
		//TODO Gerer la suppression des LignesCommande
		List<LigneCommande> list = commandeDao.getAllLigneCommandeById(id);
		
		if(list != null && !list.isEmpty()) {
			for(LigneCommande lc : list) {
				lignesCommandesDao.deleteById(lc.getIdLigneCommande());
			}
		}
		
		commandeDao.deleteById(id);
	}
	

	@Override
	public List<Commande> listCommandes() {
		List<Commande> list = commandeDao.findAll();
		return list;
	}

	@Override
	public Commande selectByDate(Long idClient, Date date) {
		// TODO A FAIRE
		return null;
	}




}
