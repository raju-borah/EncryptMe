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
public class Hill {

    /*hill cipher*/
    public static boolean isKeySquare(int x) {
        double sq = Math.sqrt(x);
        return (sq - Math.floor(sq)) == 0;

    }

    public static int[][] hillKeyGeneration(String key) {
        int generated_key[][] = new int[2][2];
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                generated_key[i][j] = (int) key.charAt(index) - 97;
                index++;
            }
        }
        return generated_key;
    }

    public static String hillEncryption(int hillKey[][], String plain) {
        String cipher = "";
        int inner_key[][] = new int[2][2];
        for (int itEncrypt = 0; itEncrypt < plain.length(); itEncrypt += 2) {
            for (int row = 0; row < 2; row++) {
                int value = 0;
                int index_of_plaintext = itEncrypt;

                for (int col = 0; col < 2; col++) {
//                    System.out.println(index_of_plaintext);
                    inner_key[row][col] = hillKey[row][col] * (((int) plain.charAt(index_of_plaintext)) - 97);
                    value = value + inner_key[row][col];
                    index_of_plaintext++;
                }

                cipher = cipher + (char) (value % 26 + 97);
            }
        }

        return cipher;
    }

    public static int[][] adjacentHillKey(int key[][]) {
        int temp = key[0][0];
        key[0][0] = key[1][1];
        key[1][1] = temp;

        key[0][1] = -key[0][1];
        key[1][0] = -key[1][0];

        if (key[0][1] < 0) {
            key[0][1] = key[0][1] + 26;
        }
        if (key[1][0] < 0) {
            key[1][0] = key[1][0] + 26;
        }

        return key;
    }

    public static String hillDecryption(int hillKey[][], String cipher, int deter) {
        String plain = "";
        int decrypt_key[][] = new int[2][2];
        int inversedeter = 0;

        for (int itDecrypt = 0; itDecrypt < cipher.length(); itDecrypt += 2) {
            for (int row = 0; row < 2; row++) {

                int value = 0;
                int index_of_cipher = itDecrypt;
                for (int col = 0; col < 2; col++) {
//                    System.out.print("c:" + (((int) cipher.charAt(index_of_cipher)) - 97) + " ");
                    decrypt_key[row][col] = hillKey[row][col] * (((int) cipher.charAt(index_of_cipher)) - 97);
//                    System.out.println("cipher :" + (int) (hillKey[row][col]));
                    value = value + decrypt_key[row][col];
                    index_of_cipher++;
//                    System.out.println(value);

                }
//                System.out.println("cipher " + ((value / deter) % 26) );
                for (int inverseiterator = 1; inverseiterator > 0; inverseiterator++) {
                    if (((26 * inverseiterator) + 1) % deter == 0) {
                        inversedeter = ((26 * inverseiterator) + 1) / deter;
                        break;
                    }

                }
                value = (value * inversedeter);
                value = (value % 26) + 97;
                plain = plain + (char) (value);
            }
        }
        return plain;

    }

}
