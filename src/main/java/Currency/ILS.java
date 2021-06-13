package Currency;

public class ILS extends Coin{
    final double value = 0.28;

    @Override
    public static double getValue() {
        return value;
    }

    @Override
    public static double calculate(double input) {
        return input * getValue();

    }
}
