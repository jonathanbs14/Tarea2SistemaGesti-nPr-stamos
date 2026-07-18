package com.prueba.graftsql.tarea2sistemagesti.domain.valueobjects;

public record PuntajeCrediticio(int valor) {
    public PuntajeCrediticio {
        if (valor < 0 || valor > 1000) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 1000");
        }
    }
}
