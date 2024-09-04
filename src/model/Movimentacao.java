package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Movimentacao {

    private int tipoDaMovimentacao;
    private double valorDaMovimentacao;
    LocalDateTime data = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

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