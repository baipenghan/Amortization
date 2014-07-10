package exercises;

import java.util.List;

public class AmortizationOutputHTML extends AmortizationOutput{
	
	public AmortizationOutputHTML(List<AmortizationMonthlyResult> listAMR){
		super(listAMR);
	}
	
	public void outputAmortizationSchedule(){
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE html><html><body><table>" +
				"<tr><td>PaymentNumber</td><td>PaymentAmount</td><td>PaymentInterest</td><td>CurrentBalance, TotalPayments, TotalInterestPaid</td></tr>");
		for (AmortizationMonthlyResult amr: listAMR){
			html.append("<tr><td>" + amr.getPaymentNumber() + "</td><td>" + amr.getCurMonthlyPaymentAmount() + "</td><td>" + amr.getCurMonthlyInterest() + "</td><td>" + amr.getCurBalance() + ", " + amr.getTotalPayments() + ", " + amr.getTotalInterestPaid() + "</td></tr>");
		}
		html.append("</table></body></html>");
		AmortizationSchedule.print(html.toString());
	}

}
