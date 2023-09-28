package entities.EntitesFuncionarios;

import entities.Funcionario;
import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;

public class Administrador extends Funcionario {
    private float bonusChefia;

    public Administrador(String nome, String cpf, double salario, Departamento dep, Beneficio beneficios, Desconto descontos, float bonusChefia) {
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.bonusChefia = bonusChefia;
    }

    public double calcularSalario(){
        salario = descontos.calcularDescontos(salario);
        double beneficiosValor = beneficios.pegarBeneficios();
        salario += beneficiosValor;
        salario += salario*bonusChefia;

        return salario;
    }
}
