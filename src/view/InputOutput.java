package view;

import javax.swing.*;
import java.text.DecimalFormat;

public class InputOutput {
    public static int solicitaOperacao() {
        String[] opcoes = {
                "Cadastrar conta",
                "Depositar",
                "Sacar",
                "Exibir saldo",
                "Exibir dados da conta",
                "Exibir extrato da conta",
                "Exibir extrato de Depositos",
                "Exibir extrato de saques",
                "Encerrar programa."};
        JComboBox<String> menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedIndex();
    }

    public static String solicitarNome(){
        return JOptionPane.showInputDialog("Informe seu nome completo:");
    }

    public static int solicitarTipoDaConta(){
        return Integer.parseInt(JOptionPane.showInputDialog("""
                Informe o tipo da conta:
                1)Conta poupança
                2)Conta corrente"""));
    };

    public static double solicitarInformacoesDeposito(){
        return Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de seu deposito:"));
    }

    public static double solicitarInformacoesSaque(){
        return Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de seu saque:"));
    }

    public static void retornarInformacaoMovimentacao(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void exbirSaldo(String saldo){
        JOptionPane.showMessageDialog(null, saldo);
    }

    public static void exibirDadosDaConta(String DadosDaConta){
        JOptionPane.showMessageDialog(null, DadosDaConta);
    }

    public static void exibirExtratoCompleto(String extratoCompleto){
        JOptionPane.showMessageDialog(null, extratoCompleto);
    }

    public static void exibirExtratoDeDepositos(String extratoDepositos){
        JOptionPane.showMessageDialog(null, extratoDepositos);
    }

    public static void exibirExtratoSaques(String extratoSaques){
        JOptionPane.showMessageDialog(null, extratoSaques);
    }
}
