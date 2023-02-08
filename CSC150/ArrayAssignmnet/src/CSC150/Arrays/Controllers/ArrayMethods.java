/**
 * @author xmartin
 * @createdOn 2/7/2023 at 10:38 AM
 * @projectName ArrayAssignmnet
 * @packageName CSC150.Arrays.Controllers;
 */
package CSC150.Arrays.Controllers;

import java.util.HashMap;
import java.util.Map;

public class ArrayMethods {
    public static float mean(int[] intArray){
        int total = 0;
        for(int num : intArray){
            total+=num;
        }
        return (float)total/intArray.length;
    }

    public static float minimum(int[] intArray){
        int min = Integer.MAX_VALUE;
        for (int num : intArray){
            if (num < min) {
                min = num;
            }
        }
        return (float)min;
    }

    public static float maximum(int[] intArray){
        int max = Integer.MIN_VALUE;
        for (int num: intArray){
            if (num > max){
                max = num;
            }
        }
        return (float)max;
    }

    public static float mode(int[] intArray){
        HashMap<String, Integer> map = new HashMap<>();
        for(int num : intArray){
            int count = map.get(String.valueOf(num)) == null ? 0 : map.get(String.valueOf(num));
            map.put(String.valueOf(num),count+1);
        }
        int max =  Integer.MIN_VALUE;
        String val = "";
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue() > max) {max = entry.getValue(); val = entry.getKey();}
        }
        return Float.parseFloat(val);
    }
}
