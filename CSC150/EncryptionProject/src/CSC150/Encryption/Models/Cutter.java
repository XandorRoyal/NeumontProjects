/**
 * @author xmartin
 * @createdOn 2/6/2023 at 11:21 AM
 * @projectName EncryptionProject
 * @packageName CSC150.Encryption.Models;
 */
package CSC150.Encryption.Models;

public class Cutter implements StringEncryptable {
    public String encrypt(String stringToEncrypt){
        int backHalfNum = (int) Math.ceil(stringToEncrypt.length()/(float)2);
        String backHalfString = stringToEncrypt.substring(backHalfNum,stringToEncrypt.length());
        String frontHalfString = stringToEncrypt.substring(0,backHalfNum);
        return backHalfString+frontHalfString;
    }
    public String decrypt(String stringToDecrypt){
        int backHalfNum = (int) Math.floor(stringToDecrypt.length()/2);
        String backHalfString = stringToDecrypt.substring(backHalfNum,stringToDecrypt.length());
        String frontHalfString = stringToDecrypt.substring(0,backHalfNum);
        return backHalfString+frontHalfString;
    }
}
