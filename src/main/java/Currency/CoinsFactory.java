package Currency;
import convert.ICalcualte;
public class CoinsFactory {
    public static Coin getCoinInstance(Coins coin){
        switch(coin){
            case ILS:
            return new ILS();
            case USD:
            return new USD();
        }
        throw new RuntimeException("Should not have gotten here");
    }



}
