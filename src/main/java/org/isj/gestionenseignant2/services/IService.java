package org.isj.gestionenseignant2.services;



import org.isj.gestionenseignant2.repository.Enseignant;

import java.util.List;


public interface IService {

	Enseignant enregistrerEnseignantService(Enseignant enseignant);
	List<Enseignant> listEnseignantService();
	List<Enseignant> listEnseignantRecherche(String nom);
}
