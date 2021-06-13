package Currency;

import convert.ICalcualte;

public abstract class Coin implements ICalcualte {
    public abstract double getValue();

    @Override
    public double calculate(double value) {
        return value;
    }

}

