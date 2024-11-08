package fag.objetos;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Veiculo> historicoVeiculos;

    public Estacionamento() {
        this.vagas = new ArrayList<>();
        this.historicoVeiculos = new ArrayList<>();
    }

    public void cadastrarVaga(int numero, String tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }

    public void cadastrarVeiculo(String placa, String modelo, String tamanho) {
        Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(tamanho)) {
                vaga.ocupar();
                veiculo.registrarEntrada();
                historicoVeiculos.add(veiculo);
                System.out.println("Veículo estacionado na vaga: " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Nenhuma vaga disponível para o veículo.");
    }

    public void registrarSaida(String placa) {
        for (Veiculo veiculo : historicoVeiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa) && veiculo.getHoraSaida() == null) {
                veiculo.registrarSaida();
                double valor = calcularValorPago(veiculo.calcularTempoPermanencia());
                veiculo.setValorPago(valor);
                liberarVaga(veiculo.getTamanho());
                System.out.println("Veículo saiu. Valor a ser pago: R$ " + valor);
                return;
            }
        }
        System.out.println("Veículo não encontrado ou já retirado.");
    }

    private void liberarVaga(String tamanho) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(tamanho)) {
                vaga.liberar();
                return;
            }
        }
    }

    private double calcularValorPago(long horas) {
        if (horas <= 1) return 5.00;
        else if (horas <= 3) return 10.00;
        else return 15.00;
    }

    public void exibirRelatorioVagasOcupadas() {
        System.out.println("Vagas ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga " + vaga.getNumero() + " - Tamanho: " + vaga.getTamanho());
            }
        }
    }

    public void exibirHistoricoVeiculos() {
        System.out.println("Histórico de permanência:");
        for (Veiculo veiculo : historicoVeiculos) {
            System.out.println("Placa: " + veiculo.getPlaca() +
                               ", Entrada: " + veiculo.getHoraEntrada() +
                               ", Saída: " + veiculo.getHoraSaida() +
                               ", Valor Pago: R$ " + veiculo.getValorPago());
        }
    }
}