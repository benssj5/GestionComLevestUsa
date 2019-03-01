package com.levest.GestionLevestUsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.levest.GestionLevestUsa.entities.Produit;
import com.levest.GestionLevestUsa.service.IProduitService;

@Controller
public class ProduitController {

	@Autowired
	private IProduitService produitService;
	
	@RequestMapping("/produits")
	public String index(ModelMap model, Integer edit){
		List<Produit> produits = produitService.getListProduits();
		model.put("produits", produits);
		model.put("edit",edit==null?0:edit.intValue());
		return "produits";
	}	
	
	@RequestMapping("/addProduit")
	public String addUser(ModelMap model,  @ModelAttribute("nomProduit")String nomProduit,  @ModelAttribute("description")String description, @ModelAttribute("photo")String photo,  @ModelAttribute("quantite")int quantite) { 
		Produit p = new Produit();
		p.setNomProduit(nomProduit);
		p.setDescription(description);
		p.setPhoto(photo);
		p.setQuantite(quantite);
		produitService.create(p);
		
		return index(model,0);

	}
	
	
	@RequestMapping("/deleteUser")
	public String deleteProduit(ModelMap model,long id) {
		
		produitService.delete(id);
		
		return index(model,0);
	}
	
	/**
	 * Affiche le user selectionner pour le modifier
	 * @param model
	 * @param id
	 * @param name
	 * @param lastname
	 * @param age
	 * @return
	 */
	@RequestMapping("/printProduit")
	public String printUser(ModelMap model,long id) {
		Produit p = produitService.selectById(id);
		model.put("produit", p);
		
		return index(model,1);
	}
	
	@RequestMapping("/editUser")
	public String editUser(ModelMap model,long id, String nomProduit, String description, String photo, int quantite) {
		//if id==0 then we add an user else we modify an user existing
		Produit p = new Produit();
		p.setIdProduit(id);
		p.setNomProduit(nomProduit);
		p.setDescription(description);
		p.setPhoto(photo);
		p.setQuantite(quantite);
		produitService.update(p);
		return index(model,0);
	}
	
}
