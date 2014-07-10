package exercises;

// A example of Calculator for monthly payments.
public class AmortizationCalculatorOne extends AmortizationCalculator {
	
	public long calculateMonthlyPayment(AmortizationPlan ap){
		double monthlyInterest = ap.getApr() / super.monthlyInterestDivisor;
		double tmp = Math.pow(1d + monthlyInterest, -1);
		tmp = Math.pow(tmp, ap.getInitialTermMonths());
		tmp = Math.pow(1d - tmp, -1);
		double rc = ap.getAmountBorrowed() * monthlyInterest * tmp;
		return Math.round(rc);
		
	}
	
}
