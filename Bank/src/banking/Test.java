package banking;

public class Test {
	
	public static void main(String[] args) {
		BankAccount b1;  //declaration   //Type + variable	
		b1 = new BankAccount(100); //BankAccount b1 = new BankAccount() 
		BankAccount b2 = new BankAccount (300);
		
		BankAccount b3 = b1.replicate();
		
		
		b1.deposit(100);
		
		System.out.println(b1.getBalance());
		System.out.println(b1);
		System.out.println(b2.getBalance());
		System.out.println(BankAccount.getNumAccounts());
	}

}
