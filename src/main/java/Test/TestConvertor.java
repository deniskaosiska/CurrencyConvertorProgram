package Test;
import Currency.Coin;
import Currency.Coins;
import Currency.CoinsFactory;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;
import static org.junit.Assert.*;


public class TestConvertor {
    boolean valid = false;
    double input;
    double value;
    double result;
    double rate;
    private static final double DELTA = 1e-15;


    @Test
    public void enteredValue(double input) throws IOException {

        this.input = input;

        if (input < 0) {
            System.out.println("Invalid value");
        }
    }
      @Test
          public void assertResultIlsToEUR(double value) {
            this.value= value;
          Coin ilsValue = CoinsFactory.getCoinInstance(Coins.EUR);
          rate = ilsValue.calculate(input);
            result = rate;
            assertEquals(result,value,DELTA);
       }
    @Test
    public void assertResultIlsToUsd(double value) {
        this.value= value;
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.USD);
        rate = ilsValue.calculate(input);
        result = rate;
        assertEquals(result,value,DELTA);
    }
    @Test
    public void assertResultUsdToIls(double value) {
        this.value= value;
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.ILS);
        rate = ilsValue.calculate(input);
        result = rate;
        assertEquals(result,value,DELTA);
    }

       @Test
          public void contentResult()  {
           File file = new File("C:\\Users\\Denis.Kozyra\\OneDrive - xcircular.com\\Desktop\\results.txt");

           try {
               Scanner scanner = new Scanner(file);

               //now read the file line by line...
               int lineNum = 0;
               while (scanner.hasNextLine()) {
                   String line = scanner.nextLine();
                   lineNum++;
                   if(line.equalsIgnoreCase("result")) {
                       System.out.println(" I found it on line " +lineNum);
                   }
               }
           } catch(FileNotFoundException e) {
               e.printStackTrace();
               System.out.println("Something go wrong, no mentioned result in file");
           }
            }

}


