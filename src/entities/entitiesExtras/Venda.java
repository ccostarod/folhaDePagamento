package entities.entitiesExtras;

import entities.EntitesFuncionarios.Vendedor; // Importe a classe Vendedor

import java.time.LocalDate;

public class Venda {
    private LocalDate data;
    private double valor;
    private Vendedor vendedor; // Adicione uma referência ao vendedor responsável pela venda
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Venda(int data, double valor, Vendedor vendedor) {
        this.data = LocalDate.ofEpochDay(data);
        this.valor = valor;
        this.vendedor = vendedor; // Associe a venda ao vendedor
        this.status = true;
    }

    public double pegarComissao() {
        // Use o vendedor associado para obter a taxa de comissão
        return vendedor.getTaxaComissao() * valor;
    }
}