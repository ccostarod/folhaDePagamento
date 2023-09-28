package entities.entitiesExtras;

import entities.EntitesFuncionarios.Vendedor;
import entities.Funcionario;

import java.time.LocalDate;
import java.util.List;

public class Venda {
    private LocalDate data;
    private double valor;
    private List<Venda> vendas;
    private Vendedor vendedor;

    public Venda(LocalDate data, double valor, Vendedor vendedor) {
        this.data = data;
        this.valor = valor;
        this.vendedor = vendedor;
    }

    public void adicionarVenda(Venda venda){
        vendas.add(venda);
    }

    public double pegarComissao(){
        double valorVenda = 0;
        double comissao = 0;
        for (Venda a : vendas){
            valorVenda = a.valor;
            comissao += vendedor.getTaxaComissao() * valorVenda;
            valorVenda = 0;
        }
        return comissao;
    }



}
