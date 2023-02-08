/**
 * @author xmartin
 * @createdOn 2/6/2023 at 11:58 AM
 * @projectName EncryptionProject
 * @packageName CSC150.Encryption.Models;
 */
package CSC150.Encryption.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class VowelReplacer implements StringEncryptable{
    char[] vowels = {'a','e','i','o','u'};
    public String encrypt(String stringToEncrypt){
        ArrayList<String> recombinedWords = new ArrayList<>();
        String[] words = stringToEncrypt.split(" ");
        for(String word : words) {
            ArrayList<Character> newCharacters = new ArrayList<>();
            for (char c : word.toCharArray()) {
                boolean allAdd = false;
                for (int i = 0; i < vowels.length; i++) {
                    char v = vowels[i];
                    if (c == v) {
                        allAdd = true;
                        if (i == vowels.length - 1) {
                            newCharacters.add(vowels[0]);
                            break;
                        }
                        newCharacters.add(vowels[i + 1]);
                    }
                }
                if (allAdd) continue;
                newCharacters.add(c);
            }
            recombinedWords.add(newCharacters.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));
        }
        String s = "";
        for (String word : recombinedWords){
            s += word+" ";
        }
        return s.trim();
    }
    public String decrypt(String stringToDecrypt) {
        ArrayList<String> recombinedWords = new ArrayList<>();
        String[] words = stringToDecrypt.split(" ");
        for(String word : words) {
            ArrayList<Character> newCharacters = new ArrayList<>();
            for (char c : word.toCharArray()) {
                boolean allAdd = false;
                for (int i = 0; i < vowels.length; i++) {
                    char v = vowels[i];
                    if (c == v) {
                        allAdd = true;
                        if (i == 0) {
                            newCharacters.add(vowels[vowels.length - 1]);
                            break;
                        }
                        newCharacters.add(vowels[i - 1]);
                    }
                }
                if (allAdd) continue;
                newCharacters.add(c);
            }
            recombinedWords.add(newCharacters.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));
        }
        String s = "";
        for (String word : recombinedWords){
            s += word+" ";
        }
        return s.trim();
    }
}
