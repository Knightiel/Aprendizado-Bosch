import javax.swing.JOptionPane;

public class EntradaSaida {

    public static double pedirNumero(String contador){
        return Double.parseDouble(JOptionPane.showInputDialog("Informe o " + contador + " número"));
    }

    public static int pedirOperacao(){
        return Integer.parseInt(JOptionPane.showInputDialog("Escolha a operação desejada\n 1 - Soma\n 2 - Subtração\n 3 - Multiplicação\n 4 - Divisão"));
    }

    public static void mostrarMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void mostrarResultado(double num1, double num2, int operacao, double resultado){
        String op = "";
        if(operacao == 1){
            op = "soma";
        }else if (operacao == 2){
            op = "subtração";
        }else if (operacao == 3){
            op = "multiplicação";
        }else{
            op = "divisão";
        }
        JOptionPane.showMessageDialog(null, "O resultado da " + op + " entre " + num1 + " e " + num2 + " é " + resultado);
    }
}