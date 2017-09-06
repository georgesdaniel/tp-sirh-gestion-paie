package dev.paie.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;



@Component
@Transactional
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext 
	private EntityManager em;

	@Override
	
	public void sauvegarder(Cotisation nouvelleCotisation) {
		
		em.persist(nouvelleCotisation);
		
	}

	@Override
	public void mettreAJour(Cotisation cotisation) {
		// TODO Auto-generated method stub
		
		em.merge(cotisation);
		
	}

	@Override
	public List<Cotisation> lister() {
		List<Cotisation> coti = new ArrayList<Cotisation>();
		TypedQuery<Cotisation> query = em.createQuery("from Cotisation", Cotisation.class);
		
		coti =  query.getResultList();
		
		
		return coti;
		
	}

	@Override
	public Cotisation findByCode(String code) {
		List<Cotisation> cotis = new ArrayList<Cotisation>();
		TypedQuery<Cotisation> query = em.createQuery("from Cotisation WHERE code=:pcode", Cotisation.class);
		query.setParameter("pcode", code);
		cotis =  query.getResultList();
		if (!cotis.isEmpty()) {
			return cotis.get(0);
		}
		return null;
	}
	
	

	
	

}
