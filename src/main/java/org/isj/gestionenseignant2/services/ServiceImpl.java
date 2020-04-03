package org.isj.gestionenseignant2.services;

import org.isj.gestionenseignant2.repository.Enseignant;
import org.isj.gestionenseignant2.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceImpl implements IService {

	//injection de l'interface repository
	@Autowired
	private EnseignantRepository enseignantRepository;


	@Override
	public Enseignant enregistrerEnseignantService(Enseignant enseignant) {

		return enseignantRepository.save(enseignant);

	}

	@Override
	public List<Enseignant> listEnseignantService() {

		return enseignantRepository.findAll();
	}

	@Override
	public List<Enseignant> listEnseignantRecherche(String nom) {
		return enseignantRepository.findAllByNomLike(nom);
	}

}
