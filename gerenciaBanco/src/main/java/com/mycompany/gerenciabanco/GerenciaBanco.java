/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {

    // Classe para dados pessoais e operações bancárias
    static class ContaBancaria {
        private String nome;
        private String sobrenome;
        private String cpf;
        private double saldo;

        // Construtor
        public ContaBancaria(String nome, String sobrenome, String cpf, double saldoInicial) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = saldoInicial;
        }

        // Método para depositar
        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito realizado com sucesso. Novo saldo: " + saldo);
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        // Método para sacar
        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque realizado com sucesso. Novo saldo: " + saldo);
            } else {
                System.out.println("Valor de saque inválido ou saldo insuficiente.");
            }
        }

        // Método para consultar saldo
        public void consultarSaldo() {
            System.out.println("Saldo atual: " + saldo);
        }

        // Método para exibir informações do usuário
        public void exibirInformacoesUsuario() {
            System.out.println("\n--- Informações do Usuário ---");
            System.out.println("Nome: " + nome);
            System.out.println("Sobrenome: " + sobrenome);
            System.out.println("CPF: " + cpf);
        }
    }

    // Método para exibição do menu
    public static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Exibir Informações do Usuário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Gerenciamento Bancário!");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf, saldoInicial);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    conta.exibirInformacoesUsuario();
                    break;
                case 5:
                    System.out.println("Obrigado por usar nosso sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5); 

        scanner.close();
    }
}