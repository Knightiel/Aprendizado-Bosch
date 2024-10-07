import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#,###.00");

        String nome = JOptionPane.showInputDialog("Informe seu nome");
        double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a 1ª nota"));
        double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a 2ª nota"));

        double media = (nota1 + nota2) / 2;

        JOptionPane.showMessageDialog(null, "A média do estudante \n" + nome + " é " + df.format(media));
    }
}