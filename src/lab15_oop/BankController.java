package labs.lab15_oop.bank;

import hevs.utils.DateUtils;

/**
 * Simple bank account control class for lab 15
 * @author @author <a href='mailto:pandre.mudry&#64;hevs.ch'> Pierre-André Mudry</a>
 */
public class BankController {
	
	public BankController() {
		/**
		 *  Verify that checks are done correctly
		 *  in constructor
		 */		
		Checking c1;
			
		System.out.print("3 Should trigger error : minbalance positive\n\t");
		c1 = new Checking("Toto", 1000, 1000);		
		
		System.out.print("4 Should trigger error : Amount < min and min < 0\n\t"); 
		c1 = new Checking("Toto", -2000, -1000);		
		
		/**
		 * Functional tests that are asserted
		 */		
		// Set a positive limit (impossible)
		System.out.print("6 Should trigger error : minbalance positive\n\t");
		c1 = new Checking("Test", 1000, -1000);
		c1.setMinBalance(10000.0);
					
		/**
		 * Savings account checks
		 */
		Savings s1;
		
		System.out.print("9 Should trigger error : abnormal init of savings\n\t");
		s1 = new Savings("Toto", 1000, -3.0);
				
		// Deposit of negative value
		System.out.print("11 Should trigger error : negative deposit \n\t");
		s1 = new Savings("Test", 1000, 1.0);
		s1.deposit(-100.0);
		assert s1.getBalance() == 1000.0;
		
		// Withdrawing more than possible
		System.out.print("12 Should trigger error : taking more than available\n\t");
		s1 = new Savings("Test", 1000, 1.0);
		s1.withdraw(3000);	
		assert s1.balance == 1000 : s1.balance;
		
		// Interest computation check and normal operations checks
		System.out.println("13 Should not trigger error : interest check and normal operations");
		s1 = new Savings("Test", 1000, 0.032);
		s1.withdraw(20.0);	
		assert s1.balance == (1000 - 20.0);
		s1.withdraw(100.0);	
		assert s1.balance == 1000 - 20.0 - 100.0;
		s1.deposit(120.0);	
		assert s1.balance == 1000.0;
		double interest = s1.calcInterest(DateUtils.createDate("1/1/2011"), DateUtils.createDate("11/1/2011"));
		
		// Manual check of interest
		assert interest == ((1000.0 * 10 * 3.2 / 100) / 360.0);		
	}
		
	/**	
	 * @param args
	 */
	public static void main(String[] args) throws RuntimeException{
		boolean assertionsAreEnabled = false;
		assert (assertionsAreEnabled = true);

		if (!assertionsAreEnabled) {
			throw new RuntimeException( "Assertions must be enabled ! Add -ea to the VM arguments " +
					"(Run Configuration menu in Eclipse)" );
		}

		new BankController();
	}
}
