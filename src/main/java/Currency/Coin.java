package Currency;

import convert.ICalcualte;

public abstract class Coin implements ICalcualte {
    //Returns value of amount
    public abstract double getValue();
//Gets value and return value
    @Override
    public double calculate(double value) {
        return value;
    }

}

