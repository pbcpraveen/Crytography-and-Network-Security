package Algorithms;

public class RailFenceCipher {
    private int key;

    public RailFenceCipher(){}

    public RailFenceCipher(int key){
        this.key = key;
    }

    public void setKey(int key){
        this.key = key;
    }

    public String encryptMessage(String message){
        message = message.toUpperCase();
        message = message.replaceAll("\\s", "");
        String encoded = "";
        char[][] rail = new char[message.length()/this.key + 1][this.key];
        int i=0, j=0, messageIndex=0;
        while(messageIndex < message.length()){
             rail[i][j] = message.charAt(messageIndex);
             messageIndex++;
             if(j+1 == this.key)
                  i++;
             j = (j + 1) % this.key;
        }
        while(j != 0){
          rail[i][j] = 'X';
          j = (j + 1) % this.key;
        }
        int m = i;
        for(j=0; j<this.key; j++){
            for(i=0; i<m; i++){
                encoded += String.valueOf(rail[i][j]);
            }
        }
        return encoded;
    }

    public String decryptMessage(String message){
        message = message.toUpperCase();
        message = message.replaceAll("\\s", "");
        String decoded = "";
        char[][] rail = new char[this.key][message.length()/this.key + 1];
        int i=0, j=0, messageIndex=0;
        int columns= message.length()/this.key;
        while(messageIndex < message.length()){
            rail[i][j] = message.charAt(messageIndex);
            messageIndex++;
            if(j+1 == columns)
                i++;
            j = (j + 1) % columns;
        }
        int m = i;
        for(j=0; j<columns; j++){
            for(i=0; i<m; i++){
                decoded += String.valueOf(rail[i][j]);
            }
        }
        return decoded;
    }
}
