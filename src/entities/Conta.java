package entities;

import interfaces.Operacoes;

import java.util.Scanner;

public abstract class Conta implements Operacoes {
    Scanner sc = new Scanner(System.in);

    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor){
        if (valor <= saldo) {
            this.saldo -= valor;
        }
        else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirDados(){
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Conta: " + getNumeroConta());
        System.out.printf("Saldo: R$%.2f%n", getSaldo());
    }
}
