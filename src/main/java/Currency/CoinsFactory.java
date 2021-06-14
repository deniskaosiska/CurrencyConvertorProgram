package Currency;
import convert.ICalcualte;
public class CoinsFactory {
    //factory that choosing amount from ENUM class and return value of amount
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
