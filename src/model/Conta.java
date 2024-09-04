package model;

import java.util.ArrayList;

public class Conta {
    private String titularDaConta;
    private int tipoDaConta;
    private double saldo = 0;
    private ArrayList<Movimentacao> listaDeMovimentacao;

    public Conta(String titularDaConta, int tipoDaConta) {
        this.titularDaConta = titularDaConta;
        this.tipoDaConta = tipoDaConta;
        this.listaDeMovimentacao = new ArrayList<>();
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
        listaDeMovimentacao.add(new Movimentacao(1, valorDoDeposito));
    }

    public void sacar(double valorDoSaque) {
        if (valorDoSaque <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valorDoSaque > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valorDoSaque;
        listaDeMovimentacao.add(new Movimentacao(2, valorDoSaque));
    }
    public double obterSaldo(){
        return saldo;
    }

    public String gerarDadosConta(){
        String informacaoes = "";
        informacaoes = "Titular da conta: " + titularDaConta +
                "\n" +
                "Saldo: R$" + saldo;
        return informacaoes;
    }

    public String gerarExtato(){
        String informacoes = "";
        informacoes = "Seu saldo atual é: " + saldo;
        return informacoes;
    }

    public String gerarExtratoDepositos() {
        StringBuilder informacoes = new StringBuilder("Extrato de depósitos da conta: ");
        for (Movimentacao movimentacao : listaDeMovimentacao) {
            if (movimentacao.getTipoDaMovimentacao() == 1) {
                informacoes.append("\nData: ").append(movimentacao.getData())
                        .append(" | Valor: R$").append(movimentacao.getValorDaMovimentacao());
            }
        }
        return informacoes.toString();
    }

    public String gerarExtratoSaques() {
        StringBuilder informacoes = new StringBuilder("Extrato de depósitos da conta: ");
        for (Movimentacao movimentacao : listaDeMovimentacao) {
            if (movimentacao.getTipoDaMovimentacao() == 2) {
                informacoes.append("\nData: ").append(movimentacao.getData())
                        .append(" | Valor: R$").append(movimentacao.getValorDaMovimentacao());
            }
        }
        return informacoes.toString();
    }
}
