package lesson6.adapter.math.v2;

import lesson6.adapter.math.Arifmetika;
import lesson6.adapter.math.v2.calc.Calculator;

public class AdapterByClass implements Calculator {
    @Override
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
