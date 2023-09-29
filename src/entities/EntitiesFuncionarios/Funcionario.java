package entities.EntitiesFuncionarios;

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
        beneficios = new Beneficio();

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setSalario(double salario) { // Caso queira mudar o salario de algum funcionario na area de services
        this.salario = salario;
    }

    public double calcularSalario(){
        double pagamento = salario;
        pagamento += beneficios.calcularBeneficios();
        pagamento -= descontos.calcularDescontos(pagamento);
        return pagamento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + '\n' +
                "CPF: " + cpf + '\n' +
                "Departamento: " + dep + '\n' +
                "Salario Base: " + salario + '\n' +
                "Beneficios: " + beneficios.calcularBeneficios() + '\n' +
                "Descontos: " + descontos.descontoTotal()*100 + '%';
    }
}
