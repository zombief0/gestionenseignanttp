package org.isj.gestionenseignant2.domaine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantDto {

    private String nom;

    private String telephone;

    private String ue;
}
