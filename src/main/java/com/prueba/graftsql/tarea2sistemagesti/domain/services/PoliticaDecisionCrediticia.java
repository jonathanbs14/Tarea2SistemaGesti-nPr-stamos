package com.prueba.graftsql.tarea2sistemagesti.domain.services;


import com.prueba.graftsql.tarea2sistemagesti.domain.valueobjects.PuntajeCrediticio;

public class PoliticaDecisionCrediticia {

    public String recomendar(PuntajeCrediticio score) {
        if (score.valor() >= 750) return "Preaprobada";
        if (score.valor() >= 600) return "Revisión manual";
        return "Rechazada";
    }
}
