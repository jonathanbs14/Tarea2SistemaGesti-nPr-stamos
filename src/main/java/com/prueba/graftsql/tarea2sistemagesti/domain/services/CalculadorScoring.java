package com.prueba.graftsql.tarea2sistemagesti.domain.services;

import com.prueba.graftsql.tarea2sistemagesti.domain.entities.SolicitudCredito;
import com.prueba.graftsql.tarea2sistemagesti.domain.valueobjects.PuntajeCrediticio;

public class CalculadorScoring {

    public PuntajeCrediticio calcular(SolicitudCredito solicitud) {
        int baseScore = 600;

        if (solicitud.getMonto().getValor().doubleValue() < 5000) {
            baseScore += 100;
        }

        if (solicitud.getPlazoMeses() > 36) {
            baseScore -= 50;
        }

        return new PuntajeCrediticio(baseScore);
    }
}
