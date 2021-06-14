package Currency;

import java.io.Serializable;

public class ILS extends Coin implements Serializable {
    final double value = 0.28;
//Method that come from Coin class
    @Override
    public  double getValue() {
        return value;
    }
//Method that come from ICalcualte interface that implemnt in Coin class
    @Override
    public  double calculate(double input) {
        return input * getValue();

    }
}
