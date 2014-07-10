package exercises;

// AmortizationSchedule monthly data
public class AmortizationMonthlyResult {
	private int paymentNumber = 0;
	private double curMonthlyPaymentAmount = 0;
	private double curMonthlyInterest = 0;
	private double curBalance = 0;
	private double totalPayments = 0;
	private double totalInterestPaid = 0;
	
	public AmortizationMonthlyResult(int paymentNumber, double curMonthlyPaymentAmount, double curMonthlyInterest, double curBalance, double totalPayments, double totalInterestPaid){
		this.paymentNumber = paymentNumber;
		this.curMonthlyPaymentAmount = curMonthlyPaymentAmount;
		this.curMonthlyInterest = curMonthlyInterest;
		this.curBalance = curBalance;
		this.totalPayments = totalPayments;
		this.totalInterestPaid = totalInterestPaid; 
	}

	public int getPaymentNumber() {
		return paymentNumber;
	}

	public double getCurMonthlyPaymentAmount() {
		return curMonthlyPaymentAmount;
	}

	public double getCurMonthlyInterest() {
		return curMonthlyInterest;
	}

	public double getCurBalance() {
		return curBalance;
	}

	public double getTotalPayments() {
		return totalPayments;
	}

	public double getTotalInterestPaid() {
		return totalInterestPaid;
	}
}
