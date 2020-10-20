package Runners;

import Algorithms.SecureHashingAlgorithm1;

import java.util.Scanner;

public class SHA1Runner {
    public static void main(String[] args) {
        SecureHashingAlgorithm1 sha = new SecureHashingAlgorithm1();
        //Getting the word
        System.out.print("Enter the message: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println("Plain Text: " + word);

        //Converting the word to binary
        String binary = sha.convertToBinary(word);
        sha.messLength = binary.length();
        String hashValue = sha.hashString(word, binary);
        System.out.println("Secure hashed value: " + hashValue);
    }

}
