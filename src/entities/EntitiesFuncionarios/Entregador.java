package entities.EntitiesFuncionarios;

import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;

public class Entregador extends Funcionario {
    private float periculosidade;

    public Entregador(String nome, String cpf, double salario, Departamento dep, Beneficio
                      beneficios, Desconto descontos, float periculosidade) {
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.periculosidade = periculosidade;

    }

    public void setPericulosidade(float periculosidade) { //Para fins de mudança
        this.periculosidade = periculosidade;
    }

    public double calcularSalario(){
        double pagamento = salario;
        pagamento += beneficios.calcularBeneficios();
        pagamento += pagamento*periculosidade;
        pagamento -= descontos.calcularDescontos(pagamento);
        return pagamento;
    }

    public String toString() {
        return super.toString() + '\n' + "Bonus Adicional(Periculosidade): " + periculosidade * 100 + '%';
    }


}
