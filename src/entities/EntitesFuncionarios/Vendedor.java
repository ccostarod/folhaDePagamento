package entities.EntitesFuncionarios;

import entities.Funcionario;
import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;
import entities.entitiesExtras.Venda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {
    private float taxaComissao;
    private List<Venda> vendas;

    public void setTaxaComissao(float taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    public Vendedor(String nome, String cpf, double salario, Departamento dep, Beneficio
            beneficios, Desconto descontos, float taxaComissao) {
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.taxaComissao = taxaComissao;
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        if(venda.isStatus()){
            vendas.add(venda);
            venda.setStatus(false);
        }
    }

    public float getTaxaComissao() {
        return taxaComissao;
    }

    private double calcularComissao() {
        double comissao = 0;
        for (Venda venda : vendas) {
            comissao += venda.pegarComissao();
        }
        return comissao;
    }

    public double calcularSalario() {
        double pagamento = salario;
        pagamento -= descontos.calcularDescontos(salario);
        double beneficiosValor = beneficios.pegarBeneficios();
        pagamento += beneficiosValor;
        pagamento += calcularComissao();
        vendas.clear();
        return pagamento;
    }


    public String toString() {
        return super.toString() + '\n' + "Comissao: " + calcularComissao();
    }


}
