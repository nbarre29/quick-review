package com.mindtree.bank;

public class BankDemo {

	public static void main(String[] args) {
		BankAccount banuAccount = new BankAccount(56000.40);
		banuAccount.deposit(152.00);
	
		System.out.println("Balance in Banu's account: "+ banuAccount.getBalance());
		
		BankAccount rahulAccount = new BankAccount(8500.00);
		BankAccount kavithaAccount = rahulAccount;
		

		try {
			rahulAccount.withdraw(10000);
			System.out.println("Balance in Rahul's account: "+rahulAccount.getBalance());
			
			
			kavithaAccount.withdraw(2000.00);
			System.out.println("Balance in Kavitha's / Rahul's account: " + rahulAccount.getBalance());
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Sorry, you are in short of: "+ e.getAmount() + " Rs./-");
		}
		
	

		System.out.println("THe number of customers / accounts: "+ BankAccount.getCounter());
		
		
		

	}

}
