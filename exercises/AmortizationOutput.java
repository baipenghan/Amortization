package exercises;

import java.util.List;
//An abstract class for AmortizationOutput. All the specific output (i.e. Console, Web) could extend it.
public abstract class AmortizationOutput {
	protected List<AmortizationMonthlyResult> listAMR;
	
	public AmortizationOutput(List<AmortizationMonthlyResult> listAMR){
		this.listAMR = listAMR;
	}
	public void outputAmortizationSchedule(){
		}
}
