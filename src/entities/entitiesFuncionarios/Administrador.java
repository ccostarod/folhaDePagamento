package entities.entitiesFuncionarios;

import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;

public class Administrador extends Funcionario {
    private float bonusChefia;

    public void setBonusChefia(float bonusChefia) {
        this.bonusChefia = bonusChefia;
    }

    public Administrador(String nome, String cpf, double salario, Departamento dep, Beneficio beneficios, Desconto descontos, float bonusChefia) {
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.bonusChefia = bonusChefia;
    }

    public double calcularSalario(){
        double pagamento = salario;
        pagamento += beneficios.calcularBeneficios();
        pagamento += pagamento*bonusChefia;
        pagamento -= descontos.calcularDescontos(pagamento);
        return pagamento;
    }
    public String toString() {
        return super.toString() + '\n' + "Bonus Adicional: " + bonusChefia*100 + '%';
    }

}
