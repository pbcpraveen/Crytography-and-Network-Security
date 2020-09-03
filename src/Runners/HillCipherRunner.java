package Runners;

import Algorithms.HillCipher;
import Algorithms.PlayFairCipher;

import java.util.Scanner;

public class HillCipherRunner {
    public static void printMatrix(int a[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("" + a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int encryptKey[][] = new int[10][10];
        int decipherKey[][] = new int[10][10];
        int n;
        HillCipher hillCipher = new HillCipher();
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
            System.out.println("Enter the matrix: ");for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    encryptKey[i][j] = scanner.nextInt();
                }
            }
            hillCipher.setEncryptionKey(encryptKey, n);
            System.out.println("The encrypted message is:");
            System.out.println(hillCipher.encryptMessage(message));
        }
        else{
            scanner.nextLine();
            System.out.print("Enter the message to decrypt: ");
            message = scanner.nextLine();
            System.out.print("Enter the key size: ");
            n = scanner.nextInt();
            System.out.println("Enter the matrix: ");for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    encryptKey[i][j] = scanner.nextInt();
                }
            }
            hillCipher.setEncryptionKey(encryptKey, n);
            System.out.println("The decrypted message is:");
            System.out.println(hillCipher.decryptMessage(message));
        }

    }
}

/*
17 17 5
21 18 21
2 2 19
 */