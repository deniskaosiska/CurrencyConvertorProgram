package Currency;

import java.io.Serializable;

public class USD extends Coin implements Serializable {
    final double value = 3.52;
    //Method that come from Coin class
    @Override
    public double getValue() {
        return value;
    }
    //Method that come from ICalcualte interface that implemnt in Coin class
    @Override
    public double calculate(double input) {
        return input * getValue();
    }
    public Object conversionFlow(){

        return (" " + value + " ILS to USD");

    }
}
