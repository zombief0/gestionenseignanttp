package org.isj.gestionenseignant2.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enseignant")
public class Enseignant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "telephone", unique = true)
    private String telephone;

    @Column(name = "ue")
    private String ue;


}
