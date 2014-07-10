package exercises;

import java.util.List;

public class AmortizationOutputConsole extends AmortizationOutput{
	
	public AmortizationOutputConsole(List<AmortizationMonthlyResult> listAMR){
		super(listAMR);
	}
	
	public void outputAmortizationSchedule(){
		String formatString = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
		AmortizationSchedule.printf(formatString, "PaymentNumber", "PaymentAmount", "PaymentInterest", "CurrentBalance", "TotalPayments", "TotalInterestPaid");
		formatString = "%1$-20d%2$-20.2f%3$-20.2f%4$.2f,%5$.2f,%6$.2f\n";
		for (AmortizationMonthlyResult amr: listAMR){
			AmortizationSchedule.printf(formatString, amr.getPaymentNumber(), amr.getCurMonthlyPaymentAmount(), amr.getCurMonthlyInterest(), amr.getCurBalance(), amr.getTotalPayments(), amr.getTotalInterestPaid());
		}
	}

}
