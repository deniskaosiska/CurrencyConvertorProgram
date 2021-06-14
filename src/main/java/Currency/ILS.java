package Currency;

public class ILS extends Coin{
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
