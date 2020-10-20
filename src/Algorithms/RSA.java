package Algorithms;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

    private BigInteger p1, p2, d;
    public BigInteger N, phi, e;
    private int bitlength = 1024;
    private Random r;
    public BigInteger[] message = null;
    public BigInteger[] cipher = null;
    public RSA() {
        generateKey();
    }

    public RSA(BigInteger e, BigInteger d, BigInteger N) {
        this.e = e;
        this.d = d;
        this.N = N;
    }


    public void generatePrimeNumbers(){
        r = new Random();
        p1 = BigInteger.probablePrime(bitlength, r);
        p2 = BigInteger.probablePrime(bitlength, r);
    }
    public void generateKey(){
        this.generatePrimeNumbers();
        this.N = this.p1.multiply(this.p2);
        this.phi = this.p1.subtract(BigInteger.ONE).multiply(this.p2.subtract(BigInteger.ONE));
        this.e = BigInteger.probablePrime(this.bitlength / 2, this.r);
        while (this.phi.gcd(this.e).compareTo(BigInteger.ONE) > 0 && this.e.compareTo(this.phi) < 0) {
            this.e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }
    public String stringToBytes(String s){
        message = new BigInteger[s.length()];
        cipher = new BigInteger[s.length()];

        String byteStream = "";
        int i = 0;
        for (char c : s.toCharArray()) {
            message[i] = new BigInteger(String.valueOf((int) c));
            cipher[i++] = new BigInteger(String.valueOf((int) c));
            String intString = String.format("%08d", Integer.parseInt(Integer.toBinaryString((int) c)));
            byteStream += intString;
        }
        return  byteStream;
    }
    public void encrypt(String message) {
        String c = "";
        cipher = new BigInteger[message.length()];
        for(int i = 0; i<message.length(); i++) {
            cipher[i] = (new BigInteger(String.valueOf((int) message.charAt(i)))).modPow(e, N);
            if(cipher[i].intValue()<0){
                cipher[i] = cipher[i].add(N);
            }
            System.out.print(cipher[i].toString() + " ");
        }
    }

    public void decrypt(BigInteger[] cipher) {

        for(int i = 0; i<cipher.length; i++){
            message[i] = cipher[i].modPow(d, N);
            System.out.print((char)message[i].intValue() + " ");


        }
        System.out.println();
    }
    public BigInteger getP1(){
        return this.p1;
    }
    public BigInteger getP2(){
        return this.p2;
    }
    public BigInteger getKeyInverse(){
        return this.d;
    }


}

