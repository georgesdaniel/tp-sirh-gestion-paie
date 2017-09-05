package dev.paie.service;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

//TODO compléter la configuration 
@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)

public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Before
	public void init() {
		gradeService.delete();
	}

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade

		Grade nouveauGrade = new Grade();
		nouveauGrade.setId(2);
		nouveauGrade.setCode("G1");
		nouveauGrade.setNbHeuresBase(new BigDecimal(52.66));
		nouveauGrade.setTauxBase(new BigDecimal(33.33));
		gradeService.sauvegarder(nouveauGrade);

		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode
		// lister

		System.out.println(gradeService.lister());

		// TODO modifier un grade
		Grade gradeModif = new Grade();
		gradeModif.setId(3);
		gradeModif.setCode("G3");
		gradeModif.setNbHeuresBase(new BigDecimal(66.66));
		gradeModif.setTauxBase(new BigDecimal(44.44));
		gradeService.mettreAJour(gradeModif);
			

		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// lister
	}
}