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

    public String depositar(double valorDoDeposito) {
        String informacao = "";
        if (valorDoDeposito <= 0) {
            informacao = "O valor do depósito deve ser positivo.";
        }else{
            saldo += valorDoDeposito;
            listaDeMovimentacao.add(new Movimentacao(1, valorDoDeposito));
            informacao = "O deposito foi um sucesso!";
        }
        return informacao;
    }

    public String sacar(double valorDoSaque) {
        String informacao = "";

        if (valorDoSaque <= 0) {
            informacao = "O valor do saque deve ser positivo.";
        }else if(saldo < -1000){
            informacao = "O saldo não pode ser menor que R$-1000";
        }else{
            saldo -= valorDoSaque;
            listaDeMovimentacao.add(new Movimentacao(2, valorDoSaque));

            informacao = "O saque foi um sucesso!";
        }
        return informacao;
    }

    public String gerarDadosConta(){
        String informacaoes = "";
        String tipoConta = "";
        if(tipoDaConta == 1){
            tipoConta = "Conta poupança";
        }if (tipoDaConta == 2){
            tipoConta = "Conta corrente.";
        }
        informacaoes = "Titular da conta: " + titularDaConta +
                "\n" +
                "Tipo da conta: " + tipoConta +
                "\n" +
                "Saldo: R$" + saldo;
        return informacaoes;
    }

    public String gerarExtato(){
        StringBuilder informacoes = new StringBuilder();

        informacoes.append("Seu saldo atual é: R$").append(saldo).append("\n");


        informacoes.append("Extrato de depósitos da conta:");
        for (Movimentacao movimentacao : listaDeMovimentacao) {
            if (movimentacao.getTipoDaMovimentacao() == 1) {
                informacoes.append("\nData: ").append(movimentacao.getData())
                        .append(" | Valor: R$").append(movimentacao.getValorDaMovimentacao());
            }
        }


        informacoes.append("\nExtrato de saques da conta:");
        for (Movimentacao movimentacao : listaDeMovimentacao) {
            if (movimentacao.getTipoDaMovimentacao() == 2) {
                informacoes.append("\nData: ").append(movimentacao.getData())
                        .append(" | Valor: R$").append(movimentacao.getValorDaMovimentacao());
            }
        }

        return informacoes.toString();
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
