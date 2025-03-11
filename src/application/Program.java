package application;

import entities.*;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Banco banco = new Banco("Bradesco");

        System.out.print("Insira seu nome: ");
        String nomeCliente = sc.nextLine();
        System.out.println("Olá, " + nomeCliente + "! Bem vindo ao banco " + banco.getNome());
        while (true){
            System.out.println("------------------------------------");
            System.out.println("1 - Abrir nova conta");
            System.out.println("2 - Já sou cliente");
            System.out.println("9 - Sair");
            char op = sc.next().charAt(0);

            if (op == '1'){
                sc.nextLine();
                System.out.print(nomeCliente + ", qual tipo de conta deseja abrir? [1 - Conta Corrente/ 2 - Conta Poupança]: ");
                char opConta = sc.next().charAt(0);
                if (opConta == '1'){
                    Conta cc = new ContaCorrente(new Cliente(nomeCliente));
                    banco.abrirContaCorrente(cc);
                    System.out.println("Parabéns!!! Conta aberta com sucesso:");
                    cc.imprimirExtrato();

                } else if (opConta == '2') {
                    Conta poupanca = new ContaPoupanca(new Cliente(nomeCliente));
                    banco.abrirContaPoupanca(poupanca);
                    System.out.println("Parabéns!!! Conta aberta com sucesso:");
                    poupanca.imprimirExtrato();
                }
                else {
                    System.out.println("Opção inválida!");
                }

            } else if (op == '2') {
                System.out.print("Digite o número da conta: ");
                int numeroConta = sc.nextInt();
                Conta conta = banco.buscarConta(numeroConta);
                if (conta != null){
                    System.out.println("Bem vindo, " + nomeCliente);
                    System.out.println("1 - Sacar");
                    System.out.println("2 - Depositar");
                    System.out.println("3 - Transferir");
                    System.out.println("4 - Imprimir extrato");
                    System.out.println("9 - Sair");
                    char operacao = sc.next().charAt(0);

                    if (operacao == '1'){
                        System.out.print("Insira o valor que deseja sacar: ");
                        double valor = sc.nextDouble();
                        conta.sacar(valor);
                        conta.imprimirExtrato();
                    }
                    else if (operacao == '2'){
                        System.out.print("Insira o valor que deseja depositar: ");
                        double valor = sc.nextDouble();
                        conta.depositar(valor);
                        conta.imprimirExtrato();
                    }
                    else if (operacao == '3') {
                        System.out.print("Insira o número da conta de destino: ");
                        int numeroContaDestino = sc.nextInt();
                        Conta contaDestino = banco.buscarConta(numeroContaDestino);
                        if (contaDestino != null) {
                            System.out.print("Insira o valor que deseja transferir: ");
                            double valor = sc.nextDouble();
                            conta.transferir(valor, contaDestino);
                        }
                        else {
                            System.out.println("Conta destino não encontrada!");
                        }
                    }
                    else if (operacao == '4'){
                        conta.imprimirExtrato();
                    }
                    else if ( operacao == '9') {
                        break;
                    }
                    else{
                        System.out.println("Opção inválida!");
                    }
                }
                else {
                    System.out.println("Conta não encontrada!");
                }
            }
            else if (op == '9') {
                break;
            }
        }

    }
}
