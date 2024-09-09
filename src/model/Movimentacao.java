package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimentacao {

    private int tipoDaMovimentacao;
    private double valorDaMovimentacao;
    LocalDateTime data;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Movimentacao(int tipoDaMovimentacao, double valorDaMovimentacao) {
        this.tipoDaMovimentacao = tipoDaMovimentacao;
        this.valorDaMovimentacao = valorDaMovimentacao;
        this.data = LocalDateTime.now();
    }

    public int getTipoDaMovimentacao() {
        return tipoDaMovimentacao;
    }

    public void setTipoDaMovimentacao(int tipoDaMovimentacao) {
        this.tipoDaMovimentacao = tipoDaMovimentacao;
    }

    public double getValorDaMovimentacao() {
        return valorDaMovimentacao;
    }

    public void setValorDaMovimentacao(double valorDaMovimentacao) {
        this.valorDaMovimentacao = valorDaMovimentacao;
    }

    public String getData() {
        return data.format(formatter);
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

}
