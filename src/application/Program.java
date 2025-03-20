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
        while (true) {
            banco.menu();
            char op = sc.next().charAt(0);

            switch (op) {
                case '1':
                    banco.menuAbrirConta(nomeCliente);
                    break;
                case '2':
                    banco.menuCliente(nomeCliente);
                    break;
                case '9':
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
