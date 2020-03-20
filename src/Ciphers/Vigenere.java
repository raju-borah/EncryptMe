package Ciphers;

/**
 *
 * @author Raju
 */
public class Vigenere {
     /*vernem*/
    //encryption in vernem
    public static String vernemEncrpytion(String plain, String key) {
        String cipher = "";
        for (int i = 0; i < plain.length(); i++) {

            int count = (((int) (plain.charAt(i)) - 97) + ((int) (key.charAt(i)) - 97));
            if (count > 26) {
                count = count % 26;
            }

            int newvalue = count + 97;
            cipher = cipher + (char) newvalue;
        }
        return cipher;
    }

    //decryption in vigenere
    public static String vernemDecrpytion(String cipher, String key) {
        String plainText = "";
        for (int i = 0; i < cipher.length(); i++) {

            int count = (((int) (cipher.charAt(i)) - 97) - ((int) (key.charAt(i)) - 97));
            if (count < 0) {
                count = count + 26;
            }
            int newvalue = count + 97;
            plainText = plainText + (char) newvalue;
        }
        return plainText;
    }

}
