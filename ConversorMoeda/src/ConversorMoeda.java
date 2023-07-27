import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) {
        // Obter o valor financeiro informado pelo usu�rio
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor financeiro: ");
        double valorFinanceiro = scanner.nextDouble();
        
        // Obter a moeda de origem
        System.out.print("Digite a moeda de origem (d�lar, real, euro, etc.): ");
        String moedaOrigem = scanner.next();
        
        // Obter a moeda de convers�o
        System.out.print("Digite a moeda de convers�o (d�lar, real, euro, etc.): ");
        String moedaConversao = scanner.next();
        
        // Realizar a convers�o
        double valorConvertido = converterMoeda(valorFinanceiro, moedaOrigem, moedaConversao);
        
        // Exibir o resultado
        System.out.println("Valor convertido: " + valorConvertido);
        
        scanner.close();
    }
    
    public static double converterMoeda(double valor, String moedaOrigem, String moedaConversao) {
        double taxaDolarParaReal = 5.35; // Exemplo: 1 d�lar = 5.35 reais
        
        if (moedaOrigem.equalsIgnoreCase("d�lar") && moedaConversao.equalsIgnoreCase("real")) {
            return valor * taxaDolarParaReal;
        } else if (moedaOrigem.equalsIgnoreCase("real") && moedaConversao.equalsIgnoreCase("d�lar")) {
            return valor / taxaDolarParaReal;
        } else {
            System.out.println("Convers�o n�o suportada.");
            return 0.0;
        }
    }
}
