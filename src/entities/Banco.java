package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Banco {
    Scanner sc = new Scanner(System.in);

    private String nome;
    private List<Conta> contas;

    public Banco(String nome){
        this.contas = new ArrayList<>();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void menu(){
        System.out.println("------------------------------------");
        System.out.println("1 - Abrir nova conta");
        System.out.println("2 - Já sou cliente");
        System.out.println("9 - Sair");
    }

    public void menuAbrirConta(String nomeCliente){
        System.out.print(nomeCliente + ", qual tipo de conta deseja abrir? [1 - Conta Corrente/ 2 - Conta Poupança]: ");
        char opConta = sc.next().charAt(0);
        switch (opConta){
            case '1':
                Conta cc = new ContaCorrente(new Cliente(nomeCliente));
                this.abrirContaCorrente(cc);
                System.out.println("Parabéns!!! Conta aberta com sucesso:");
                cc.imprimirExtrato();
                break;

            case '2':
                Conta poupanca = new ContaPoupanca(new Cliente(nomeCliente));
                this.abrirContaPoupanca(poupanca);
                System.out.println("Parabéns!!! Conta aberta com sucesso:");
                poupanca.imprimirExtrato();
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }

    public void menuCliente(String nomeCliente) {
        System.out.print("Digite o número da conta: ");
        int numeroConta = sc.nextInt();
        Conta conta = this.buscarConta(numeroConta);
        if (conta != null) {
            System.out.println("Bem vindo, " + nomeCliente);
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Imprimir extrato");
            System.out.println("9 - Sair");
            char operacao = sc.next().charAt(0);

            switch (operacao){
                case '1':
                    this.menuSaque(conta);
                    break;
                case '2':
                    this.menuDeposito(conta);
                    break;
                case '3':
                    this.menuTransferencia(conta);
                    break;
                case '4':
                    conta.imprimirExtrato();
                    break;
                case '9':
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public void menuSaque(Conta conta){
        System.out.print("Insira o valor que deseja sacar: ");
        double valorSaque = sc.nextDouble();
        conta.sacar(valorSaque);
        conta.imprimirExtrato();
    }

    public void menuDeposito(Conta conta){
        System.out.print("Insira o valor que deseja depositar: ");
        double valorDeposito = sc.nextDouble();
        conta.depositar(valorDeposito);
        conta.imprimirExtrato();
    }

    public void menuTransferencia(Conta conta){
        System.out.print("Insira o número da conta de destino: ");
        int numeroContaDestino = sc.nextInt();
        Conta contaDestino = this.buscarConta(numeroContaDestino);
        if (contaDestino != null) {
            System.out.print("Insira o valor que deseja transferir: ");
            double valor = sc.nextDouble();
            conta.transferir(valor, contaDestino);
        }
        else {
            System.out.println("Conta destino não encontrada!");
        }
    }

    public void abrirContaCorrente(Conta cc){
        contas.add(cc);
    }

    public void abrirContaPoupanca(Conta poupanca){
        contas.add(poupanca);
    }

    public Conta buscarConta(int numeroConta) {
        Conta contaEncontrada = null;
        if(!contas.isEmpty()){
            for (Conta c : contas){
                if (c.getNumeroConta() == numeroConta){
                    contaEncontrada = c;
                    break;
                }
            }
        }
        else{
            System.out.println("O banco não possui contas abertas!");
        }

        return contaEncontrada;
    }
}
