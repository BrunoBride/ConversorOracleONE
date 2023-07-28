
import java.util.Scanner;

public class ConversorDeMoedas {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Taxas de câmbio em 28 julho 2023 (07 28 23 - mmddyy)
		double taxaDolar = 4.73;
		double taxaEuro = 5.27;
		double taxaLibraEsterlina = 6.14;
		double taxaPesoArgentino = 0.01737;
		double taxaPesoChileno = 0.005747;

		// Pergunta ao usuário qual moeda ele possui e o valor financeiro
		System.out.println("Qual moeda você possui?");
		System.out
				.println("1 - Reais\n2 - Dólar\n3 - Euro\n4 - Libras Esterlinas\n5 - Peso Argentino\n6 - Peso Chileno");
		int moedaOrigem = input.nextInt();

		System.out.println("Informe o valor financeiro:");
		double valorOrigem = input.nextDouble();

		// Oferece opções de conversão
		System.out.println("Para qual moeda você deseja converter?");
		System.out
				.println("1 - Reais\n2 - Dólar\n3 - Euro\n4 - Libras Esterlinas\n5 - Peso Argentino\n6 - Peso Chileno");
		int moedaDestino = input.nextInt();

		// Realiza a conversão de moedas
		double resultado = 0.0;

		if (moedaOrigem == 1) {
			// Converter de Reais para outra moeda
			switch (moedaDestino) {
			case 1:
				resultado = valorOrigem; // Mesma moeda, não precisa converter
				break;
			case 2:
				resultado = valorOrigem / taxaDolar;
				break;
			case 3:
				resultado = valorOrigem / taxaEuro;
				break;
			case 4:
				resultado = valorOrigem / taxaLibraEsterlina;
				break;
			case 5:
				resultado = valorOrigem / taxaPesoArgentino;
				break;
			case 6:
				resultado = valorOrigem / taxaPesoChileno;
				break;
			default:
				System.out.println("Moeda de destino inválida.");
				break;
			}
		} else if (moedaDestino == 1) {
			// Converter para Reais a partir de outra moeda
			switch (moedaOrigem) {
		
			case 2:
				resultado = valorOrigem * taxaDolar;
				break;
			case 3:
				resultado = valorOrigem * taxaEuro;
				break;
			case 4:
				resultado = valorOrigem * taxaLibraEsterlina;
				break;
			case 5:
				resultado = valorOrigem * taxaPesoArgentino;
				break;
			case 6:
				resultado = valorOrigem * taxaPesoChileno;
				break;
			default:
				System.out.println("Moeda de origem inválida.");
				break;
			}
		} else {
			System.out.println("Moeda de origem ou destino inválida.");
		}

		// Exibindo o resultado da conversão
		System.out.println("O valor convertido é: " + resultado);

		input.close();
	}
}
