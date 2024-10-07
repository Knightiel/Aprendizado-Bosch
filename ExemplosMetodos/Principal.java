public class Principal {
    public static void main(String[] args) {

        double num1 = EntradaSaida.pedirNumero("1°");
        double num2 = EntradaSaida.pedirNumero("2°");
        double resultado = 0;
        boolean opcaoInvalida = false;

        int opcao = EntradaSaida.pedirOperacao();

        switch (opcao) {
            case 1:
                resultado = Calculo.somar(num1, num2);
                break;

            case 2:
                resultado = Calculo.subtrair(num1, num2);
                break;

            case 3:
                resultado = Calculo.multiplicar(num1, num2);
                break;

            case 4:
                if (num2 != 0) {
                    resultado = Calculo.dividir(num1, num2);
                }else{
                    EntradaSaida.mostrarMsg("A divisão não pode ser calculada");
                    opcaoInvalida = true;
                }
                break;

            default:
                EntradaSaida.mostrarMsg("Operação inválida.");
                opcaoInvalida = true;
                break;
        }

       /*if (num2 != 0 && opcao != 4 && opcaoInvalida == false){
        EntradaSaida.mostrarResultado(num1, num2, opcao, resultado);
        } */

        if (opcaoInvalida == false){
        EntradaSaida.mostrarResultado(num1, num2, opcao, resultado);
        } 

    }//fechamento do método main
}//fechamento da classe Principal 
