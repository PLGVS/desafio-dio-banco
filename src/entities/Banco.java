package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
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
