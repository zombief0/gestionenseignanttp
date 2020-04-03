/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isj.gestionenseignant2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 * @author fouomene
 */

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer>{

    List<Enseignant> findAllByNomLike(String nom);
}
