package entities;

import entities.entitiesExtras.Beneficio;
import entities.entitiesExtras.Departamento;
import entities.entitiesExtras.Desconto;

public class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;
    protected Departamento dep;
    protected Beneficio beneficios;
    protected Desconto descontos;


    public Funcionario(String nome, String cpf, double salario, Departamento dep, Beneficio beneficios, Desconto descontos) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dep = dep;
        this.beneficios = beneficios;
        this.descontos = descontos;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public double calcularSalario(){
        double pagamento = salario;
        pagamento -= descontos.calcularDescontos(salario);
        double beneficiosValor = beneficios.pegarBeneficios();
        pagamento += beneficiosValor;

        return pagamento;
    }


    @Override
    public String toString() {
        return "Nome: " + nome + '\n' +
                "CPF: " + cpf + '\n' +
                "Departamento: " + dep + '\n' +
                "Salario Base: " + salario;
    }
}
