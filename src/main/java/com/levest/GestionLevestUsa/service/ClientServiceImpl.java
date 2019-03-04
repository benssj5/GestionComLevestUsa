package com.levest.GestionLevestUsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levest.GestionLevestUsa.dao.IClientRepository;
import com.levest.GestionLevestUsa.entities.Client;
import com.levest.GestionLevestUsa.entities.Commande;
import com.levest.GestionLevestUsa.entities.Produit;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientRepository clientDao;
	
	@Override
	public Client create(Client client) {
		Client c = null;
		//TODO verifier si ce client existe déjà ou pas 
		c = clientDao.save(client);
		return c;
	}

	@Override
	public Client update(Client client) {
		Client c = null;
		//TODO verifier si ce client existe déjà ou pas 
		c = clientDao.save(client);
		return c;
	}
	
	@Override
	public Client selectById(Long id) {
		
		Client c = clientDao.getOne(id);
		return c;
	}

	@Override
	public void delete(Long id) {
		System.out.println("TEST DELETE Client id : " +id);
		//TODO Gerer la suppression des commandes
		List<Commande> list = clientDao.getAllCommandeByClientId(id);
		
		if(list != null && list.size()>0) {
			System.out.println("Ne peut pas supprimer ce Client car au moins une commande y est rattachee");
			throw new RuntimeException("Delete Error : Une commande est liee a ce client");
		} else {
			System.out.println("Delete Client : "+ id + " OK");
			clientDao.deleteById(id);
		}

	}

	@Override
	public List<Client> listClients() {
		List<Client> list = clientDao.findAll();
		return list;
	}



	/**
	 * @return
	 */
	@Override
	public List<Client> getClientsParMotCle(String mc) {
		List<Client> list = clientDao.getClientParMotCle(mc);
		if (list == null) {
			System.out.println("Liste est null");
		} else {

			System.out.println("taille de la liste " + list.size());
		}
		return list;
	}



}
