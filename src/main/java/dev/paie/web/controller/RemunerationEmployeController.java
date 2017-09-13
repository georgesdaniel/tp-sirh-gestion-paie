package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	@Autowired
	BulletinSalaireRepository bulletinSalaireRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("prefixMatricule", "M00");
		mv.addObject("entreprises", entrepriseRepository.findAll());
		mv.addObject("grades", gradeRepository.findAll());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/inscription")
	public ModelAndView inscriptionEmploye(HttpServletRequest request) {

		String idGradeStr = request.getParameter("selectgrades");
		Integer idGrade = Integer.parseInt(idGradeStr);
		String idEStr = request.getParameter("selectentreprises");
		Integer idE = Integer.parseInt(idEStr);
		String matricule = request.getParameter("matricule");
		Grade grade = gradeRepository.findOne(idGrade);
		Entreprise entreprise = entrepriseRepository.findOne(idE);

		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setMatricule(matricule);
		employe.setGrade(grade);
		employe.setEntreprise(entreprise);
		// employe.setProfilRemuneration(profilRemuneration);
		// System.out.println(codeGrade);
		remunerationEmployeRepository.save(employe);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/succes");

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/liste")
	public ModelAndView listeEmploye(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/liste");
		// RemunerationEmploye employes = new RemunerationEmploye();
		mv.addObject("employes", remunerationEmployeRepository.findAll());
		System.out.println("TAILLE LISTE = " + remunerationEmployeRepository.findAll().size());
		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/bulletin")
	public ModelAndView creerBulletin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
				
		mv.setViewName("employes/creerBulletin");
		mv.addObject("listePeriodes", periodeRepository.findAll());
		mv.addObject("ListEmployes", remunerationEmployeRepository.findAll());

		return mv;

	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/validerbulletin")
	public ModelAndView validerBulletin(HttpServletRequest request) {
		
		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setPeriode(periodeRepository.findOne(Integer.parseInt(request.getParameter("periodeId"))));
		//bulletin.setRemunerationEmploye(remunerationEmployeRepository.findOne(Integer.parseInt(request.getParameter("employeId"))));
		bulletin.setPrimeExceptionnelle(new BigDecimal(request.getParameter("prime")));
		bulletin.setDateCreation(LocalDateTime.now());
		bulletinSalaireRepository.save(bulletin);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/succes2");
		return mv;

	}
}