import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner read = new Scanner(System.in);
		double value = 0;
		System.out.println("Olá, seja bem-vindo!\nPor favor, qual é seu nome?\n");
		String clientName = read.nextLine();
		String typeAccount = "Conta Corrente";
		double balance = new Random().nextDouble(2000);
		int option = 0;
		System.out.println("--------------------");
		System.out.println("\nNome do cliente: " + clientName);
		System.out.println("Tipo de conta: " + typeAccount);
		System.out.println(String.format("Saldo: R$%.2f", balance));
		System.out.println("--------------------");

		String menuu = """
					**Escolha sua opção**
					1 - Consultar saldo
					2 - Transferir valor
					3 - Receber valor
					4 - Sair
				""";

		while (option != 4) {
			System.out.println(menuu);
			option = read.nextInt();

			if (option == 4) {
				System.out.println("Saindo...");
			}
			else {
				switch (option) {
					case 1:
						System.out.println(String.format("Seu saldo é R$%.2f", balance));
						break;
					case 2:
						System.out.println("Quanto você deseja transferir?\n");
						value = read.nextDouble();
						balance -= value;
						break;
					case 3:
						double newValue = new Random().nextDouble(1000);
						balance += newValue;
						System.out.println(String.format("Você recebeu um valor de R$%.2f", newValue));
						break;
					default:
						System.out.println("O número digitado não corresponde a nenhuma opção existente.");
						break;
				}
			}
		}
		read.close();
	}
}
