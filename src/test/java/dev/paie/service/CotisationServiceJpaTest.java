package dev.paie.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.ServicesConfig;
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
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// lister
	}
}
