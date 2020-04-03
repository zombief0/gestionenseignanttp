package org.isj.gestionenseignant2.presentation;

import java.util.List;

import com.google.common.collect.Lists;
import org.isj.gestionenseignant2.domaine.dto.EnseignantDto;
import org.isj.gestionenseignant2.repository.Enseignant;
import org.isj.gestionenseignant2.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class EnseignantController {

	@Autowired
	private IService service;

	@GetMapping("/acceuil")
	public String index(){
		return "index";
	}

	@GetMapping("/rechercher")
	public String rechercherEnseignants(@RequestParam(defaultValue = "") String search, Model model){
		List<Enseignant> enseignants = service.listEnseignantRecherche(search);
		model.addAttribute("listeEnseignant",enseignants);
		return "rechercher";
	}

	@GetMapping("/listeenseignant")
	public String listeEnseignant(Model model) {

		//recuperation de la liste des agriculteurs

		final List<Enseignant> agriculteurs = service.listEnseignantService();

		final List<EnseignantDto> dtos= Lists.transform(agriculteurs,
				(Enseignant input) -> new EnseignantDto(input.getNom(),
						input.getUe(), input.getTelephone()));


		//en registrement dans le model
		model.addAttribute("listeEnseignant", dtos);

		return "teachers";
	}

	// Traitemement des valeurs saisies dans le formulaire
	@PostMapping("/enregistrerEnseignantForm")
	public String enregistrerEnseignant(@ModelAttribute EnseignantDto enseignantDto,
			Model model) {

		final Enseignant enseignant = new Enseignant();
		enseignant.setNom(enseignantDto.getNom());
		enseignant.setTelephone(enseignantDto.getTelephone());
		enseignant.setUe(enseignantDto.getUe());

		service.enregistrerEnseignantService(enseignant);

		return "redirect:/listeenseignant";
	}

	//Afficharge du formulaire ou initialisation du formulaire
	@GetMapping("/admin/enregisterEnseignant")
	public String pageEngregistrerEnseignant(Model model) {

		model.addAttribute("enseignantDto", new EnseignantDto());

		return "enregistrer";
	}






}
