package com.banco.sistema;

import java.util.Scanner;
import nucleo.Cliente;
import nucleo.Conta;



public class Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema bancário!");

        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome do cliente: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, endereco, cpf);

        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Limite da conta: ");
        double limiteConta = scanner.nextDouble();

        Conta conta = new Conta(numeroConta, cliente, limiteConta);

        System.out.println("Cliente criado: " + cliente.getNome() + " " + cliente.getSobrenome());
        System.out.println("Conta criada: Número " + conta.getNumero() + ", Saldo: " + conta.getSaldo() + ", Limite: " + conta.getLimite());

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Realizar depósito");
            System.out.println("2. Realizar saque");
            System.out.println("3. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println("Saldo atual: " + conta.getSaldo());
        } while (opcao != 3);

        scanner.close();
    }
}
