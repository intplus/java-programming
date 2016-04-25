package lesson6.adapter.math.v1;

import lesson6.adapter.math.Arifmetika;
import lesson6.adapter.math.v1.calc.Calculator;

public class AdapterByObject extends Calculator {
    private Arifmetika arifmetika;

    public AdapterByObject() {
        arifmetika = new Arifmetika();
    }

    @Override
    public int multiply(int a, int b) {
        return arifmetika.multiply(a, b);
    }

    @Override
    public int summa(int a, int b) {
        int [] array = {a, b};
        return arifmetika.summa(array);
    }
}
