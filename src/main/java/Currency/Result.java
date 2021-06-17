package Currency;



import java.util.Scanner;

public class Result  {
    public double value;
    public void conversionFlowILStoEUR(){
        EUR eur = new EUR();
        Scanner scanner5 = new Scanner(System.in);
        double input = scanner5.nextDouble();
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.EUR);
        value = ilsValue.calculate(input);
        System.out.print(value);
        System.out.println(" " + eur.value + " ILS to USD");
        eur.conversionFlow();
    }
    public void conversionFlowILStoUSD(){
        USD usd = new USD();
        Scanner scanner5 = new Scanner(System.in);
        double input = scanner5.nextDouble();
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.USD);
         value = ilsValue.calculate(input);
        System.out.print(value);
        System.out.println(" " + usd.value + " ILS to USD");
        usd.conversionFlow();
    }
    public void conversionFlowUSDtoILS(){
        ILS ils = new ILS();
        Scanner scanner5 = new Scanner(System.in);
        double input = scanner5.nextDouble();
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.ILS);
         value = ilsValue.calculate(input);
        System.out.print(value);
        System.out.println(" " + ils.value + " ILS to USD");
        ils.conversionFlow();
    }



}
