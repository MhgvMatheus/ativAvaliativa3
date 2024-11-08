package fag;

import fag.objetos.Estacionamento;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scan = new Scanner(System.in);
        int escolha;
        boolean menu = true;
        while (menu) {
            System.out.println("\n--- Sistema de Gerenciamento de Estacionamento ---");
            System.out.println("1. Cadastrar Vaga");
            System.out.println("2. Cadastrar Veículo");
            System.out.println("3. Exibir Relatório de Vagas Ocupadas");
            System.out.println("4. Exibir Histórico de Permanência dos Veículos");
            System.out.println("5. Registrar Saída de Veículo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Número da Vaga: ");
                    int numeroVaga = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Tamanho da Vaga (pequeno/médio/grande): ");
                    String tamanhoVaga = scan.nextLine();
                    estacionamento.cadastrarVaga(numeroVaga, tamanhoVaga);
                    System.out.println("Vaga cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Placa do Veículo: ");
                    String placa = scan.nextLine();
                    System.out.print("Modelo do Veículo: ");
                    String modelo = scan.nextLine();
                    System.out.print("Tamanho do Veículo (pequeno/médio/grande): ");
                    String tamanhoVeiculo = scan.nextLine();
                    estacionamento.cadastrarVeiculo(placa, modelo, tamanhoVeiculo);
                    break;

                case 3:
                    estacionamento.exibirRelatorioVagasOcupadas();
                    break;

                case 4:
                    estacionamento.exibirHistoricoVeiculos();
                    break;

                case 5:
                    System.out.print("Informe a placa do veículo para registrar a saída: ");
                    String placaSaida = scan.nextLine();
                    estacionamento.registrarSaida(placaSaida);
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    menu = false;
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } 

        
    }
}