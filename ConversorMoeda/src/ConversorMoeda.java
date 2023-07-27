
import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) {
        // Definir a taxa de convers�o das moedas
        double taxaDolarParaReal = 5.35; // Exemplo: 1 d�lar = 5.35 reais
        
        // Obter o valor financeiro informado pelo usu�rio
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor financeiro: ");
        double valorFinanceiro = scanner.nextDouble();
        
        // Obter a moeda desejada para convers�o
        System.out.print("Digite a moeda para convers�o (d�lar, real, euro, etc.): ");
        String moeda = scanner.next();
        
        // Realizar a convers�o
        double valorConvertido = 0.0;
        
        if (moeda.equalsIgnoreCase("d�lar")) {
            valorConvertido = valorFinanceiro * taxaDolarParaReal;
        } else if (moeda.equalsIgnoreCase("real")) {
            valorConvertido = valorFinanceiro / taxaDolarParaReal;
        } else {
            System.out.println("Moeda n�o suportada.");
            return;
        }
        
        // Exibir o resultado
        System.out.println("Valor convertido: " + valorConvertido + " " + moeda);
        
        scanner.close();
    }
}
