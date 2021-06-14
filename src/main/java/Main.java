import Currency.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //List of results
    private static ArrayList<Double> MyList = new ArrayList<>();

    // If user choose start over the convertor
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
    // If user choose 1 shekels to dollars
    private static void ilsToUsd() {
        System.out.println("Please enter an amount to convert");
        Scanner scanner2 = new Scanner(System.in);
        double input = scanner2.nextDouble();

        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.USD);

        double value = ilsValue.calculate(input);
        System.out.println(value);
        MyList.add(value);
        System.out.println("Start over Y/N?");
        Scanner scanner3 = new Scanner(System.in);
        String overAgain = scanner3.next();
        if (overAgain.equalsIgnoreCase("Y")) {
            startOver();
        } else if (overAgain.equalsIgnoreCase("N")) {
             endScreen();
        }
    }
        //If user choose 2, dollars to shekels
         private static void usdToils() {
            System.out.println("Please enter an amount to convert");
            Scanner scanner5 = new Scanner(System.in);
            double input = scanner5.nextDouble();

            Coin usdValue = CoinsFactory.getCoinInstance(Coins.ILS);
            double value = usdValue.calculate(input);
            System.out.println(value);
            MyList.add(value);
            System.out.println("Start over Y/N?");
            Scanner scanner3 = new Scanner(System.in);
            String overAgain = scanner3.next();
            if (overAgain.equalsIgnoreCase("Y")) {
                startOver();
            } else if (overAgain.equalsIgnoreCase("N")) {
                 endScreen();
            }
        }
        //Choosing amount program
    private static void chooseProgram(){
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
            chooseProgram();

        }
    }

    //If user choose finish the program
    private static void endScreen() {
        System.out.println("Thanks for using our currency convertor");
        for (int i = 0; i < MyList.size(); i++) {
                System.out.println(MyList.get(i));
        }
        FileWriter newFile = null;
        try {
            newFile = new FileWriter("C:\\Users\\Denis.Kozyra\\OneDrive - xcircular.com\\Desktop\\results.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(newFile);
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

    }

    public static void main(String[] args) {
        System.out.println("Welcome to currency convertor");
        chooseProgram();
            }
        }




