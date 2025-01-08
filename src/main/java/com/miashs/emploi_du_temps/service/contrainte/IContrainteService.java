package com.miashs.emploi_du_temps.service.contrainte;

import com.miashs.emploi_du_temps.model.Contrainte;
import com.miashs.emploi_du_temps.request.ContrainteRequest;

import java.util.List;

public interface IContrainteService {

    Contrainte addContrainte(ContrainteRequest contrainteRequest);
    Contrainte updateContrainte (ContrainteRequest contrainteRequest, Long id);
    void deleteContrainte (Long id);


    List<Contrainte> getAllContrainte();
    List<Contrainte> getContraintebyEnseignant (Long id);
}
