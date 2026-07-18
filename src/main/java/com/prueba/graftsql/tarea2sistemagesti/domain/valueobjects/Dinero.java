package com.prueba.graftsql.tarea2sistemagesti.domain.valueobjects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;
@RequiredArgsConstructor
@Getter
public final class Dinero {

    private final BigDecimal valor;
    private final String moneda;

    public Dinero(double valor, String moneda) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor monetario no puede ser negativo");
        }
        if (moneda == null || moneda.isBlank()) {
            throw new IllegalArgumentException("La moneda es obligatoria");
        }
        this.valor = BigDecimal.valueOf(valor);
        this.moneda = moneda.toUpperCase();
    }

    public BigDecimal valor() {
        return valor;
    }

    public String moneda() {
        return moneda;
    }

    // Operaciones típicas de un Value Object
    public Dinero sumar(Dinero otro) {
        validarMoneda(otro);
        return new Dinero(this.valor.add(otro.valor).doubleValue(), this.moneda);
    }

    public Dinero restar(Dinero otro) {
        validarMoneda(otro);
        BigDecimal resultado = this.valor.subtract(otro.valor);
        if (resultado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El resultado no puede ser negativo");
        }
        return new Dinero(resultado.doubleValue(), this.moneda);
    }

    private void validarMoneda(Dinero otro) {
        if (!this.moneda.equals(otro.moneda)) {
            throw new IllegalArgumentException("Las monedas deben coincidir para operar");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinero dinero)) return false;
        return valor.compareTo(dinero.valor) == 0 && moneda.equals(dinero.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moneda);
    }

    @Override
    public String toString() {
        return valor + " " + moneda;
    }
}
