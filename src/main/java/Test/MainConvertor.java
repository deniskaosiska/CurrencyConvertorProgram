package Test;
import Currency.*;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConvertor {
    /**Variables and List of results
     *
     */
    private static ArrayList MyList = new ArrayList<>();
    static String fromCode, toCode;
    static double amount;
    static double input;
    Scanner scanner5 = new Scanner(System.in);
    static double value1;
    static boolean isValue;

    /** If user choose start over the convertor
     *
     */
    private static void startOver() throws IOException {
        System.out.println("Please choose an option (1/2):");
        System.out.println("1. Dollars to Shekels");
        System.out.println("2. Shekels to Dollars");
        System.out.println("3. Shekels to Euro");
        Scanner scanner1 = new Scanner(System.in);
        int choose = scanner1.nextInt();
        if (choose == 1) {
            ilsToUsd();
        } else if (choose == 2) {
            usdToils();
        }else if(choose == 3){
            ilsToEur();
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }

    /**
     * Method to get API currency
     */
    private static void sendHttpGETRequest() throws IOException {
        String GET_URL = "http://data.fixer.io/api/latest?access_key=3976ca43b78589e6bf1d3342950d930d&base=" + toCode + "&symbols=" +fromCode;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in.close();
            JSONObject obj = new JSONObject(response.toString());
            double exchangeRate = obj.getJSONObject("rates").getDouble(fromCode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate);
            System.out.println();
            System.out.println(amount + fromCode + " = " + amount/exchangeRate + toCode);
        } else {
            System.out.println("GET request failed");
        }
    }

    /** If user choose 1 shekels to dollars
     *
     */

    public static void ilsToUsd() throws IOException {
        System.out.println("Please enter an amount to convert");
//      sendHttpGETRequest();
        Result result = new Result(); //Objected result that hold conversation flow and result
        result.conversionFlowILStoUSD();
        USD usd = new USD();
        MyList.add(result.value);
        MyList.add(usd.conversionFlow());
        input = result.input;
        amount = result.value;
        System.out.println("Start over Y/N?");
        Scanner scanner3 = new Scanner(System.in);
        String overAgain = scanner3.next();
        if (overAgain.equalsIgnoreCase("Y")) {
            startOver();//Go to beginning of program without Welcome
        } else if (overAgain.equalsIgnoreCase("N")) {
             endScreen();//Go to Fourth screen(end screen)
        }
    }

    /**If user choose 2, dollars to shekels
     *
     */
    private static void usdToils() throws IOException {
            System.out.println("Please enter an amount to convert");
//            sendHttpGETRequest();
            Result result = new Result(); //Objected result that hold conversation flow and result
            result.conversionFlowUSDtoILS();
            ILS ils = new ILS();
            MyList.add(result.value);
            MyList.add(ils.conversionFlow());
            System.out.println("Start over Y/N?");
            Scanner scanner3 = new Scanner(System.in);
            String overAgain = scanner3.next();
            if (overAgain.equalsIgnoreCase("Y")) {
                startOver();//Go to beginning of program without Welcome
            } else if (overAgain.equalsIgnoreCase("N")) {
                 endScreen();//Go to Fourth screen(end screen)
            }
        }

    /**If user choose 3, shekels to euro
     *
     */
    private static void ilsToEur() throws IOException {
        System.out.println("Please enter an amount to convert");
//        sendHttpGETRequest();
        Result result = new Result(); //Objected result that hold conversation flow and result
        result.conversionFlowILStoEUR();
        EUR eur = new EUR();
        MyList.add(result.value);
        MyList.add(eur.conversionFlow());
        System.out.println("Start over Y/N?");
        Scanner scanner3 = new Scanner(System.in);
        String overAgain = scanner3.next();
        if (overAgain.equalsIgnoreCase("Y")) {
            startOver();//Go to beginning of program without Welcome
        } else if (overAgain.equalsIgnoreCase("N")) {
            endScreen();//Go to Fourth screen(end screen)
        }
    }

    /**Choosing amount program
     *
     */
    private static void chooseProgram() throws IOException {
        System.out.println("Please choose an option (1/3):");
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
                System.out.println(MyList.get(i)+" "+MyList.get(i=i+1));
        }
        /**
         * Creating Result.txt file with list of conversations
         */
        FileWriter newFile = null;
        try {
            newFile = new FileWriter("C:\\Users\\Denis.Kozyra\\OneDrive - xcircular.com\\Desktop\\results.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(newFile);
        /**
         * Write all conversations that user did
         */
        try {
            int size = MyList.size();
            for (int i=0;i<size;i++) {
                String str = MyList.get(i).toString();
                String str1 = MyList.get(i=i+1).toString();
                newFile.write("Result "+ str +" Conversation flow " + str1);
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


    public static void main(String[] args) throws IOException {
        /**
         * This is start point of my Code
         * @author Denis Kozyra
         * @version 1.0
         */
        System.out.println("Welcome to currency convertor");
        chooseProgram();
            }
        }




