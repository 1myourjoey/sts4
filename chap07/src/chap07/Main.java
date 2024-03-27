package chap07;

public class Main {

	public static void main(String[] args) {
		ImpeCalculator cal1 = new ImpeCalculator();
		System.out.println(cal1.factorial(20));
		
		RecCalculator cal2 = new RecCalculator();
		System.out.println(cal2.factorial(2));
	}

}
