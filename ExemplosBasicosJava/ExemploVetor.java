import javax.swing.JOptionPane;

public class ExemploVetor {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        for(int i=0; i<10; i++){
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o  " + (i+1) + "° valor"));
        }

        //int[] numeros = {1, 5, -9, 12, 70};
    }
}
