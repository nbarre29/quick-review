package com.mindtree.bank;

public class BankAccount {
	
	//hold the balance infomation
	private double balance;
	
	private static int counter = 0;
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		BankAccount.counter = counter;
	}

	public BankAccount(double initialAmount) {
		this.balance = initialAmount;
				counter++;
	}
	
	/**
	 * @param amount to be deposited
	 */
	public void deposit(double amount){
		balance += amount;
	}

	/**
	 * @param amount to be withdrawn
	 * @throws InsufficientFundsException 
	 */
	public void withdraw(double amount) throws InsufficientFundsException{
		
		if (amount <= balance) {
			balance -= amount;
		} else {
			double negativeBalance = amount - balance;
			throw new InsufficientFundsException(negativeBalance);

		}
		
		
	}

	/**
	 * @return the current balance in the account
	 */
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
