package Algorithms;

import java.security.PrivateKey;
import java.util.HashSet;

public class HillCipher {
    private int[][] encryptionKey = new int[100][100];
    public int[][] decryptionKey = new int[100][100];
    private int N;
    private int[] inverse = {-1, 1, -1, 9, -1,
                            21, -1, 15, -1, 15,
                            -1, 3, -1, 19, -1,
                            7, -1, 23, -1, 11,
                            -1, 5, -1, 17, -1, 25};
    public HillCipher(){

    }
    public HillCipher(int key[][], int n){
        this.encryptionKey = key;
        this.N = n;
        setDecryptionKey();
    }

    public void setEncryptionKey(int key[][], int n){
        this.encryptionKey = key;
        this.N = n;
        setDecryptionKey();
    }
    public void setDecryptionKey(){
        inverse();
    }
    private void getCofactor(int A[][], int temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (row != p && col != q)
                {
                    temp[i][j++] = A[row][col];
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public int determinant(int A[][], int n)
    {
        int D = 0;
        if (n == 1)
            return A[0][0];
        int [][]temp = new int[N][N];
        int sign = 1;
        for (int f = 0; f < n; f++)
        {
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }

        return D;
    }
    public void adjoint(int A[][],int [][]adj)
    {
        if (N == 1)
        {
            adj[0][0] = 1;
            return;
        }
        int sign = 1;
        int [][]temp = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                getCofactor(A, temp, i, j, N);
                sign = ((i + j) % 2 == 0)? 1: -1;
                adj[j][i] = (sign)*(determinant(temp, N-1));
            }
        }
    }
    public boolean inverse()
    {
        int det = determinant(this.encryptionKey, N);
        det = this.inverse[det%26 >= 0 ? det%26 : det%26 + 26 ];
        System.out.println(det);
        if (det==-1)
        {
            System.out.print("can't find its inverse");
            return false;
        }
        int [][]adj = new int[N][N];
        adjoint(this.encryptionKey, adj);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                this.decryptionKey[i][j] = (adj[i][j] * det) % 26 >= 0 ?
                        (adj[i][j] * det) % 26 : (adj[i][j] * det) % 26 +26;
        return true;
    }
    private int getCharacterIndex(char c){
        return ((int) c) - 65;
    }
    private char getCharacter(int n){
        return ((char) (n + 65));
    }
    public String encodeChunck(String msg){
        int[] message = new int[this.N];
        for(int i=0; i<this.N; i++){
            message[i] = getCharacterIndex(msg.charAt(i));
        }
        int[] encoded = new int[this.N];
        for(int i=0; i<this.N; i++){
            int s = 0;
            for(int j=0; j<this.N; j++){
                s = s + message[j] * this.encryptionKey[j][i];
            }
            s = s%26 >= 0? s%26: s%26 + 26;
            encoded[i] = s;
        }
        String encodedChunck = "";
        for(int i=0; i<this.N; i++){
            encodedChunck += String.valueOf(getCharacter(encoded[i]));
        }
        return encodedChunck;
    }
    public String decodeChunck(String msg){
        int[] message = new int[this.N];
        for(int i=0; i<this.N; i++){
            message[i] = getCharacterIndex(msg.charAt(i));
        }
        int[] decoded = new int[this.N];
        for(int i=0; i<this.N; i++){
            int s = 0;
            for(int j=0; j<this.N; j++){
                s = s + message[j] * this.decryptionKey[j][i];
            }
            s = s%26 >= 0? s%26: s%26 + 26;
            decoded[i] = s;
        }
        String decodedChunck = "";
        for(int i=0; i<this.N; i++){
            decodedChunck += String.valueOf(getCharacter(decoded[i]));
        }
        return decodedChunck;
    }
    public String encryptMessage(String message){
        message = message.toUpperCase();
        message = message.replaceAll("\\s", "");
        if(message.length()%this.N !=0){
            String extra = "";
            int k = this.N - message.length()%this.N;
            for(int i=0; i<k; i++) extra += "X";
            message += extra;
        }
        String cipherText = "";
        for(int i=0; i<message.length(); i+=this.N){
            cipherText += this.encodeChunck(message.substring(i, i+this.N));
        }
        return cipherText;
    }
    public String decryptMessage(String message){
        message = message.toUpperCase();
        if(message.length()%this.N !=0){
            String extra = "";
            for(int i=0; i<message.length()%this.N; i++) extra += "X";
            message += extra;
        }
        String plainText = "";
        for(int i=0; i<message.length(); i+=this.N){
            plainText += this.decodeChunck(message.substring(i, i+this.N));
        }
        return plainText;
    }
}
