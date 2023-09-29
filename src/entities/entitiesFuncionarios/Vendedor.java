package entities.entitiesFuncionarios;

import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;
import entities.entitiesExtras.Venda;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {
    private float taxaComissao;
    private List<Venda> vendas;

    private double comissao;

    public Vendedor(String nome, String cpf, double salario, Departamento dep, Beneficio
            beneficios, Desconto descontos, float taxaComissao) {
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.taxaComissao = taxaComissao;
        this.vendas = new ArrayList<>();
    }


    public void setTaxaComissao(float taxaComissao) { //para fins de mudança
        this.taxaComissao = taxaComissao;
    }

    public boolean adicionarVenda(Venda venda) {
        if(venda.isStatus()){ //Vê se a venda já nao foi adicionada a lista de um vendedor.
            vendas.add(venda);
            venda.setStatus(false);
            return true;
        }
        return false;
    }

    public double pegarComissao(Venda venda) {
        return taxaComissao * venda.getValor();
    }
    public double calcularComissao() {
        comissao = 0;
        for (Venda venda : vendas) {
            comissao += pegarComissao(venda);
        }
        return comissao;
    }

    public double calcularSalario() {
        double pagamento = salario;
        pagamento += beneficios.calcularBeneficios();
        pagamento += calcularComissao();
        pagamento -= descontos.calcularDescontos(pagamento);
        vendas.clear();
        return pagamento;
    }


    public String toString() {
        return super.toString() + '\n' + "Comissao: " + calcularComissao();
    }


}
