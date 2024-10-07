import javax.swing.JOptionPane;

public class ExemploSwitch {
    public static void main(String[] args) {
        int numeroDia = Integer.parseInt(JOptionPane.showInputDialog("Entre com um valor de 1 a 7"));
        while(numeroDia<1 || numeroDia>7){
            numeroDia = Integer.parseInt(JOptionPane.showInputDialog("Entre com um valor de 1 a 7"));
        }

        String diaSemana = "O dia da semana é\n";

        switch (numeroDia) {
            case 1:
                //diaSemana = diaSemana + "Domingo";
                diaSemana += "Domingo";
            break;
        
            case 2:
                diaSemana += "Segunda";
            break;

            case 3:
                diaSemana += "Terça";
            break;

            case 4:
                diaSemana += "Quarta";
            break;

            case 5:
                diaSemana += "Quinta";
            break;

            case 6:
                diaSemana += "Sexta";
            break;

            case 7:
                diaSemana += "Sábado";
            break;

            default:
            diaSemana =  "O número informado não corresponde a nenhum dia da semana.";
        }
        JOptionPane.showMessageDialog(null, diaSemana);
    }
}