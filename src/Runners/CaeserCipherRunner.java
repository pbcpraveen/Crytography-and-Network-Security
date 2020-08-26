package Runners;

import Algorithms.CaeserCipher;

import java.util.Scanner;

public class CaeserCipherRunner {
    public static void main (String[] args){
        int choice;
        int k;
        String message;
        CaeserCipher caeserCipher = new CaeserCipher();
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
            caeserCipher.setKey(k);
            System.out.println("The encrypted message is:");
            System.out.println(caeserCipher.encryptMessage(message));
        }
        else{
            scanner.nextLine();
            System.out.print("Enter the message to decrypt: ");
            message = scanner.nextLine();
            message = message.toUpperCase();
            int isKey = 0;
            System.out.print("Do you know the key? [0/1]: ");
            isKey = scanner.nextInt();
            if (isKey==0){
                System.out.println("The possible encrypted messages are:");
                System.out.println("KEY \t MESSAGE");
                for(int i=0; i < 26; i++){
                    System.out.println("k=" + i + " \t " + caeserCipher.decryptMessage(message, i));
                }
            }
            else {
                System.out.print("Enter Decryption Key: ");
                k = scanner.nextInt();
                System.out.println("The decrypted message is:");
                System.out.println(caeserCipher.decryptMessage(message, k));
            }
        }
    }
}
