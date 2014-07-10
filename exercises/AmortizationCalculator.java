package exercises;

import java.util.ArrayList;
import java.util.List;
//An abstract class for AmortizationCalculator, which has a defined calculate function to return the monthly payment results.
//Any specific Calculator Subclass should define its own calculateMonthllyPayment function
public abstract class AmortizationCalculator {
	protected final double monthlyInterestDivisor = 12d * 100d;

	public long calculateMonthlyPayment(AmortizationPlan ap){
		return 0;
	}

	public List<AmortizationMonthlyResult> calculate(AmortizationPlan ap) throws IllegalArgumentException {
		
		double monthlyInterest = ap.getApr() / monthlyInterestDivisor;
		long monthlyPaymentAmount = calculateMonthlyPayment(ap);
		
		if (monthlyPaymentAmount > ap.getAmountBorrowed()) {
			throw new IllegalArgumentException();
		}
		List<AmortizationMonthlyResult> listMonthlyResult = new ArrayList<AmortizationMonthlyResult>();
		long balance = ap.getAmountBorrowed(); 
		int paymentNumber = 0;
		long totalPayments = 0;
		long totalInterestPaid = 0;

		listMonthlyResult.add(new AmortizationMonthlyResult(paymentNumber++, 0d, 0d, ((double) balance) / 100d, ((double) totalPayments) / 100d, ((double) totalInterestPaid) / 100d));
		final int maxNumberOfPayments = ap.getInitialTermMonths() + 1;
		while ((balance > 0) && (paymentNumber <= maxNumberOfPayments)) {
			long curMonthlyInterest = Math.round(((double)balance) * monthlyInterest);
			long curPayoffAmount = balance + curMonthlyInterest;
			long curMonthlyPaymentAmount = Math.min(monthlyPaymentAmount, curPayoffAmount);
			if ((paymentNumber == maxNumberOfPayments) && ((curMonthlyPaymentAmount == 0) || (curMonthlyPaymentAmount == curMonthlyInterest))) {
				curMonthlyPaymentAmount = curPayoffAmount;
			}
			long curMonthlyPrincipalPaid = curMonthlyPaymentAmount - curMonthlyInterest;

			long curBalance = balance - curMonthlyPrincipalPaid;
			totalPayments += curMonthlyPaymentAmount; 
			totalInterestPaid += curMonthlyInterest;
			listMonthlyResult.add(new AmortizationMonthlyResult(paymentNumber++, ((double) curMonthlyPaymentAmount)/100d, ((double) curMonthlyInterest) / 100d, 
					((double) curBalance) / 100d, ((double) totalPayments) / 100d, ((double) totalInterestPaid) / 100d));
			balance = curBalance;
		}
		return listMonthlyResult;

	}
}
