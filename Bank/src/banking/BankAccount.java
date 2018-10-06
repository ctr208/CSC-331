package banking;

public class BankAccount {
	
	//PROPERITIES 
	
	//Instance Variable
	private double balance;
	private BankAccount overdraftAccount = null;
	
	//Class variable
	private static int numberOfAccounts = 0;
	
	//Constructors
	public BankAccount(double balance) { //Constructor (Same name of class, always public, no return type)
		this.balance = balance;
		numberOfAccounts++;
	}
	
	public BankAccount() { //Constructor
		balance = 0;
		numberOfAccounts++;
	}
	
	//BEHAVIER
	
	//Class Method
	public static int getNumAccounts() {
		return numberOfAccounts;
	}
	
	//Instance Methods
	public void deposit(double howMuch) {
		balance = balance + howMuch;
	}
	
	public void withdraw(double howMuch) {
		if (howMuch > balance && overdraftAccount != null) {
			this.transfer(overdraftAccount, 100);
			balance = balance - howMuch;
		}
		
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void transfer(BankAccount fromAccount, double howMuch) {
		fromAccount.withdraw(howMuch);
		this.deposit(howMuch);
	}
	
	public void setOverdraft(BankAccount overdraft) {
		this.overdraftAccount = overdraft;
	}
	
	public String toString() {
		return "bank account with balance "+balance;
	}
	
	public BankAccount replicate(){
		BankAccount copy = new BankAccount(this.balance);
		return copy;
	}
	
}

//Overload: Same name, different parameters (Constructors)
