
import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) {
        // Definir a taxa de conversão das moedas
        double taxaDolarParaReal = 5.35; // Exemplo: 1 dólar = 5.35 reais
        
        // Obter o valor financeiro informado pelo usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor financeiro: ");
        double valorFinanceiro = scanner.nextDouble();
        
        // Obter a moeda desejada para conversão
        System.out.print("Digite a moeda para conversão (dólar, real, euro, etc.): ");
        String moeda = scanner.next();
        
        // Realizar a conversão
        double valorConvertido = 0.0;
        
        if (moeda.equalsIgnoreCase("dólar")) {
            valorConvertido = valorFinanceiro * taxaDolarParaReal;
        } else if (moeda.equalsIgnoreCase("real")) {
            valorConvertido = valorFinanceiro / taxaDolarParaReal;
        } else {
            System.out.println("Moeda não suportada.");
            return;
        }
        
        // Exibir o resultado
        System.out.println("Valor convertido: " + valorConvertido + " " + moeda);
        
        scanner.close();
    }
}
