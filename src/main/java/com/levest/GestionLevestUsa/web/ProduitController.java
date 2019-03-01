package com.levest.GestionLevestUsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addUser(ModelMap model,  @ModelAttribute("name")String name,  @ModelAttribute("lastname")String lastname,  @ModelAttribute("age")int age) { 
		Produit p = new Produit();
		p.setNomProduit(nomProduit);
		p.setDescription(description);
		p.setPhoto(photo);
		p.setQuantite(quantite);
		produitService.create(p);
		
		return home(model,0);

	}
	
	
	@RequestMapping("/deleteUser")
	public String deleteUser(ModelMap model,int id) {
		
		userRepo.deleteById(id);
		
		return home(model,0);
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
	@RequestMapping("/printUser")
	public String printUser(ModelMap model,int id) {
		User u = userRepo.findById(id).get();
		model.put("user", u);
		
		return home(model,1);
	}
	
	@RequestMapping("/editUser")
	public String editUser(ModelMap model,int id, String name, String lastname, int age) {
		//if id==0 then we add an user else we modify an user existing
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setLastname(lastname);
		u.setAge(age);
		userRepo.save(u);
		return home(model,0);
	}
	
}
