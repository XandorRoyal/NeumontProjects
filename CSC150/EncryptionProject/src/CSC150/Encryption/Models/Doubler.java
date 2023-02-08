/**
 * @author xmartin
 * @createdOn 2/6/2023 at 11:13 AM
 * @projectName EncryptionProject
 * @packageName CSC150.Encryption.Models;
 */
package CSC150.Encryption.Models;

public class Doubler implements StringEncryptable{
    public String encrypt(String stringToEncrypt){
        return stringToEncrypt+stringToEncrypt;
    }
    public String decrypt(String stringToDecrypt){
        return stringToDecrypt.substring(0,stringToDecrypt.length()/2);
    }
}
