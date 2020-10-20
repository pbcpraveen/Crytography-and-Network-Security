package Runners;

import Algorithms.DHKeyExchange;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

class Key {
    BigInteger p, g;
    private Random r;
    public Key(){}
    public void genPrimeAndPrimitiveRoot(){
        this.p = BigInteger.valueOf(new DHKeyExchange().getPrimeNumber());
        this.g = BigInteger.valueOf(new DHKeyExchange(this.p.intValue()).getPr());
    }
    public BigInteger getP() {
        return p;
    }
    public BigInteger getG() {
        return g;
    }
    public BigInteger getFirstMessage(BigInteger firstSecretNumber){
        return this.g.modPow(firstSecretNumber, this.p);
    }
    public BigInteger getSecondMessage(BigInteger secondSecretNumber){
        return this.g.modPow(secondSecretNumber, this.p);
    }
    public BigInteger firstKeyCalc
            (BigInteger secondMessage, BigInteger firstSecretNumber){
        return secondMessage.modPow(firstSecretNumber, this.p);
    }

    public BigInteger secondKeyCalc
            (BigInteger firstMessage, BigInteger secondSecretNumber){
        return firstMessage.modPow(secondSecretNumber, this.p);
    }
}

public class DHKeyExchangeRunner {

    public static String bytesToString(byte[] byteStream)
    {
        String string = "";
        for (byte i : byteStream)
        {
            string += Byte.toString(i);
        }
        return string;
    }
    public static void main(String[]args)throws IOException
    {
        int choice = 0;
        Scanner inp = new Scanner(System.in);
        Key d = new Key();
        String msg1 = "", msg2 = "";
        BigInteger pub1 = BigInteger.valueOf(0),pub2 = BigInteger.valueOf(0);
        while(choice != 5){
            System.out.println("Choose an option:");
            System.out.println("1. Generate prime and it's primitive roots");
            System.out.println("2. Enter Messages");
            System.out.println("3. Display Public keys");
            System.out.println("4. Display Shared Secret Key");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = inp.nextInt();
            switch(choice){
                case 1:
                    d.genPrimeAndPrimitiveRoot();
                    System.out.println("The Prime Number is: " + d.getP());
                    System.out.println("The Primitive Root Number is: " + d.getG());
                    break;

                case 2:
                    System.out.print("Enter first secret message: ");
                    msg1 = inp.next();
                    System.out.print("Enter second secret message: ");
                    msg2 = inp.next();
                    break;


                case 3:
                    pub1 =  d.getFirstMessage(new BigInteger(msg1.getBytes()));
                    System.out.println("The requested Public Key is: " + pub1 );
                    pub2 =  d.getSecondMessage(new BigInteger(msg2.getBytes()));
                    System.out.println("The requested Public Key is:" + pub2 );
                    break;

                case 4:
                    System.out.println("First Shared Key: "+d.firstKeyCalc(pub2, new BigInteger(msg1.getBytes())));
                    System.out.println("Second Shared Key: "+d.secondKeyCalc(pub1, new BigInteger(msg2.getBytes())));
                    break;

                case 5:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


