package System;

import java.util.Scanner;

public class testMain {

	public static void main(String [] args) {
		boolean flag = false, flag2 = false;
		bankFeatures bank = new bankFeatures();
		
		int choice , choice2;
		float rate = 2.5f;
		String accountNumber;
		bank.add();
		do {
			choice = bank.mainMenu();
			if (choice == 1) {
				bank.openAccount(rate);
			}
			else if (choice == 2) {
				bank.delete();
			}
			else if (choice == 3) {
				accountNumber = bank.login();
				do {
					flag2 = false;
				choice2 = bank.accountMenu(accountNumber);
				if (choice2 == 1) {
				bank.makeDeposit(accountNumber);
				flag2 = false;
			}
				else if (choice2 == 2) {
					bank.makeWithdrawal(accountNumber);
					flag2 = false;

				}
				else if (choice2 == 3) {
					bank.trasferAmount(accountNumber);
					flag2 = false;

				}
				else if (choice2 == 4) {
					bank.checkBalance(accountNumber);
					flag2 = false;

				}
				else if (choice2 == 5) {
					bank.statement(accountNumber);
					flag2 = false;

				}
				else if (choice2 == 6) {
					bank.calculateZakat(accountNumber);
					flag2 = false;

				}
				else if(choice2 == 7) {
					bank.calculateIntrest(accountNumber, rate);
				}
					
				else if (choice2 == 8){
					bank.displayDeducitons(accountNumber);
					flag2 = false;
				}
				else if (choice2 == 9) {
					flag2 = true;
					flag = false;
					break;
				}
			}while(!flag2);
			}
			else if (choice == 4) {
				rate = bank.intrestFormula();
				flag = false;
			}
			else if (choice == 5) {
				bank.display();
				flag = false;
			}
			else if (choice == 6) {
				bank.displayDeducitons();
				flag = false;
			}
			else if (choice == 7) {
				System.out.println("Thank you!");
				flag = false;
				break;
			}
		}while (!flag);
	}
}