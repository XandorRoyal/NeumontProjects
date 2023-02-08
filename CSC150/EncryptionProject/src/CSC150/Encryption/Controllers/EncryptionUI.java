/**
 * @author xmartin
 * @createdOn 2/7/2023 at 8:32 AM
 * @projectName EncryptionProject
 * @packageName CSC150.Encryption.Controllers;
 */
package CSC150.Encryption.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncryptionUI {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static String getString(String message){
        String input = "";
        System.out.println(message);
        boolean bool = false;
        do{
            try{
                input = bf.readLine();
            }catch(IOException exc){
                System.out.println("Please reinput input. Internal java error occured.");
                bool = true;
            }
        } while (bool);
        return input;
    }
    public static String help(){
        return """
                1 | help: Displays help menu
                2: Enter string to encryption model
                3: Clear string in model
                4: Add doubler to list
                5: Add cutter to list
                6: Add vowel replacer to list
                7: Add pi encrypter to list
                8: Remove latest enrypter from list
                9: Display string and encryption list
                10: Execute encryptor list
                11: Decrypt using encryption list backwards
                12: Exit""";
    }
}
