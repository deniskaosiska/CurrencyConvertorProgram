package Currency;

import com.sun.tools.javac.Main;

public class USD extends Coin{
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
}
