package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Informe os dados da conta");
			System.out.print("Numero: ");
			int number = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			double limiteDeSaque = sc.nextDouble();

			Account acc = new Account(number, nome, saldo, limiteDeSaque);

			System.out.print("Entre com o valor que deseja sacar: ");
			double valorDeSaque = sc.nextDouble();
			acc.withdraw(valorDeSaque);

			System.out.printf("Novo saldo : %.2f%n", acc.getBalance());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}

}
