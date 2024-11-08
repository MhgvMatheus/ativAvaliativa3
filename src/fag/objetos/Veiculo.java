package fag.objetos;

import java.time.Duration;
import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorPago;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    public String getPlaca() { return placa; }
    public String getTamanho() { return tamanho; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public LocalDateTime getHoraSaida() { return horaSaida; }

    public void registrarEntrada() { horaEntrada = LocalDateTime.now(); }
    public void registrarSaida() { horaSaida = LocalDateTime.now(); }
    public void setValorPago(double valor) { valorPago = valor; }
    public double getValorPago() { return valorPago; }

    public long calcularTempoPermanencia() {
        if (horaEntrada != null && horaSaida != null) {
            return Duration.between(horaEntrada, horaSaida).toHours();
        }
        return 0;
    }
}