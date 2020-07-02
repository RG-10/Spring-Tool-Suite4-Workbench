package CgpaCalculator;

public class CGPACalculation {
	
	private double sum = 0;

	
	public double getSum() {
		return sum;
	}


	public void setSum(double sum) {
		this.sum = sum;
	}


	CGPACalculation( double marks[]){
		
		double grade[] = new double[marks.length];
		
		for (int i=0; i<marks.length; i++) {
			
			grade[i] = marks[i]/10;
			
		}
		
		for (int i=0; i<marks.length; i++) {
			sum += grade[i];
		}
	}

}
