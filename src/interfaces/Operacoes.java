package interfaces;

import entities.Conta;

public interface Operacoes {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
    void imprimirExtrato();
}
