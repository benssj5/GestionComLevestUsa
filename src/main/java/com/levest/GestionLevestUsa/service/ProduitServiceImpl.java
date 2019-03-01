package com.levest.GestionLevestUsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levest.GestionLevestUsa.dao.IProduitRepository;
import com.levest.GestionLevestUsa.entities.Produit;

@Service
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	IProduitRepository produitDao;

	@Override
	public Produit create(Produit p) {

		Produit produit = produitDao.save(p);

		return produit;
	}

	@Override
	public void delete(Long id) {
		System.out.println("DELETE Produit id : " + id);
		produitDao.deleteById(id);

	}

	@Override
	public Produit update(Produit p) {

		Produit p2 = produitDao.save(p);

		return p2;
	}

	@Override
	public List<Produit> getListProduits() {

		List<Produit> list = produitDao.findAll();

		return list;
	}

	@Override
	public Produit selectById(Long id) {

		Produit c = produitDao.getOne(id);
		return c;
	}

	@Override
	/**
	 * @return
	 */
	public List<Produit> produitsParMotCle(String mc) {
		List<Produit> listes = produitDao.produitsParMotCle(mc);
		if (listes == null) {
			System.out.println("Liste est null");
		} else {

			System.out.println("taille de la liste " + listes.size());
		}
		return listes;
	}


}