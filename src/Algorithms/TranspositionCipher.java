package Algorithms;

public class TranspositionCipher {
    private int[] key, decryptKey;
    int keyLength;
    public TranspositionCipher(){}
    public TranspositionCipher(int[] key, int n){
        this.key = key;
        this.keyLength = n;
        calculateDecryptionKey();
        }
    public void setKey(int[] key, int n){
        this.key= key;
        this.keyLength = n;
        calculateDecryptionKey();
    }
    private void calculateDecryptionKey(){
        this.decryptKey = new int[this.keyLength];
        for(int i=0; i < this.keyLength; i++){
            this.decryptKey[this.key[i] - 1] = i + 1;
        }
        System.out.print(this.decryptKey);
    }
    public String encryptMessage(String message){
        message = message.toUpperCase();
        message = message.replaceAll("\\s", "");
        String encoded = "";
        char[][] rail = new char[message.length()/this.keyLength + 1][this.keyLength];
        int i=0, j=0, messageIndex=0;
        while(messageIndex < message.length()){
            rail[i][j] = message.charAt(messageIndex);
            messageIndex++;
            if(j+1 == this.keyLength)
                i++;
            j = (j + 1) % this.keyLength;
        }
        while(j != 0){
            rail[i][j] = 'X';
            j = (j + 1) % this.keyLength;
        }
        int m = i;
        for(j=0; j<this.keyLength; j++){
            for(i=0; i<m; i++){
                encoded += String.valueOf(rail[i][this.key[j]-1]);
            }
        }
        return encoded;
    }

    public String decryptMessage(String message){
        message = message.toUpperCase();
        message = message.replaceAll("\\s", "");
        String decoded = "";
        char[][] mat = new char[message.length()/this.keyLength + 1][this.keyLength];
        int i=0, j=0, messageIndex=0;
        int rows = message.length()/this.keyLength;
        while(messageIndex < message.length()){
            mat[i][j] = message.charAt(messageIndex);
            messageIndex++;
            if(i+1 == rows)
                j++;
            i = (i + 1) % rows;
        }
        int m = i;
        for(i=0; i<rows; i++){
            for(j=0; j<this.keyLength; j++){
                decoded += String.valueOf(mat[i][this.decryptKey[j]-1]);
            }
        }
        return decoded;
    }
}
