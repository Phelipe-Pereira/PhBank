package controller;

import model.Conta;
import view.InputOutput;

public class Controller {
    public void exibirMenu(){
        int opcao;
        Conta conta = null;

        do{
            opcao = InputOutput.solicitaOperacao();

            switch (opcao){
                case 0 -> {
                    String titularDaConta = InputOutput.solicitarNome();
                    int tipoDaConta = InputOutput.solicitarTipoDaConta();
                    conta = new Conta(titularDaConta, tipoDaConta);

                }
                case 1 -> {
                    if(conta != null){
                        double valorDoDeposito = InputOutput.solicitarInformacoesDeposito();
                        String depostivo = conta.depositar(valorDoDeposito);
                        InputOutput.retornarInformacaoMovimentacao(depostivo);
                    }
                }
                case 2 -> {
                    if(conta != null){
                        double valorDoSaque = InputOutput.solicitarInformacoesSaque();
                        String saque = conta.sacar(valorDoSaque);
                        InputOutput.retornarInformacaoMovimentacao(saque);
                    }
                }
                case 3 -> {
                    String saldo = "R$";
                    saldo += String.format("%.2f",conta.getSaldo());
                    InputOutput.exbirSaldo(saldo);
                }
                case 4 -> {
                    InputOutput.exibirDadosDaConta(conta.gerarDadosConta());
                }
                case 5 -> {
                    InputOutput.exibirExtratoCompleto(conta.gerarExtato());
                }
                case 6 -> {
                    InputOutput.exibirExtratoDeDepositos(conta.gerarExtratoDepositos());
                }
                case 7 -> {
                    InputOutput.exibirExtratoSaques(conta.gerarExtratoSaques());
                }
            }
        }while(opcao != 8);
    }
}
