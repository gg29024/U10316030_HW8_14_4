
import java.util.*;


public class Loan{
	
	//main method
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		//new an object
		TestLoan object = new TestLoan();
	
		//用do-while迴圈去跑 如果使用者輸入的數字小於零  會跑出錯誤並且要求使用者在輸入一次
		do{
			try{
				
				System.out.print("Enter Number Of Years: ");
				int numberOfYears = input.nextInt();
				
				object.setNumberOfYears(numberOfYears);
				continueInput = false;
				
			}
			catch(IllegalArgumentException ex){
				System.out.print(ex);
				System.out.println();
			}
		}while(continueInput);
		
		continueInput = true;
		
		//用do-while迴圈去跑 如果使用者輸入的數字小於零  會跑出錯誤並且要求使用者在輸入一次
		do{
			try{
				System.out.print("Enter Loan Amount: ");
				double loanAmount = input.nextDouble();
				
				object.setLoanAmount(loanAmount);
				continueInput = false;
				
			}
			catch(IllegalArgumentException ex){
				System.out.print(ex);
				System.out.println();
			}
		}while(continueInput);
		
		continueInput = true;
		
		//用do-while迴圈去跑 如果使用者輸入的數字小於零  會跑出錯誤並且要求使用者在輸入一次
		do{
			try{
			
				System.out.print("Enter Annual Interest Rate: ");
				double annualInterestRate = input.nextDouble();
				
				object.setAnnualInterestRate(annualInterestRate);
				continueInput = false;
				
			}
			catch(IllegalArgumentException ex){
				System.out.print(ex);
				System.out.println();
			}
		}while(continueInput);
		
		//print出最後結果
		System.out.println("Your monthly payment is " + object.getMonthlyPayment());
		System.out.println("Your total payment is " + object.getTotalPayment());
		System.out.println(object.getLoanDate());
		
	}
}


class TestLoan {
	
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public TestLoan() {
		this(2.5, 1, 1000);
	}

	/** Construct a loan with specified annual interest rate,
      number of years and loan amount 
    */
	public TestLoan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}

	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/** Set a new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException{
		 if(annualInterestRate > 0)
				this.annualInterestRate = annualInterestRate;
		 else
				throw new IllegalArgumentException("It can not be negative");
	}

	/** Return numberOfYears */
	public int getNumberOfYears() {
		return numberOfYears;
	}

	/** Set a new numberOfYears */
	public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException{
		if(numberOfYears > 0)
			this.numberOfYears = numberOfYears;
		else
			throw new IllegalArgumentException("It can not be negative");
	
	}

	/** Return loanAmount */
	public double getLoanAmount() {
		return loanAmount;
	}

	/** Set a newloanAmount */
	public void setLoanAmount(double loanAmount) throws IllegalArgumentException{
		if(loanAmount > 0)
			this.loanAmount = loanAmount;
		else
			throw new IllegalArgumentException("It can not be negative");
	}

	/** Find monthly payment */
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -(Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
		return monthlyPayment;    
	}

	/** Find total payment */
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;    
	}

	/** Return loan date */
	public java.util.Date getLoanDate() {
		return loanDate;
	}
	
}
