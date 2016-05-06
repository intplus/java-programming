package lesson6.adapter.math.v1.calc;

import lesson6.adapter.math.Arifmetika;

public class Calculator {

	public int summa(int a, int b) {
		return Arifmetika.summa(new int[] {a, b});
	}

	public int multiply(int a, int b) {
		int result = a;
		for (int i = 0; i < b; ++i) {
			result = Arifmetika.summa(new int[] {result, a});
		}
		return result;
	}
}
