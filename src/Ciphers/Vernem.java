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
        /*vigenere*/
    //key generation in vigenere
    public static String vigenerekeyGenerate(String k, int size) {
        for (int i = 0; i < size; i++) {
            k = k + k.charAt(i);
            if (k.length() == size) {
                break;
            }
        }
        return k;
    }

    //encryption in vigenere
    //Ei = (Pi + Ki) mod 26
    public static String vigenereEncrpytion(String plain, String key) {
        String cipher = "";
        for (int i = 0; i < plain.length(); i++) {

            int count = (((int) (plain.charAt(i)) - 97) + ((int) (key.charAt(i)) - 97)) % 26;
            int newvalue = count + 97;
            cipher = cipher + (char) newvalue;
        }
        return cipher;
    }

    //decryption in vigenere
    //    Ei = (Pi - Ki) mod 26  
    public static String vigenereDecrpytion(String cipher, String key) {
        String plainText = "";
        for (int i = 0; i < cipher.length(); i++) {

            int count = (((int) (cipher.charAt(i)) - 97) - ((int) (key.charAt(i)) - 97)) % 26;
            if (count < 0) {
                count = count + 26;
            }
            int newvalue = count + 97;
            plainText = plainText + (char) newvalue;
        }
        return plainText;
    }
    

}
