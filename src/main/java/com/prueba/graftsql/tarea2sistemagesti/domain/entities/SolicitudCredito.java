package com.prueba.graftsql.tarea2sistemagesti.domain.entities;

import com.prueba.graftsql.tarea2sistemagesti.domain.valueobjects.Dinero;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class SolicitudCredito {
    private final String id;
    private final Dinero monto;
    private final int plazoMeses;
    private final LocalDate fechaSolicitud;


}
