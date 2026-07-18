package com.prueba.graftsql.tarea2sistemagesti.presentation;


import com.prueba.graftsql.tarea2sistemagesti.application.usercase.EjecutarEvaluacionScoring;
import com.prueba.graftsql.tarea2sistemagesti.domain.entities.SolicitudCredito;
import com.prueba.graftsql.tarea2sistemagesti.domain.valueobjects.Dinero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EjecutarEvaluacionScoring ejecutarEvaluacion;

    @PostMapping("/{id}/evaluar")
    public String evaluar(@PathVariable String id,
                          @RequestParam double monto,
                          @RequestParam int plazoMeses) {
        SolicitudCredito solicitud = new SolicitudCredito(
                id,
                new Dinero(monto, "PEN"),
                plazoMeses,
                LocalDate.now()
        );
        return ejecutarEvaluacion.ejecutar(solicitud);
    }
}
