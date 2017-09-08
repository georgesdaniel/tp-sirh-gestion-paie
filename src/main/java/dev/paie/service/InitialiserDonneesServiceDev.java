package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

@Autowired
private AvantageRepository avantageRepository;

	@Autowired
	private CotisationRepository cotisationRepository;

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private PeriodeRepository periodeRepository;

	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;

	@Autowired
	private RemunerationEmployeRepository remunerationRepository;

	@Autowired
	private List<Cotisation> cotisations;
	
	//@Autowired
	//private List<Avantage> avantages;
	
	@Autowired
	private List<Grade> grades;
	
	@Autowired
	private List<Entreprise> entreprises;

	//@Autowired
	//private List<Periode> periode;
	
	@Autowired
	private List<ProfilRemuneration> profils;
	
	@Autowired
	private List<RemunerationEmploye> remunerations;
	
	

	@Override
	public void initialiser() {
		for (Cotisation c: cotisations) {
			cotisationRepository.save(c);
		}
		
//		for (Avantage a: avantages) {
//			avantageRepository.save(a);
//		}
//		
		for (Grade g: grades) {
			gradeRepository.save(g);
		}
		
		for (Entreprise e: entreprises) {
			entrepriseRepository.save(e);
		}
		
		for (int i=1; i<=12;i++) {
			periodeRepository.save(new Periode(i));
		}
//		
//		for (ProfilRemuneration pro: profils) {
//			profilRemunerationRepository.save(pro);
//		}
	}

}
