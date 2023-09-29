package controller;

import entities.entitiesFuncionarios.Administrador;
import entities.entitiesFuncionarios.Entregador;
import entities.entitiesFuncionarios.Vendedor;
import entities.entitiesFuncionarios.Funcionario;

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
    public Funcionario buscarFuncionario(String key) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(key) || funcionario.getCpf().equals(key)) {
                return funcionario;
            }
        }
        return null; // Retorna null se não encontrar o funcionário
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
        if (funcionarios.size() == 0){
            System.out.println("Nao ha funcionarios na folha");
        }
        else{
            for (Funcionario funcionario : funcionarios){
                System.out.println(funcionario);
                double pagamento = funcionario.calcularSalario();
                System.out.printf("Salario Liquido: %.3f\n\n", pagamento);
            }
        }

    }

}
