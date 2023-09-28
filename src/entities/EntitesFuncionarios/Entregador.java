package entities.EntitesFuncionarios;

import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;
import entities.Funcionario;

public class Entregador extends Funcionario {
    private float periculosidade;

    public Entregador(String nome, String cpf, double salario, Departamento dep, Beneficio
                      beneficios, Desconto descontos, float periculosidade) {
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.periculosidade = periculosidade;

    }

    public double calcularSalario(){
        salario = descontos.calcularDescontos(salario);
        double beneficiosValor = beneficios.pegarBeneficios();
        salario += beneficiosValor;
        salario += salario*periculosidade;

        return salario;
    }

}
