package Runners;

import Algorithms.DataEncryptionStandard;

import java.util.Scanner;

public class DESRunner {
    public static void main(String args[]) {
        DataEncryptionStandard des = new DataEncryptionStandard();
        Scanner in = new Scanner(System.in);
        String key;
        while(true){
            des.printMenu();
            int option = in.nextInt();
            in.nextLine();
            if(option==2){
                System.out.println("Enter the message to be decoded: ");
                String str = in.nextLine();
                int inputBits[] = new int[64];
                for(int i=0 ; i < 16 ; i++) {
                    String s = Integer.toBinaryString(Integer.parseInt(str.charAt(i) + "", 16));
                    while(s.length() < 4) {
                        s = "0" + s;
                    }
                    for(int j=0 ; j < 4 ; j++) {
                        inputBits[(4*i)+j] = Integer.parseInt(s.charAt(j) + "");
                    }
                }

                System.out.println("Enter the key: ");
                key = in.nextLine();
                String keyhex = des.ASCIItoHEX(key);
                int keyBits[] = new int[64];
                for(int i=0 ; i < 16 ; i++) {
                    String s = Integer.toBinaryString(Integer.parseInt(keyhex.charAt(i) + "", 16));
                    while(s.length() < 4) {
                        s = "0" + s;
                    }
                    for(int j=0 ; j < 4 ; j++) {
                        keyBits[(4*i)+j] = Integer.parseInt(s.charAt(j) + "");
                    }
                }
                String pthex = des.permute(inputBits, keyBits, true);

                System.out.println("Plaintext: "+ des.hexToASCII(pthex));
            }
            else if(option==1){
                System.out.println("Enter the the message to be enoded: ");
                String str = in.nextLine();
                String strhex = des.ASCIItoHEX(str);
                int inputBits[] = new int[64];
                for(int i=0 ; i < 16 ; i++) {
                    String s = Integer.toBinaryString(Integer.parseInt(strhex.charAt(i) + "", 16));
                    while(s.length() < 4) {
                        s = "0" + s;
                    }
                    for(int j=0 ; j < 4 ; j++) {
                        inputBits[(4*i)+j] = Integer.parseInt(s.charAt(j) + "");
                    }
                }

                System.out.println("Enter the key: ");
                key = in.nextLine();
                String keyhex = des.ASCIItoHEX(str);
                int keyBits[] = new int[64];
                for(int i=0 ; i < 16 ; i++) {
                    String s = Integer.toBinaryString(Integer.parseInt(keyhex.charAt(i) + "", 16));
                    while(s.length() < 4) {
                        s = "0" + s;
                    }
                    for(int j=0 ; j < 4 ; j++) {
                        keyBits[(4*i)+j] = Integer.parseInt(s.charAt(j) + "");
                    }
                }
                des.permute(inputBits, keyBits, false);
            }
            else if(option==3){
                break;
            }
            else{
                System.out.println("Error. Wrong option");
            }
        }
        in.close();
    }
}
