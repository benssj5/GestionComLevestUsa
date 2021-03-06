package com.levest.GestionLevestUsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.levest.GestionLevestUsa.entities.Client;
import com.levest.GestionLevestUsa.entities.Commande;
import com.levest.GestionLevestUsa.entities.LigneCommande;
import com.levest.GestionLevestUsa.entities.Produit;
import com.levest.GestionLevestUsa.service.IClientService;
import com.levest.GestionLevestUsa.service.ICommandeService;
import com.levest.GestionLevestUsa.service.IProduitService;



@Controller
public class CommandeController {

	@Autowired
	private ICommandeService commandeService;
	@Autowired
	private IClientService clientService;
	@Autowired
	private IProduitService produitService;
	
	@RequestMapping("/commandes")
	public String index(ModelMap model, Integer edit){
		
		List<Commande> commandes = commandeService.listCommandes();
		
		List<Client> clients = getListClientsSelector();
		
		model.put("commandes", commandes);
		model.put("clients", clients);
		model.put("edit",edit==null?0:edit.intValue());
		return "commandes";
	}	
		

	@RequestMapping("/deleteCommande")
	public String deleteCommande(ModelMap model,long id) {
		commandeService.delete(id);
		return index(model,0);
	}
	
	/**
	 * Affiche le commande selectionnée
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/printCommande")
	public String printCommande(ModelMap model,long id, Integer edit) {
		Commande commande = commandeService.selectById(id);
		
		List<Client> clients = clientService.listClients();
		List<Produit> produits = produitService.getListProduits();
		
		model.put("lc", null);
		model.put("commande", commande);
		model.put("produits", produits);
		model.put("clients", clients);
		model.put("edit",edit==null?0:edit.intValue());
		return "printCommande";
	}
	
		
	/**
	 * Search with criteria name and/or description
	 * @param model
	 * @param nomProduit
	 * @return
	 */
	@RequestMapping("/searchCommande")
	public String searchCommande(ModelMap model,String idCommande, String idClient, int confirm, String startDate, String endDate) {
		System.out.println("searchCommande\n idCommande = " + idCommande);
		System.out.println("idClient = " + idClient);
		System.out.println("confirm = " + confirm);
		System.out.println("start date = " + startDate);
		System.out.println("end date = " + endDate);
		
		//LocalDate date3 = LocalDate.of(startDate);
		
		
		List<Commande> commandes = commandeService.selectByCriterias((idCommande==null || idCommande.equals(""))?new Long(0):new Long(idCommande),(idClient == null || idClient.equals(""))?new Long(0): new Long(idClient),
					confirm, startDate, endDate);//commandeService.getCommandesParMotCle(nomCommande);
		//System.out.println("searchCommande : "+commandes.size());
		
		List<Client> clients = getListClientsSelector();
		
		model.put("clients", clients);
		model.put("commandes", commandes);
		model.put("edit",0);
		
		return "commandes";
	}
	
	private List<Client> getListClientsSelector() {
		List<Client> clients = clientService.listClients();
		Client allCLient = new Client();
		allCLient.setIdClient(new Long(0));
		allCLient.setNomClient("ALL CLIENTS");
		clients.add(0, allCLient);
		return clients;
	}
	
	
	/******************************************************************************************/
	/********************************		La Commande       *********************************/
	/******************************************************************************************/
	
	@RequestMapping("/addEditCommande")
	public String indexCommande(ModelMap model, Long id ,Integer edit){
		
		Commande commande = commandeService.selectById(id);
		
		List<Client> clients = clientService.listClients();
		List<Produit> produits = produitService.getListProduits();
		
		model.put("lc", null);
		model.put("commande", commande);
		model.put("produits", produits);
		model.put("clients", clients);
		model.put("edit",edit==null?0:edit.intValue());
		return "printCommande";
	}	
	
	
	@RequestMapping("/deleteLigneCommande")
	public String deleteLigneCommande(ModelMap model,long idCommande, long idLigneCommande) {
		commandeService.deleteLigneCommande(idLigneCommande);
		
		updateTotalPriceCommande(idCommande);
		
		return indexCommande(model, idCommande, 0);
	}
	
	@RequestMapping("/saveLigneCommande")
	public String saveLigneCommande(ModelMap model, long idLigneCommande, long idProduit, double price, int quantity) {
		
		LigneCommande lc = commandeService.selectLigneCommandeById(idLigneCommande);
		lc.setPrix(price);
		lc.setQuantite(quantity);
		Produit p = produitService.selectById(idProduit);
		lc.setProduit(p);
		commandeService.updateLigneCommande(lc);
		
		updateTotalPriceCommande(lc.getCommande().getIdCommande());
		
		return indexCommande(model, lc.getCommande().getIdCommande(), 0);
	}
	
	@RequestMapping("/addEditLigneCommande")
	public String addEditLigneCommande(ModelMap model, long idLigneCommande) {
		//if id==0 then we add a product else we modify a product existing
		System.out.println("Etape 0 ");
		LigneCommande lc = commandeService.selectLigneCommandeById(idLigneCommande);
		List<Produit> produits = produitService.getListProduits();
		List<Client> clients = clientService.listClients();
		System.out.println("Etape 1 ");
		model.put("commande", lc.getCommande());
		model.put("lc", lc);
		model.put("clients", clients);
		model.put("produits", produits);
		model.put("edit",0);
		System.out.println("Etape 2 ");
		return "printCommande";
	}
	
	/**
	 * update Total Price of a commande
	 * @param idCommande
	 * @return
	 */
	public Commande updateTotalPriceCommande (long idCommande){
		
		Double total = new Double(0);
		Commande commande = commandeService.selectById(idCommande);
		List<LigneCommande> list = commandeService.getAllLigneCommandeById(idCommande);
		
		if(list != null && !list.isEmpty()) {
			for(LigneCommande lc : list) {
				total += (lc.getPrix() * lc.getQuantite());
			}
		}
		
		commande.setTotal(total);
		commandeService.update(commande);
		
		return commande;
	}
	
}
