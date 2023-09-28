package controller;

import entities.EntitesFuncionarios.Administrador;
import entities.EntitesFuncionarios.Entregador;
import entities.EntitesFuncionarios.Vendedor;
import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FolhaDePagamento {
    private List<Funcionario> funcionarios;

    public FolhaDePagamento() {
        funcionarios = new ArrayList<>();
    }

    public boolean cadastrarFuncionario(Funcionario funcionario){
        if (!funcionarios.contains(funcionario)){
            funcionarios.add(funcionario);
            return true;
        }
        return false;
    }

    public boolean removerFuncionario(Funcionario funcionario){
        if (funcionarios.contains(funcionario)){
            funcionarios.remove(funcionario);
            return true;
        }
        return false;
    }

    public boolean ajustarValorAdicionalFuncionario(Funcionario funcionario, float adicional){
        if (funcionarios.contains(funcionario)){
            if(funcionario instanceof Entregador){
                ((Entregador) funcionario).setPericulosidade(adicional);
                return true;
            }
            else if(funcionario instanceof Administrador){
                ((Administrador) funcionario).setBonusChefia(adicional);
                return true;
            }
            else if(funcionario instanceof Vendedor){
                ((Vendedor) funcionario).setTaxaComissao(adicional);
            }
        }
        return false;
    }

    public boolean ajustarSalarioBase(Funcionario funcionario, double salario){
        if (funcionarios.contains(funcionario)){
            funcionario.setSalario(salario);
            return true;
        }
        return false;
    }

    public void realizarPagamento(){
        for (Funcionario funcionario : funcionarios){
            System.out.println(funcionario);
            double pagamento = funcionario.calcularSalario();
            System.out.printf("Salario Liquido: %.3f\n\n", pagamento);
        }
    }

}
