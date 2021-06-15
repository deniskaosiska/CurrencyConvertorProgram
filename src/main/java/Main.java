import Currency.*;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**List of results
     *
     */
    private static ArrayList<Double> MyList = new ArrayList<>();

    /** If user choose start over the convertor
     *
     */
    private static void startOver() {
        System.out.println("Please choose an option (1/2):");
        System.out.println("1. Dollars to Shekels");
        System.out.println("2. Shekels to Dollars");
        Scanner scanner1 = new Scanner(System.in);
        int choose = scanner1.nextInt();
        if (choose == 1) {
            ilsToUsd();
        } else if (choose == 2) {
            usdToils();
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }

    /** If user choose 1 shekels to dollars
     *
     */
    private static void ilsToUsd() {
        System.out.println("Please enter an amount to convert");
        Scanner scanner2 = new Scanner(System.in);
        double input = scanner2.nextDouble();
        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.USD);
        double value = ilsValue.calculate(input);
        System.out.println(value);//Print result of convert
        MyList.add(value);//Add result to list of converts
        System.out.println("Start over Y/N?");
        Scanner scanner3 = new Scanner(System.in);
        String overAgain = scanner3.next();
        if (overAgain.equalsIgnoreCase("Y")) {
            startOver();//Go to begining of program without Welcome
        } else if (overAgain.equalsIgnoreCase("N")) {
             endScreen();//Go to Fourth screen(end screen)
        }
    }

    /**If user choose 2, dollars to shekels
     *
     */
    private static void usdToils() {
            System.out.println("Please enter an amount to convert");
            Scanner scanner5 = new Scanner(System.in);
            double input = scanner5.nextDouble();
            Coin usdValue = CoinsFactory.getCoinInstance(Coins.ILS);
            double value = usdValue.calculate(input);
            System.out.println(value);//Print result of convert
            MyList.add(value);//Add result to list of converts
            System.out.println("Start over Y/N?");
            Scanner scanner3 = new Scanner(System.in);
            String overAgain = scanner3.next();
            if (overAgain.equalsIgnoreCase("Y")) {
                startOver();//Go to begining of program without Welcome
            } else if (overAgain.equalsIgnoreCase("N")) {
                 endScreen();//Go to Fourth screen(end screen)
            }
        }

    /**If user choose 3, shekels to euro
     *
     */
    private static void ilsToEur() {
        System.out.println("Please enter an amount to convert");
        Scanner scanner5 = new Scanner(System.in);
        double input = scanner5.nextDouble();
        Coin usdValue = CoinsFactory.getCoinInstance(Coins.EUR);
        double value = usdValue.calculate(input);
        System.out.println(value);//Print result of convert
        MyList.add(value);//Add result to list of converts
        System.out.println("Start over Y/N?");
        Scanner scanner3 = new Scanner(System.in);
        String overAgain = scanner3.next();
        if (overAgain.equalsIgnoreCase("Y")) {
            startOver();//Go to begining of program without Welcome
        } else if (overAgain.equalsIgnoreCase("N")) {
            endScreen();//Go to Fourth screen(end screen)
        }
    }

    /**Choosing amount program
     *
     */
    private static void chooseProgram(){
        System.out.println("Please choose an option (1/2):");
        System.out.println("1. Dollars to Shekels");
        System.out.println("2. Shekels to Dollars");
        System.out.println("3. Shekels to Euro");
        Scanner scanner1 = new Scanner(System.in);
        int choose = scanner1.nextInt();
        if (choose == 1) {
            ilsToUsd();//Go to method that convert shekels to dollars
        } else if (choose == 2) {
            usdToils();//Go to method that convert dollars to shekels
        } else if (choose == 3) {
            ilsToEur();
        } else {
            System.out.println("Invalid choice, please try again");
            chooseProgram();//Start this.method again
        }
    }

    /**If user choose finish the program
     *
     */
    private static void endScreen() {
        System.out.println("Thanks for using our currency convertor");
        for (int i = 0; i < MyList.size(); i++) {
                System.out.println(MyList.get(i));
        }
        /**
         * Creating Result.txt file with list of converstions
         */
        FileWriter newFile = null;
        try {
            newFile = new FileWriter("C:\\Users\\Denis.Kozyra\\OneDrive - xcircular.com\\Desktop\\results.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(newFile);
        /**
         * Write all conversitions that user did
         */
        try {
            int size = MyList.size();
            for (int i=0;i<size;i++) {
                String str = MyList.get(i).toString();
                newFile.write(str);
                if(i < size-1) {//This prevent creating a blank like at the end of the file
                    newFile.write("\n");
                }
            }
            newFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * Bonus open file from code
         */
        try {
            String path = "C:\\Users\\Denis.Kozyra\\OneDrive - xcircular.com\\Desktop\\results.txt";
            File file = new File(path);
            if(file.exists()){
                Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +path);
                pro. waitFor();
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /**
         * This is start point of my Code
         * @author Denis Kozyra
         * @version 1.0
         */
        System.out.println("Welcome to currency convertor");
        chooseProgram();
            }

//            @Test (priority = 1)
//            void enterValue() {
//                Main ilstousd = new Main();
//                double imported =
//                double expect =
//
//            }
//
//            @Test (priority = 2)
//            void assertResult(){
//
//            }
//
//            @Test (priority = 3)
//            void contentResult(){
//
//            }


        }




