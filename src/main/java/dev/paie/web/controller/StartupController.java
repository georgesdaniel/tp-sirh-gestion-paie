package dev.paie.web.controller;

import java.util.logging.Logger;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesService;

@Controller
public class StartupController {
	
	@Autowired
	private InitialiserDonneesService initService;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		System.out.println("Initialisation des données");

		initService.initialiser();

	}
}
