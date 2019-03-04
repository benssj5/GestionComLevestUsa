package com.levest.GestionLevestUsa.service;

import java.util.List;

import com.levest.GestionLevestUsa.entities.Client;

public interface IClientService {

	public Client create(Client c);
	public Client update(Client c);
	public Client selectById(Long id);
	public void delete(Long id);
	public List<Client> listClients();
	
}