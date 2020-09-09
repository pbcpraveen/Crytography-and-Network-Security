package Runners;

import Algorithms.HillCipher;
import Algorithms.TranspositionCipher;

import java.util.Scanner;

public class TranpositionCipherRunner {
    public static void main(String[] args){
        int encryptKey[] = new int[10];
        int decipherKey[] = new int[10];
        int n;
        TranspositionCipher transpositionCipher = new TranspositionCipher();
        int choice;
        String k;
        String message;
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Encrypt Message \n2. Decrypt Message \nEnter your choice: ");
        choice = scanner.nextInt();
        if (choice==1) {
            scanner.nextLine();
            System.out.print("Enter the message to encrypt: ");
            message = scanner.nextLine();
            System.out.print("Enter the key size: ");
            n = scanner.nextInt();
            System.out.print("Enter the key: ");
            for(int i=0; i<n; i++){
                    encryptKey[i] = scanner.nextInt();
            }
            transpositionCipher.setKey(encryptKey, n);
            System.out.println("The encrypted message is:");
            System.out.println(transpositionCipher.encryptMessage(message));
        }
        else{
            scanner.nextLine();
            System.out.print("Enter the message to decrypt: ");
            message = scanner.nextLine();
            System.out.print("Enter the key size: ");
            n = scanner.nextInt();
            System.out.print("Enter the key: ");
            for(int i=0; i<n; i++){
                    encryptKey[i] = scanner.nextInt();
            }
            transpositionCipher.setKey(encryptKey, n);
            System.out.println("The decrypted message is:");
            System.out.println(transpositionCipher.decryptMessage(message));
        }

    }
}
