package Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.io.IOException;


@RunWith(PowerMockRunner.class)
@PrepareForTest(MainConvertor.class)

public class TestConvertor{

    @Test
            void enteredValue() throws Exception {
        MainConvertor mainConvertor = new MainConvertor();

         double res = Whitebox.invokeMethod(mainConvertor, "ilsToUsd");
                do {
                    if (mainConvertor.scanner5.hasNextDouble()){
                        mainConvertor.value1 = mainConvertor.scanner5.nextDouble();
                        mainConvertor.isValue=true;
                    }else {
                        System.out.println("Error: Entered amount should be double");
                        mainConvertor.isValue=false;
                        mainConvertor.scanner5.next();
                    }
                } while (! (mainConvertor.isValue));
                System.out.println(mainConvertor.value1);
            }

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
