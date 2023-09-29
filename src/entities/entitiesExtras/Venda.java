package entities.entitiesExtras;

import java.time.LocalDate;

public class Venda {
    private LocalDate data;
    private double valor;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Venda(LocalDate data, double valor) {
        this.data = data;
        this.valor = valor;
        this.status = true;
    }

    public double getValor() {
        return valor;
    }
}