import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) {
        // Obter o valor financeiro informado pelo usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor financeiro: ");
        double valorFinanceiro = scanner.nextDouble();
        
        // Obter a moeda de origem
        System.out.print("Digite a moeda de origem (dólar, real, euro, etc.): ");
        String moedaOrigem = scanner.next();
        
        // Obter a moeda de conversão
        System.out.print("Digite a moeda de conversão (dólar, real, euro, etc.): ");
        String moedaConversao = scanner.next();
        
        // Realizar a conversão
        double valorConvertido = converterMoeda(valorFinanceiro, moedaOrigem, moedaConversao);
        
        // Exibir o resultado
        System.out.println("Valor convertido: " + valorConvertido);
        
        scanner.close();
    }
    
    public static double converterMoeda(double valor, String moedaOrigem, String moedaConversao) {
        double taxaDolarParaReal = 5.35; // Exemplo: 1 dólar = 5.35 reais
        
        if (moedaOrigem.equalsIgnoreCase("dólar") && moedaConversao.equalsIgnoreCase("real")) {
            return valor * taxaDolarParaReal;
        } else if (moedaOrigem.equalsIgnoreCase("real") && moedaConversao.equalsIgnoreCase("dólar")) {
            return valor / taxaDolarParaReal;
        } else {
            System.out.println("Conversão não suportada.");
            return 0.0;
        }
    }
}
