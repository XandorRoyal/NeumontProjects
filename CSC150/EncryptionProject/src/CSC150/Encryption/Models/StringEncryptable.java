/**
 * @author xmartin
 * @createdOn 2/6/2023 at 11:12 AM
 * @projectName EncryptionProject
 * @packageName CSC150.Encryption.Models;
 */
package CSC150.Encryption.Models;

public interface StringEncryptable {
    String encrypt(String stringToEncrypt);
    String decrypt(String stringToDecrypt);
}
