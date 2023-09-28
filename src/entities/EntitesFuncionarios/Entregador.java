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

    public void setPericulosidade(float periculosidade) {
        this.periculosidade = periculosidade;
    }

    public double calcularSalario(){
        double pagamento = salario;
        pagamento -= descontos.calcularDescontos(salario);
        double beneficiosValor = beneficios.pegarBeneficios();
        pagamento += beneficiosValor;
        pagamento += pagamento*periculosidade;
        return pagamento;
    }

    public String toString() {
        return super.toString() + '\n' + "Bonus Adicional(Periculosidade): " + periculosidade;
    }


}
