package Runners;

import Algorithms.CaeserCipher;
import Algorithms.RailFenceCipher;

import java.util.Scanner;

public class RailFenceCipherRunner {
    public static void main (String[] args){
        int choice;
        int k;
        String message;
        RailFenceCipher railFenceCipher = new RailFenceCipher();
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Encrypt Message \n2. Decrypt Message \nEnter your choice: ");
        choice = scanner.nextInt();
        if (choice==1) {
            scanner.nextLine();
            System.out.print("Enter the message to encrypt: ");
            message = scanner.nextLine();
            message = message.toUpperCase();
            System.out.print("Enter Encryption Key: ");
            k = scanner.nextInt();
            railFenceCipher.setKey(k);
            System.out.println("The encrypted message is:");
            System.out.println(railFenceCipher.encryptMessage(message));
        }
        else{
            scanner.nextLine();
            System.out.print("Enter the message to decrypt: ");
            message = scanner.nextLine();
            System.out.print("Enter Decryption Key: ");
            k = scanner.nextInt();
            railFenceCipher.setKey(k);
            System.out.println("The decrypted message is:");
            System.out.println(railFenceCipher.decryptMessage(message));
        }
    }
}
