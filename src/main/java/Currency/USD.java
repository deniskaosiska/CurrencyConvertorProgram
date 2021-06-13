package Currency;

import com.sun.tools.javac.Main;

public class USD extends Coin{
    final double value = 3.52;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public static double calculate(double input) {
        return input * getValue();

    }
}
