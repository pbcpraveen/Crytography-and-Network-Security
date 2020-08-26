package Algorithms;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class PlayFairCipher {
    private char playFairMatrix[][] = new char[5][5];
    private String key = new String();

    public PlayFairCipher() {}

    public PlayFairCipher(String key){
        this.key = key;
        getPlayFairMatrix(key);
    }
    public void setKey(String key){
        this.key = key;
        getPlayFairMatrix(key);
    }
    public void getPlayFairMatrix(String key){
        int stringLength = key.length();
        int stringIndex = 0;
        Set<String> visited = new HashSet<String>();
        int filled = 0;
        int i = 0, j = 0;
        char alphabet = 'A';
        while(filled < 25){

            if(stringIndex < stringLength){
                   if(!visited.contains(String.valueOf(key.charAt(stringIndex)))){
                       visited.add(String.valueOf(key.charAt(stringIndex)));
                       this.playFairMatrix[i][j] = key.charAt(stringIndex);
                       j = (j + 1) % 5;
                       if(j==0){
                           i = (i + 1) % 5;
                       }
                       filled++;
                   }
                   stringIndex++;
               }
               else{
                   while((visited.contains(String.valueOf(alphabet)) || alphabet=='J') && alphabet <= 'Z'){
                       alphabet = (char)(alphabet+1);

                   }

                   this.playFairMatrix[i][j] = alphabet;
                   visited.add(String.valueOf(alphabet));
                   j = (j + 1) % 5;
                    if(j==0){
                        i = (i + 1) % 5;
                    }
                   filled++;
                    alphabet = (char)(alphabet+1);
               }
        }
    }

    public Point getIndex(char k){
        Point location = new Point();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(this.playFairMatrix[i][j] == k || (this.playFairMatrix[i][j] == 'I' && k == 'J' )){
                    location.x = i;
                    location.y = j;
                    return location;
                }
            }
        }
        return location;
    }
    public char[] getEncryptionPair(char c1, char c2) {
        Point locationC1 = getIndex(c1);
        Point locationC2 = getIndex(c2);
        char encryptedE1 = this.playFairMatrix[locationC1.x][locationC2.y];
        char encryptedE2 = this.playFairMatrix[locationC2.x][locationC1.y];
        return new char[]{encryptedE1, encryptedE2};
    }
    public String encryptMessage(String message){
        int n = message.length();
        String encryptedMessage  = "";
        if (n%2==1){
            message = message + "x";
            n++;
        }
        for(int i=0; i<n; i+=2){
            char excryptedPair[] = getEncryptionPair(message.charAt(i), message.charAt(i+1));
            encryptedMessage = encryptedMessage + String.valueOf(excryptedPair[0]) + String.valueOf(excryptedPair[1]);
        }
        return encryptedMessage;
    }
    public String decryptMessage(String code){
        int n = code.length();
        String decryptedMessage  = "";
        if (n%2==1){
            code = code + "x";
            n++;
        }
        for(int i=0; i<n; i+=2){
            char decryptedPair[] = getEncryptionPair(code.charAt(i), code.charAt(i+1));
            decryptedMessage = decryptedMessage + String.valueOf(decryptedPair[0]) + String.valueOf(decryptedPair[1]);
        }
        return decryptedMessage;
    }
    public void printPlayFairMatrix(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(this.playFairMatrix[i][j]);
            }
            System.out.print("\n");
        }
    }
}

