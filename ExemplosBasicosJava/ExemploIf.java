import javax.swing.JOptionPane;

public class ExemploIf {
    public static void main(String[] args) {
        double media = Double.parseDouble(JOptionPane.showInputDialog("Informe a média"));
        double frequencia = Double.parseDouble(JOptionPane.showInputDialog("Informe a frequência"));
        String resultado = "Com média " + media + " e frequência " + frequencia + " o estudante está ";
        if (media>=7 && frequencia>= 75){
            resultado += "Aprovado";
        }else{
            resultado += "Reprovado";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
