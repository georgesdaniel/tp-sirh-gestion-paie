package dev.paie.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.spring.JpaConfig;

//TODO compléter la configuration

@ContextConfiguration(classes = {JpaConfig.class})
@RunWith(SpringRunner.class)

public class CotisationServiceJpaTest {
	
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		
		Cotisation cotisation2 = new Cotisation();
		
		cotisation2.setCode("FR1");
		cotisation2.setLibelle("Cotisation salariale");
		cotisation2.setTauxPatronal(new BigDecimal(55.55));
		cotisation2.setTauxSalarial(new BigDecimal(80.58));
		cotisationService.sauvegarder(cotisation2);
				
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		List<Cotisation> cotisations = cotisationService.lister();
		assertTrue(cotisations.contains(cotisation2));
				
		// TODO modifier une cotisation
		
		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// lister
		Cotisation cotisationFromBase = cotisationService.findByCode("FR1");
		assertNotNull(cotisationFromBase);
		
		cotisationFromBase.setCode("FR4");
		cotisationFromBase.setLibelle("Cotisation patronale");
		cotisationService.mettreAJour(cotisationFromBase);
		
		//Verification que l'objet est null
		cotisationFromBase = cotisationService.findByCode("FR1");
		assertNull(cotisationFromBase);
		
		
	}
}
