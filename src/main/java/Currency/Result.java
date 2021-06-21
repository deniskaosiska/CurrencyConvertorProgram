package Currency;





import Test.TestConvertor;

import java.io.IOException;
import java.util.Scanner;

public class Result  {
    public double value;
    public double input;

    public void conversionFlowILStoEUR() throws IOException {
        EUR eur = new EUR();
        Scanner scanner5 = new Scanner(System.in);
        input = scanner5.nextDouble();
        TestConvertor testConvertor = new TestConvertor();
        testConvertor.enteredValue(input);
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.EUR);
        value = ilsValue.calculate(input);
        testConvertor.assertResultIlsToEUR(value);
        System.out.print(value);
        System.out.println(" " + eur.value + " ILS to USD");
        eur.conversionFlow();
    }

    public void conversionFlowILStoUSD() throws IOException {
        USD usd = new USD();
        Scanner scanner5 = new Scanner(System.in);
        input = scanner5.nextDouble();
        TestConvertor testConvertor = new TestConvertor();
        testConvertor.enteredValue(input);
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.USD);
         value = ilsValue.calculate(input);
        testConvertor.assertResultIlsToUsd(value);
        System.out.print(value);
        System.out.println(" " + usd.value + " ILS to USD");
        usd.conversionFlow();
    }
    public void conversionFlowUSDtoILS() throws IOException {
        ILS ils = new ILS();
        Scanner scanner5 = new Scanner(System.in);
        input = scanner5.nextDouble();
        TestConvertor testConvertor = new TestConvertor();
        testConvertor.enteredValue(input);
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.ILS);
         value = ilsValue.calculate(input);
        testConvertor.assertResultUsdToIls(value);
        System.out.print(value);
        System.out.println(" " + ils.value + " ILS to USD");
        ils.conversionFlow();
    }




}
