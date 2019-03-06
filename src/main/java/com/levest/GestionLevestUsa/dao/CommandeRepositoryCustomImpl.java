package com.levest.GestionLevestUsa.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.levest.GestionLevestUsa.entities.Commande;

@Repository
public class CommandeRepositoryCustomImpl implements ICommandeRepositoryCustom{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Commande> selector(Long idCommande, Long idClient, int confirm, String startDate, String endDate) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> query = cb.createQuery(Commande.class);
        Root<Commande> commande = query.from(Commande.class);
 
        query.select(commande);
        
        System.out.print("methode selector");

        
        List<Predicate> predList = new LinkedList<Predicate>();
        Predicate p1 = cb.and(cb.equal(commande.get("client"), idClient));
        Predicate p2= cb.and(cb.equal(commande.get("idCommande"), idCommande));
        Predicate p3= cb.and(cb.equal(commande.get("confirm"), confirm));
        
        if(idClient != null && idClient.intValue() != 0) predList.add(p1);
        if(idCommande != null && idCommande.intValue() != 0) predList.add(p2);
        if(confirm != -1) predList.add(p3);
        
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);


 
        return entityManager.createQuery(query)
            .getResultList();
    }
		
		
		
}
		

	
