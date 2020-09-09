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
        int r = this.key, len = message.length();
        int row = 0, col = 0;
        char mat[][] = new char[r][len];
        boolean dir = false;
        String encoded = "";

        for(int i = 0;i < r;i++)
            for(int j = 0;j < len;j++)
                mat[i][j] = '\0';

        for(int i = 0;i < len;i++) {
            if(row == 0 || row == this.key - 1)
                dir = !dir;
            mat[row][col] = message.charAt(i);
            col += 1;

            if(dir)
                row++;
            else
                row--;
        }

        for(int i = 0;i < r;i++) {
            for(int j = 0;j < len;j++){
                if(mat[i][j] != '\0')
                    encoded += mat[i][j];
            }
        }
        return encoded;
    }

    public String decryptMessage(String message){
        message = message.toUpperCase();
        message = message.replaceAll("\\s", "");
        int r = this.key, len = message.length();
        int row = 0, col = 0;
        boolean dir = false;
        char mat[][] = new char[r][len];
        String decoded = "";

        for(int i = 0;i < r;i++)
            for(int j = 0;j < len;j++)
                mat[i][j] = '\0';

        for(int i = 0;i < len;i++) {
            if(row == 0)
                dir = true;
            if(row == this.key - 1)
                dir = false;

            mat[row][col] = '*';
            col++;

            if(dir)
                row++;
            else
                row--;
        }

        int index = 0;
        for(int i = 0;i < this.key;i++) {
            for(int j = 0;j < len;j++) {
                if(mat[i][j] == '*' && index < len) {
                    mat[i][j] = message.charAt(index);
                    index++;
                }
            }
        }

        row = 0;
        col = 0;
        for(int i = 0;i < len;i++) {
            if(row == 0) dir = true;
            if(row == this.key - 1) dir = false;

            if(mat[row][col] != '*') {
                decoded += mat[row][col];
                col++;
            }
            if(dir)
                row++;
            else
                row--;
        }
        return decoded;
    }
}
