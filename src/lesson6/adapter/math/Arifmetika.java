package lesson6.adapter.math;

public class Arifmetika {

	public int summa(int[] numbers) {
		int summa = 0;
		for (int i : numbers) {
			summa += i;
		}
		return summa;
	}
	
	public int multiply(int number, int multiplier) {
		int result = 0;
		for (int i = 0; i < multiplier; i++) {
			result *= multiplier;
		}
		return result;
	}
}
