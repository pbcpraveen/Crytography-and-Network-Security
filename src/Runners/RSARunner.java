package Runners;

import Algorithms.RSA;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class RSARunner {
    public static void main(String[] args) {

        RSA rsa = new RSA();
        String teststring = "";
        BigInteger[] encrypted;
        Scanner in = new Scanner(System.in);
        int cont=1;
        while(cont!=0)
        {
            System.out.print("1. Generate Key \n2. Encrypt Message\n3. Decrypt Message\n4. Exit\nEnter your choice: ");
            int choice=in.nextInt();
            in.nextLine();
            switch(choice){
                case 1:
                    rsa.generateKey();
                    System.out.print("Public Key: \nN ---> " + rsa.N + "\ne ---> " + rsa.e + "\n");
                    System.out.print("Private Key: \n");
                    System.out.println("P1 ---> " + rsa.getP1());
                    System.out.println("P2 ---> " + rsa.getP2());
                    System.out.println("d ---> " + rsa.getKeyInverse());
                    break;
                case 2:
                    System.out.println("Enter the message String: ");
                    teststring = in.nextLine();
                    System.out.println("Message Byte Stream: "+ rsa.stringToBytes(teststring));
                    System.out.print("Encrypted values are: ");
                    rsa.encrypt(teststring);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter the cipher message values (space separated): ");
                    String cipher = in.nextLine();
                    String [] cipherValues = cipher.split(" ");
                    encrypted = new BigInteger[cipherValues.length];
                    for(int i=0; i<cipherValues.length; i++){
                        encrypted[i] = new BigInteger(cipherValues[i]);
                    }

                    System.out.println("Decrypted text: " );
                    rsa.decrypt(encrypted);
                    break;
                default: break;
            }
            if(choice==4) break;
        }
    }
}


