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
		System.out.println("addProduit");
		Produit p = new Produit();
		p.setNomProduit(nomProduit);
		p.setDescription(description);
		p.setPhoto(photo);
		p.setQuantite(quantite);
		produitService.create(p);
		
		return index(model,0);

	}
	
	
	@RequestMapping("/deleteProduit")
	public String deleteProduit(ModelMap model,long id) {
		
		produitService.delete(id);
		
		return index(model,0);
	}
	
	/**
	 * Affiche le produit selectionné pour le modifier
	 * @param model
	 * @param id
	 * @param name
	 * @param lastname
	 * @param age
	 * @return
	 */
	@RequestMapping("/printProduit")
	public String printProduit(ModelMap model,long id) {
		Produit p = produitService.selectById(id);
		model.put("produit", p);
		
		return index(model,1);
	}
	
	@RequestMapping("/editProduit")
	public String editProduit(ModelMap model,long id, String nomProduit, String description, String photo, int quantite) {
		//if id==0 then we add a product else we modify a product existing
		System.out.println("editProduit : " + id);
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
