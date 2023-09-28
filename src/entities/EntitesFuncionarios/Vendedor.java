package entities.EntitesFuncionarios;

import entities.Funcionario;
import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;
import entities.entitiesExtras.Venda;

import java.util.List;

public class Vendedor extends Funcionario {
    private float taxaComissao;
    private Venda venda;
    public float getTaxaComissao() {
        return taxaComissao;
    }
    public Venda getVenda() {
        return venda;
    }

   //vendas = arrayList(preenchido na main);
    public Vendedor(String nome, String cpf, double salario, Departamento dep, Beneficio
            beneficios, Desconto descontos, float taxaComissao, Venda venda) {
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.taxaComissao = taxaComissao;
        this.venda = venda;
    }

    public double calcularSalario(){
        salario = descontos.calcularDescontos(salario);
        double beneficiosValor = beneficios.pegarBeneficios();
        salario += beneficiosValor;
        salario += venda.pegarComissao();

        return salario;
    }


}
