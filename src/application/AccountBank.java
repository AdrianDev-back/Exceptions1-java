package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class AccountBank {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Posso tambem utilizar "Try (Scanner sc = new Scanner(System.in) {..." ao invés do finally no final do catch
		//pois o java fecha automaticamente o Scanner no final.
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.next();
		String holder = sc.nextLine();
		System.out.print("Initial Balance: ");
		double initBalance = sc.nextDouble();
		if (initBalance <= 0.0) {
			throw new WithdrawException(" Please, insert value greater than 0");
		}
		System.out.print("Withdraw limit: ");
		double limit = sc.nextDouble();
		
		Account acc = new Account(number, holder, initBalance, limit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		acc.withdrawExceptions(amount);
		System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch (WithdrawException e){
			System.out.println("Withdraw error:" + e.getMessage());	
		}
		catch (InputMismatchException e) {
			System.out.println("Imput error");
		}
		finally {
			sc.close();
		}
		
	}

}
