package exercises;
import java.lang.IllegalArgumentException;

//Class for storing input data (amountBorrowed, apr, years)
public class AmortizationPlan {
	private static final double[] borrowAmountRange = new double[] { 0.01d, 1000000000000d };
	private static final double[] aprRange = new double[] { 0.000001d, 100d };
	private static final int[] termRange = new int[] { 1, 1000000 };

	private long amountBorrowed = 0; // in cents 
	private double apr = 0d;
	private int initialTermMonths = 0;
	
	public AmortizationPlan(double amount, double interestRate, int years) throws IllegalArgumentException{
		if ((isValidBorrowAmount(amount) == false) || (isValidAPRValue(interestRate) == false) ||(isValidTerm(years) == false))
		{ 
			throw new IllegalArgumentException();
		}
		else{
			amountBorrowed = Math.round(amount * 100); 
			apr = interestRate;
			initialTermMonths = years * 12;
		}
	}

	public static boolean isValidBorrowAmount(double amount) { 
		double range[] = getBorrowAmountRange();
		return ((range[0] <= amount) && (amount <= range[1]));
	}
	public static boolean isValidAPRValue(double rate) { 
		double range[] = getAPRRange();
		return ((range[0] <= rate) && (rate <= range[1]));
	}
	public static boolean isValidTerm(int years) {
		int range[] = getTermRange();
		return ((range[0] <= years) && (years <= range[1]));
	}
	public static final double[] getBorrowAmountRange() { 
		return borrowAmountRange;
	}
	public static final double[] getAPRRange() { 
		return aprRange;
	}
	public static final int[] getTermRange() { 
		return termRange;
	}
	
	public long getAmountBorrowed(){
		return amountBorrowed;
	}
	
	public double getApr(){
		return apr;
	} 
	
	public int getInitialTermMonths(){
		return initialTermMonths; 
	} 
}
