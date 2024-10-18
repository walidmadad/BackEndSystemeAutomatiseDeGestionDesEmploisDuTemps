package com.miashs.emploi_du_temps.service.Contrainte;

import com.miashs.emploi_du_temps.modele.Contrainte;
import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.request.ContrainteRequest;

import java.util.List;

public interface IContrainteService {
    Contrainte addContrainte(ContrainteRequest contrainteRequest);
    Contrainte updateContrainte(ContrainteRequest contrainteRequest, Long id);
    void deleteContrainte(Long id);

    Contrainte getContrainteById(Long id);
    List<Contrainte> getAllContraintes();
    List<Contrainte> getContraintesByType(String type);
    List<Contrainte> getContraintesByEnseignant(Enseignant enseignant);
}
