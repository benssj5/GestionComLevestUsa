package com.levest.GestionLevestUsa.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.levest.GestionLevestUsa.entities.Commande;
import com.levest.GestionLevestUsa.entities.Produit;
import com.levest.GestionLevestUsa.service.ICommandeService;



@Controller
public class CommandeController {

	@Autowired
	private ICommandeService commandeService;
	
	@RequestMapping("/commandes")
	public String index(ModelMap model, Integer edit){
		List<Commande> commandes = commandeService.listCommandes();
		System.out.println("taille liste commande : "+commandes.size());
		model.put("commandes", commandes);
		model.put("edit",edit==null?0:edit.intValue());
		return "commandes";
	}	
		

	@RequestMapping("/deleteCommande")
	public String deleteCommande(ModelMap model,long id) {
		commandeService.delete(id);
		return index(model,0);
	}
	
	/**
	 * Affiche le commande selectionné pour le modifier
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/printCommande")
	public String printCommande(ModelMap model,long id) {
		Commande c = commandeService.selectById(id);
		model.put("commande", c);
		
		return index(model,1);
	}
	
	
	@RequestMapping("/addEditCommande")
	public String addEditCommande(ModelMap model,long id, Date date) {
		//if id==0 then we add a commande else we modify a commande existing
		System.out.println("editCommande : " + id);
		Commande c = new Commande();
		c.setIdCommande(id);
		c.setDateCommande(date);
		commandeService.update(c);
		return index(model,0);
	}
	
	/**
	 * Search with criteria name and/or description
	 * @param model
	 * @param nomProduit
	 * @return
	 */
	@RequestMapping("/searchCommande")
	public String searchCommande(ModelMap model,String nomCommande) {
		System.out.println("searchCommande ");
		List<Commande> commandes = null;//commandeService.getCommandesParMotCle(nomCommande);
		System.out.println("searchCommande : "+commandes.size());
		model.put("commandes", commandes);
		model.put("edit",0);
		
		return "commandes";
	}
	
}
