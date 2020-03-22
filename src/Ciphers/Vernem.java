package Ciphers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raju
 */
public class Vernem {
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
