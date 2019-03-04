package com.levest.GestionLevestUsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.levest.GestionLevestUsa.entities.Client;
import com.levest.GestionLevestUsa.service.IClientService;



@Controller
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@RequestMapping("/clients")
	public String index(ModelMap model, Integer edit){
		List<Client> clients = clientService.listClients();
		System.out.println("taille liste client : "+clients.size());
		model.put("clients", clients);
		model.put("edit",edit==null?0:edit.intValue());
		return "clients";
	}	
		

	@RequestMapping("/deleteClient")
	public String deleteClient(ModelMap model,long id) {
		clientService.delete(id);
		return index(model,0);
	}
	
	/**
	 * Affiche le client selectionné pour le modifier
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/printClient")
	public String printClient(ModelMap model,long id) {
		Client c = clientService.selectById(id);
		model.put("client", c);
		
		return index(model,1);
	}
	
	
	@RequestMapping("/addEditClient")
	public String addEditClient(ModelMap model,long id, String nomClient, String adresse, String email, String tel, String commentaire) {
		//if id==0 then we add a client else we modify a client existing
		System.out.println("editClient : " + id);
		Client c = new Client();
		c.setIdClient(id);
		c.setNomClient(nomClient);
		c.setAdresse(adresse);
		c.setEmail(email);
		c.setTel(tel);
		c.setCommentaire(commentaire);
		clientService.update(c);
		return index(model,0);
	}
	
}
