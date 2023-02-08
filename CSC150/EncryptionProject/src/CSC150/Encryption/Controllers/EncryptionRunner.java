/**
 * @author xmartin
 * @createdOn 2/6/2023 at 11:10 AM
 * @projectName EncryptionProject
 * @packageName CSC150.Encryption.Controllers;
 */
package CSC150.Encryption.Controllers;

import CSC150.Encryption.Models.*;

import java.util.ArrayList;
import java.util.List;

public class EncryptionRunner {
    private String encryptionString = "";
    private Doubler d = new Doubler();
    private Cutter c = new Cutter();
    private VowelReplacer vR = new VowelReplacer();
    private PiCipher pi = new PiCipher();

    ArrayList<String> encrypterArray = new ArrayList<>();
    private String determineInput(){
        // Doesn't act on encryption string
        String input = EncryptionUI.getString("What would you like to do?");
        if (input.equals("1") || input.equals("help")){
            return EncryptionUI.help();
        } else if (input.equals("2")){
            encryptionString = EncryptionUI.getString("What do you want to encrypt?2" +
                    "");
            return "Internal String added.";
        } else if (input.equals("3")){
            encryptionString = "";
            return "Internal String removed.";
        } else if (input.equals("4")){
            encrypterArray.add("Doubler");
            return "Doubler Added";
        } else if (input.equals("5")){
            encrypterArray.add("Cutter");
            return "Cutter Added";
        } else if (input.equals("6")){
            encrypterArray.add("VowelReplacer");
            return "Vowel Repalcer Added";
        } else if (input.equals("7")){
            encrypterArray.add("PiEncrypt");
            return "Pi Encryption Added";
        } else if (input.equals("8")){
            if (encrypterArray.size() == 0) return "Nothing in Array";
            encrypterArray.remove(encrypterArray.size()-1);
            return "Removed last index of encryptor array.";
        } else if (input.equals("9")){
            System.out.println("String is: "+encryptionString);
            String s = "";
            for (String encryptor : encrypterArray){
                s += encryptor + " ";
            }
            System.out.println(s);
            return "Displayed.";
        } else if (input.equals("10")){
            for (String encryptor : encrypterArray){
                if (encryptor.equals("Doubler")){
                    encryptionString = d.encrypt(encryptionString);
                } else if (encryptor.equals("Cutter")){
                    encryptionString = c.encrypt(encryptionString);
                } else if (encryptor.equals("VowelReplacer")){
                    encryptionString = vR.encrypt(encryptionString);
                } else if (encryptor.equals("PiEncrypt")){
                    encryptionString = pi.encrypt(encryptionString);
                }
            }
            return "Encrypted";
        } else if (input.equals("11")){
            for (int i = encrypterArray.size()-1; i > -1 && i < encrypterArray.size(); i--){
                String encryptor = encrypterArray.get(i);
                System.out.println(encryptor);
                if (encryptor.equals("Doubler")){
                    encryptionString = d.decrypt(encryptionString);
                } else if (encryptor.equals("Cutter")){
                    encryptionString = c.decrypt(encryptionString);
                } else if (encryptor.equals("VowelReplacer")){
                    encryptionString = vR.decrypt(encryptionString);
                } else if (encryptor.equals("PiEncrypt")){
                    encryptionString = pi.decrypt(encryptionString);
                }
            }
            return "Decrypted";
        }else if (input.equals("12")){
            return "Exit";
        }
        // These act on encryption string


        return "Your input has not been detected as a valid command.";
    }
    public void run(){

        System.out.println(EncryptionUI.help());
        while(true){
            String output = determineInput();
            if (output.equals("Exit")){
                break;
            }
            System.out.println(output);
        }
    }
}
