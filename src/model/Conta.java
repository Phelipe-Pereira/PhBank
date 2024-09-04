package model;

import java.util.ArrayList;

public class Conta {
    private String titularDaConta;
    private int tipoDaConta;
    private double saldo;
    private ArrayList<Movimentacao> listaDeMovimentacao;

    public Conta(String titularDaConta, int tipoDaConta, double saldo) {
        this.titularDaConta = titularDaConta;
        this.tipoDaConta = tipoDaConta;
        this.saldo = saldo;
    }

    public String getTitularDaConta() {
        return titularDaConta;
    }
    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }
    public int getTipoDaConta() {
        return tipoDaConta;
    }
    public void setTipoDaConta(int tipoDaConta) {
        this.tipoDaConta = tipoDaConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public ArrayList<Movimentacao> getListaDeMovimentacao() {
        return listaDeMovimentacao;
    }
    public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
        this.listaDeMovimentacao = listaDeMovimentacao;
    }

    public void depositar(double valorDoDeposito) {
        if (valorDoDeposito <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valorDoDeposito;
    }

    public void sacar(double valorDoSaque) {
        if (valorDoSaque <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valorDoSaque > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valorDoSaque;
    }
    public double obterSaldo(){
        return saldo;
    }

    public String obterDadosConta(){
        String informacaoes = "";

        
        return informacaoes;
    }
}
