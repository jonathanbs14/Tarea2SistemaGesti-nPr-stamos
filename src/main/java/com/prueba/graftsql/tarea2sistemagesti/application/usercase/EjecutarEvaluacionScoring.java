package com.prueba.graftsql.tarea2sistemagesti.application.usercase;

import com.prueba.graftsql.tarea2sistemagesti.domain.entities.SolicitudCredito;
import com.prueba.graftsql.tarea2sistemagesti.domain.services.CalculadorScoring;
import com.prueba.graftsql.tarea2sistemagesti.domain.services.PoliticaDecisionCrediticia;
import com.prueba.graftsql.tarea2sistemagesti.domain.valueobjects.PuntajeCrediticio;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EjecutarEvaluacionScoring {

    private final CalculadorScoring calculadorScoring;
    private final PoliticaDecisionCrediticia politicaDecision;

    public String ejecutar(SolicitudCredito solicitud) {
        PuntajeCrediticio score = calculadorScoring.calcular(solicitud);
        return politicaDecision.recomendar(score);
    }
}
