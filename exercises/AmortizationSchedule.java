package exercises;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.NumberFormatException; 
import java.util.IllegalFormatException; 
import java.util.List;
import java.lang.IllegalArgumentException;

// Driver Class for running the whole program
public class AmortizationSchedule {
	private static Console console = System.console();
	// Choose from 1 or 2.     1:Console   2:HTML
	private int outputFormat = -1;
	
	public int getOutputStyle(){
		return outputFormat;
	}

	static void printf(String formatString, Object... args) {
		try {
			if (console != null) {
				console.printf(formatString, args); } 
			else {
				System.out.print(String.format(formatString,args));
			}
		} catch (IllegalFormatException e) {
			System.err.print("Error printing...\n");
		} 
	}

	static void print(String s) { 
		printf("%s", s);
	}
	private static String readLine(String userPrompt) throws IOException {
		String line = "";
		if (console != null) {
			line = console.readLine(userPrompt);
		} else {
			// print("console is null\n");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			print(userPrompt);
			line = bufferedReader.readLine();
		} 
		line.trim(); 
		return line;
	}

	public AmortizationPlan inputPlan() throws IllegalArgumentException{
		String[] userPrompts = {
				"Please enter the amount you would like to borrow: ", 
				"Please enter the annual percentage rate usedto repay the loan: ", 
				"Please enter the term, in years, over which the loan is repaid:",
				"Please enter the output style. 1 for Console or 2 for HTML: "
		};
		String line= "";
		double amount = 0; 
		double apr = 0; 
		int years = 0;
		for (int i = 0; i< userPrompts.length; ) { 
			String userPrompt = userPrompts[i]; 
			try {
				line = readLine(userPrompt);
			}
			catch (IOException e) {
				print("An IOException was encountered. Terminating program.\n");
				return null; 
			}

			boolean isValidValue = true; 
			try {
				switch (i) {
				case 0:
					amount = Double.parseDouble(line);
					if (AmortizationPlan.isValidBorrowAmount(amount) == false){
						isValidValue = false; 
						double range[] = AmortizationPlan.getBorrowAmountRange();

						print("Please enter a positive value between " + range[0] + " and " + range[1] + ". ");
					}
					break;
				case 1:
					apr = Double.parseDouble(line);
					if (AmortizationPlan.isValidAPRValue(apr) == false) {
						isValidValue = false;
						double range[] = AmortizationPlan.getAPRRange(); 
						print("Please enter a positive value between " + range[0] + " and " + range[1] + ". "); }
					break;
				case 2:
					years = Integer.parseInt(line);
					if (AmortizationPlan.isValidTerm(years) == false) {
						isValidValue = false;
						int range[] = AmortizationPlan.getTermRange(); 
						print("Please enter a positive integer value between " + range[0] + " and " + range[1] + ". "); }
					break; 
				case 3:
					outputFormat = Integer.parseInt(line);
					if (outputFormat != 1 && outputFormat != 2) {
						isValidValue = false;
						print("Please enter 1 for Console or 2 for HTML\n"); }
					break;
				}
			} catch (NumberFormatException e) { 
				isValidValue = false;
			}
			if (isValidValue) {
				i++; } 
			else {
				print("An invalid value was entered.\n");
			} 
		}
		AmortizationPlan ap = new AmortizationPlan(amount, apr, years);
		return ap;

	}

	public static void main(String [] args) {
		AmortizationSchedule as = new AmortizationSchedule();
		try {
			//ap is an input plan which contains the 3 inputs
			AmortizationPlan ap = as.inputPlan();
			if (ap == null){
				return;
			}
			AmortizationCalculator cal = new AmortizationCalculatorOne();
			List<AmortizationMonthlyResult> amr = cal.calculate(ap);
			AmortizationOutput ao = null;
			switch (as.getOutputStyle()){
			case 1: 
				ao = new AmortizationOutputConsole(amr);
				break;
			case 2:
				ao = new AmortizationOutputHTML(amr);
				break;
			}
			//output the specified format results
			ao.outputAmortizationSchedule();
		} catch (IllegalArgumentException e) { 
			print("Unable to process the values entered.Terminating program.\n");
		}
	}
} 