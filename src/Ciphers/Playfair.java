package Ciphers;


import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raju
 */
public class Playfair {
     /*playfair*/
    //key generation in playfair
    public static String playfairkeyGenerate(String key) {
        String generatedkey = "";
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < key.length(); i++) {
            if (chars.add(key.charAt(i))) {
                generatedkey = generatedkey + key.charAt(i);
            }
        }
        return generatedkey;
    }

    public static String table(String key) {
        for (int i = (int) 'a'; i < (int) 'z'; i++) {
            int flag = 0;
            for (int j = 0; j < key.length(); j++) {
                if (i == (int) key.charAt(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag < 1) {
                key = key + (char) i;
            }
        }
        return key;
    }

    public static char[][] matrix(String value) {
        char table[][] = new char[5][5];
        int index = 0;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                table[i][j] = value.charAt(index);
                index++;
            }
        }
        return table;
    }

    public static String playfairEncryption(String plain, char keytable[][]) {
        String cipher = "";
        int row[] = new int[plain.length()];
        int col[] = new int[plain.length()];
        int in = 0;
//      pair the plaintext
        for (int index = 0; index < plain.length(); index++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if ((plain.charAt(index) == keytable[i][j])) {
                        row[in] = i;
                        col[in] = j;
                        in++;
                    }

                }
            }
        }
        for (int i = 0, j = 1; i < row.length; i += 2, j += 2) {
//            System.out.println(" " + row[i] + col[i]);
            if (row[i] == row[j]) {

                if (col[i] == 4 && col[j] != 4) {
                    cipher = cipher + keytable[row[i]][col[i] - 4] + keytable[row[i]][col[j] + 1];
                }
                if (col[j] == 4 && col[i] != 4) {
                    cipher = cipher + keytable[row[i]][col[i] + 1] + keytable[row[i]][col[j] - 4];
                }
                if (col[i] < 4 && col[j] < 4) {
                    cipher = cipher + keytable[row[i]][col[i] + 1] + keytable[row[i]][col[j] + 1];
                }
                if (col[i] == 4 && col[j] == 4) {
                    cipher = cipher + keytable[row[i]][col[i] - 4] + keytable[row[i]][col[j] - 4];
                }
            } else if (col[i] == col[j]) {
                if (row[i] == 4 && row[j] != 4) {
                    cipher = cipher + keytable[row[i] - 4][col[i]] + keytable[row[j] + 1][col[i]];
                }
                if (row[j] == 4 && row[i] != 4) {
                    cipher = cipher + keytable[row[i] + 1][col[i]] + keytable[row[j] - 4][col[i]];
                }
                if (row[i] < 4 && row[j] < 4) {
                    cipher = cipher + keytable[row[i] + 1][col[i]] + keytable[row[j] + 1][col[i]];
                }
                if (row[i] == 4 && row[j] == 4) {
                    cipher = cipher + keytable[row[i]][col[i] - 4] + keytable[row[i]][col[j] - 4];
                }

            } else {

                int temp = col[i];
                col[i] = col[i + 1];
                col[i + 1] = temp;
                cipher = cipher + keytable[row[i]][col[i]] + keytable[row[j]][col[j]];

            }
        }

        return cipher;
    }

    public static String playfairDecryption(String cipher, char keytable[][]) {
        String plain = "";
        int row[] = new int[cipher.length()];
        int col[] = new int[cipher.length()];
        int in = 0;
//        pair the ciphertext
        for (int index = 0; index < cipher.length(); index++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if ((cipher.charAt(index) == keytable[i][j])) {
                        row[in] = i;
                        col[in] = j;
                        in++;

                    }

                }
            }
        }
        for (int i = 0, j = 1; i < row.length; i += 2, j += 2) {
//            System.out.println(" " + row[i] + col[i]);
            if (row[i] == row[j]) {

                if (col[i] == 0 && col[j] != 4) {
                    plain = plain + keytable[row[i]][col[i] + 4] + keytable[row[i]][col[j] - 1];
                }
                if (col[j] == 0 && col[i] != 4) {
                    plain = plain + keytable[row[i]][col[i] - 1] + keytable[row[i]][col[j] + 4];
                }
                if (col[i] > 0 && col[j] > 0 && col[i] != 0 && col[j] != 0) {
                    plain = plain + keytable[row[i]][col[i] - 1] + keytable[row[i]][col[j] - 1];
                }
                if (col[i] == 0 && col[j] == 0) {
                    plain = plain + keytable[row[i]][col[i] + 4] + keytable[row[i]][col[j] + 4];
                }
            } else if (col[i] == col[j]) {
                if (row[i] == 0 && row[j] != 4) {
                    plain = plain + keytable[row[i] + 4][col[i]] + keytable[row[j] - 1][col[i]];
                }
                if (row[j] == 0 && row[j] != 4) {
                    plain = plain + keytable[row[i] - 1][col[i]] + keytable[row[j] + 4][col[i]];
                }
                if (row[i] > 0 && row[j] > 0) {
                    plain = plain + keytable[row[i] - 1][col[i]] + keytable[row[j] - 1][col[i]];
                }
                if (row[i] == 0 && row[j] == 0) {
                    plain = plain + keytable[row[i] + 4][col[i]] + keytable[row[j] + 4][col[i]];
                }

            } else {

                int temp = col[i];
                col[i] = col[i + 1];
                col[i + 1] = temp;
                plain = plain + keytable[row[i]][col[i]] + keytable[row[j]][col[j]];

            }
        }

        return plain;
    }
 
}
