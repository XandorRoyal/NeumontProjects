/**
 * @author xmartin
 * @createdOn 2/7/2023 at 10:35 AM
 * @projectName ArrayAssignmnet
 * @packageName CSC150.Arrays.Controllers;
 */
package CSC150.Arrays.Controllers;

import java.util.Arrays;
import java.util.Random;

public class ArrayRunner {

    public void run(){
        int[] intArray = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < intArray.length; i++){
            intArray[i] = rnd.nextInt(1,10);
        }
        System.out.println(ArrayMethods.mean(intArray));
        System.out.println(ArrayMethods.minimum(intArray));
        System.out.println(ArrayMethods.maximum(intArray));
        System.out.println(ArrayMethods.mode(intArray));
    }
}
