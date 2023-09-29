package applications;

import controller.FolhaDePagamento;
import entities.EntitiesFuncionarios.Administrador;
import entities.EntitiesFuncionarios.Entregador;
import entities.EntitiesFuncionarios.Vendedor;
import entities.EntitiesFuncionarios.Funcionario;
import entities.entitiesExtras.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Beneficio beneficios =  new Beneficio();
        beneficios.adicionarPadroes();

        Desconto descontos = new Desconto();
        descontos.adicionarPadroes();
        FolhaDePagamento folhaDePagamento = new FolhaDePagamento();
        int escolha;
        do {
            System.out.println("\n*** Menu da Folha de Pagamento ***");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Ajustar Valores de um funcionario (Bonus chefia, Bonus periculosidade, Taxa de Comissão)");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Realizar Pagamento");
            System.out.println("5. Ajustar Desconto");
            System.out.println("6. Ajustar Beneficio");
            System.out.println("7. Ajustar Salario Base");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    String nome, cpf;
                    double salario;
                    String departamentoNome;
                    System.out.print("Nome: ");
                    nome = sc.nextLine();
                    System.out.print("CPF: ");
                    cpf = sc.nextLine();
                    System.out.print("Salario: ");
                    salario = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Departamento: ");
                    departamentoNome = sc.nextLine();
                    Departamento departamento = new Departamento(departamentoNome);
                    System.out.println("Selecione o tipo de funcionário:");
                    System.out.println("1. Administrador");
                    System.out.println("2. Entregador");
                    System.out.println("3. Vendedor");
                    System.out.print("Escolha: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    switch (tipo){
                        case 1:
                            System.out.print("Bonus de chefia (Em decimal): ");
                            float bonusChefia = sc.nextFloat();
                            sc.nextLine();
                            Administrador administrador = new Administrador(nome, cpf, salario, departamento, beneficios, descontos, bonusChefia);
                            folhaDePagamento.cadastrarFuncionario(administrador);
                            System.out.println("Funcionario cadastrado com sucesso!");
                            break;
                        case 2:
                            System.out.print("Bonus de periculosidade (Em decimal): ");
                            float periculosidade = sc.nextFloat();
                            sc.nextLine();
                            Entregador entregador = new Entregador(nome, cpf, salario, departamento, beneficios, descontos, periculosidade);
                            folhaDePagamento.cadastrarFuncionario(entregador);
                            System.out.println("Funcionario cadastrado com sucesso!");
                            break;
                        case 3:
                            System.out.print("Taxa de Comissão (Em decimal): ");
                            float txComissao = sc.nextFloat();
                            sc.nextLine();
                            Vendedor vendedor = new Vendedor(nome, cpf, salario, departamento, beneficios, descontos, txComissao);
                            folhaDePagamento.cadastrarFuncionario(vendedor);
                            System.out.print("Registro de Vendas:\nQuantas vendas esse vendedor fez? ");
                            int quantVendas = sc.nextInt();
                            sc.nextLine();
                            int i = 0;
                            while (i < quantVendas){
                                System.out.print("Data da venda (yyyy-MM-dd): ");
                                String dataString = sc.nextLine();
                                LocalDate data = LocalDate.parse(dataString);
                                System.out.print("Valor da venda: ");
                                double valorVenda = sc.nextDouble();
                                sc.nextLine();
                                Venda venda = new Venda(data, valorVenda);
                                if (vendedor.adicionarVenda(venda)){
                                    System.out.println("Venda adicionada!");
                                }
                                else{
                                    System.out.println("Essa venda ja havia sido adicionada por ele ou por outro vendedor");
                                }
                                i++;
                            }
                            System.out.println("Funcionario cadastrado com sucesso!");
                            break;
                        default:
                            System.out.println("Escolha um tipo valido!");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome ou CPF do funcionario: ");
                    String chave = sc.nextLine();
                    System.out.print("Digite o ajuste (Em decimal): ");
                    float ajuste = sc.nextFloat();
                    sc.nextLine();
                    Funcionario funcionario = folhaDePagamento.buscarFuncionario(chave);
                    if (funcionario != null){
                        folhaDePagamento.ajustarValorAdicionalFuncionario(funcionario, ajuste);
                        System.out.println("Ajuste feito com sucesso!");
                        break;
                    }
                    System.out.println("Nao existe Funcionario com esse Nome ou CPF!");
                    break;
                case 3:
                    System.out.print("Digite o nome ou CPF do funcionario: ");
                    chave = sc.nextLine();
                    funcionario =  folhaDePagamento.buscarFuncionario(chave);
                    if (funcionario != null){
                        folhaDePagamento.removerFuncionario(funcionario);
                        System.out.println("Funcionario removido com sucesso!");
                        break;
                    }
                    System.out.println("Nao existe Funcionario com esse Nome ou CPF!");
                    break;
                case 4:
                    folhaDePagamento.realizarPagamento();
                    break;
                case 5:
                    System.out.println("Ajustar Descontos:\n1. Adicionar");
                    System.out.println("2. Remover");
                    System.out.print("Escolha: ");
                    int addOuRemover = sc.nextInt();
                    sc.nextLine();
                    if (addOuRemover == 1){
                        System.out.print("Nome do Desconto: ");
                        String nomeDesconto = sc.nextLine();
                        System.out.print("Valor percentual do Desconto: ");
                        double valorPerc = sc.nextDouble();
                        sc.nextLine();
                        DescontoItem descontoItem = new DescontoItem(nomeDesconto, valorPerc);
                        if(descontos.adicionarDesconto(descontoItem)){
                            System.out.println("Desconto adicionado com Sucesso!");
                            break;
                        }
                        else{
                            System.out.println("Desconto ja esta na lista de Descontos");
                            break;
                        }
                    }
                    else if(addOuRemover == 2) {
                        System.out.print("Digite o nome do Desconto: ");
                        String nomeDesconto = sc.nextLine();
                        descontos.removerDesconto(nomeDesconto);
                        break;
                    }
                    else{
                        System.out.println("Digite uma opção valida!");
                        break;
                    }
                case 6:
                    System.out.println("Ajustar Beneficios:\n1. Adicionar");
                    System.out.println("2. Remover");
                    System.out.print("Escolha: ");
                    addOuRemover = sc.nextInt();
                    sc.nextLine();
                    if (addOuRemover == 1){
                        System.out.print("Nome do Beneficio: ");
                        String nomeBeneficio = sc.nextLine();
                        System.out.print("Valor do Beneficio: ");
                        double valor = sc.nextDouble();
                        sc.nextLine();
                        BeneficioItem beneficioItem = new BeneficioItem(nomeBeneficio, valor);
                        if(beneficios.adicionarBeneficio(beneficioItem)){
                            System.out.println("Beneficio adicionado com Sucesso!");
                            break;
                        }
                        else{
                            System.out.println("Desconto ja esta na lista de Descontos");
                            break;
                        }
                    }
                    else if(addOuRemover == 2) {
                        System.out.print("Digite o nome do Beneficio: ");
                        String nomeBeneficio = sc.nextLine();
                        beneficios.removerBeneficio(nomeBeneficio);
                        System.out.println("Beneficio removido com sucesso!");
                        break;
                    }
                    else{
                        System.out.println("Digite uma opção valida!");
                        break;
                    }
                case 7:
                    System.out.print("Digite o nome ou CPF do funcionario: ");
                    String nomeOrCPF = sc.nextLine();
                    System.out.println("Digite o ajuste de salario: ");
                    double ajusteSalario = sc.nextDouble();
                    sc.nextLine();
                    Funcionario funcionarioProcurado = folhaDePagamento.buscarFuncionario(nomeOrCPF);
                    if(funcionarioProcurado != null){
                        folhaDePagamento.ajustarSalarioBase(funcionarioProcurado, ajusteSalario);
                        break;
                    }
                    else{
                        System.out.println("Nao existe Funcionario com esse Nome ou CPF!");
                        break;
                    }

                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 8);
    }
}