package lesson6.adapter.math.v2;

import lesson6.adapter.math.Arifmetika;
import lesson6.adapter.math.v2.calc.Calculator;

public class AdapterByClass extends Arifmetika implements Calculator {
    @Override
    public int summa(int a, int b) {
        int [] array = {a, b};
        return summa(array);
    }
    @Override
    public int multiply(int a, int b) {
        return multiply(a, b);
    }
}
