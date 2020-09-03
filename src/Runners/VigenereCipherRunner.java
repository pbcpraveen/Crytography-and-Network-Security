package Runners;

import Algorithms.PlayFairCipher;
import Algorithms.VigenereCipher;

import java.util.Scanner;

public class VigenereCipherRunner {
    public static void main(String[] args){
        int choice;
        String k;
        String message;
        VigenereCipher vigenereCipher = new VigenereCipher();
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Encrypt Message \n2. Decrypt Message \nEnter your choice: ");
        choice = scanner.nextInt();
        if (choice==1) {
            scanner.nextLine();
            System.out.print("Enter the message to encrypt: ");
            message = scanner.nextLine();
            System.out.print("Enter Encryption Key: ");
            k = scanner.next();
            k = k.toUpperCase();
            vigenereCipher.setKey(k);
            System.out.println("The encrypted message is:");
            System.out.println(vigenereCipher.encryptMessage(message));
        }
        else{
            scanner.nextLine();
            System.out.print("Enter the message to decrypt: ");
            message = scanner.nextLine();
            System.out.print("Enter Decryption Key: ");
            k = scanner.next();
            k = k.toUpperCase();
            vigenereCipher.setKey(k);
            System.out.println("The decrypted message is:");
            System.out.println(vigenereCipher.decryptMessage(message));
        }
    }
}
