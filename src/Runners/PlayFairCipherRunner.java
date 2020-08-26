package Runners;

import Algorithms.CaeserCipher;
import Algorithms.PlayFairCipher;

import java.util.Scanner;

public class PlayFairCipherRunner {
    public static void main (String[] args){
        int choice;
        String k;
        String message;
        PlayFairCipher playFairCipher = new PlayFairCipher();
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Encrypt Message \n2. Decrypt Message \nEnter your choice: ");
        choice = scanner.nextInt();
        if (choice==1) {
            scanner.nextLine();
            System.out.print("Enter the message to encrypt: ");
            message = scanner.nextLine();
            message = message.toUpperCase();
            System.out.print("Enter Encryption Key: ");
            k = scanner.next();
            playFairCipher.setKey(k);
            playFairCipher.printPlayFairMatrix();
            System.out.println("The encrypted message is:");
            System.out.println(playFairCipher.encryptMessage(message));
        }
        else{
                scanner.nextLine();
                System.out.print("Enter the message to encrypt: ");
                message = scanner.nextLine();
                message = message.toUpperCase();
                System.out.print("Enter Decryption Key: ");
                k = scanner.next();
                playFairCipher.setKey(k);
                System.out.println("The decrypted message is:");
                System.out.println(playFairCipher.decryptMessage(message));
        }
    }
}

