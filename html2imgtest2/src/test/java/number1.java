import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

public class number1 {

    public static long createRandomNumber(long min, long max) {
        double randomDecimal = Math.random();
        long interval = max - min + 1;
        double realNumber = (randomDecimal * interval) + min;
        double floorNumber = Math.floor(realNumber);
        return Math.round(floorNumber);
    }
     @Test
    protected  void test(){
        //02100  1883794348
         HashSet set =  new HashSet<Long>();
         for (int i = 0; i <20010; i++) {
             long randomNumber = createRandomNumber(100000000, 999999999);
             set.add("021001"+randomNumber);
         }

         Iterator iterator = set.iterator();
         while (iterator.hasNext()) {
             System.out.println(iterator.next());
         }
     }

}
