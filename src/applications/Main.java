package applications;

import controller.FolhaDePagamento;
import entities.EntitesFuncionarios.Administrador;
import entities.EntitesFuncionarios.Entregador;
import entities.EntitesFuncionarios.Vendedor;
import entities.Funcionario;
import entities.entitiesExtras.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FolhaDePagamento folhaDePagamento = new FolhaDePagamento();
        Beneficio beneficios = new Beneficio();
        List<Venda> vendas = null;
        BeneficioItem beneficio1 = new BeneficioItem("Plano de Saude", 500);
        BeneficioItem beneficio2 = new BeneficioItem("Vale Transporte", 200);
        DescontoItem desconto1 = new DescontoItem("INSS", 0.11);
        DescontoItem desconto2 = new DescontoItem("IR", 0.15);
        Desconto descontos = new Desconto();
        descontos.adicionarDesconto(desconto1);
        descontos.adicionarDesconto(desconto2);
        beneficios.adicionarBeneficio(beneficio1);
        beneficios.adicionarBeneficio(beneficio2);
        Funcionario administrador = new Administrador("Rodrigo", "616.926.863.80", 2800.0, new Departamento("Banco"), beneficios, descontos, 0.25f);

        Funcionario entregador = new Entregador("Ryan", "618.234.562.33", 1500.0, new Departamento("Entregas"), beneficios, descontos, 0.25f);

        Vendedor vendedor = new Vendedor("Joao", "602.532.003.28", 2000.0, new Departamento("Comercial"), beneficios, descontos, 0.10f);

        vendedor.adicionarVenda(new Venda(2023-4-12,100, vendedor));
        vendedor.adicionarVenda(new Venda(2023-4-13,200, vendedor));
        vendedor.adicionarVenda(new Venda(2023-4-15,500, vendedor));

        folhaDePagamento.cadastrarFuncionario(administrador);
        folhaDePagamento.cadastrarFuncionario(entregador);
        folhaDePagamento.cadastrarFuncionario(vendedor);

        folhaDePagamento.realizarPagamento();
        System.out.println("\n\n\n\n");
        folhaDePagamento.removerFuncionario(entregador);

        folhaDePagamento.realizarPagamento();
        folhaDePagamento.realizarPagamento();
    }
}