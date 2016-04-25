package lesson6.adapter.math.v2;

import java.util.Random;

import lesson6.adapter.math.v2.calc.Calculator;

public class Launcher {

	public static void main(String[] args) {
		Calculator calc = new AdapterByClass();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}
	}
}
