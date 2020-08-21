package Algorithms;

public class CaeserCipher {
    private int key;
    public CaeserCipher(){
        this.key = 0;
    }
    public CaeserCipher(int k){
        this.key = k;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String encryptMessage(String message){
        char[] encrptedMessage = new char[message.length()+1];
        for(int i = 0; i < message.length(); i++){
            if((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z')) {
                int current = (int) message.charAt(i);
                current = (((current - 65) + this.key) % 26) + 65;
                encrptedMessage[i] = (char) current;
            }
            else
                encrptedMessage[i] = message.charAt(i);
        }
        encrptedMessage[message.length()] = '\0';
        return new String(encrptedMessage);
    }
    public String decryptMessage(String code, int key){
        char[] decrptedMessage = new char[code.length()+1];
        for(int i = 0; i < code.length(); i++){
            if((code.charAt(i) >= 'A' && code.charAt(i) <= 'Z')) {
                int current = (int) code.charAt(i);
                current = ((current - 65) - key) % 26;
                current = current < 0 ? current + 26 : current;
                current += 65;
                decrptedMessage[i] = (char) current;
            }
            else
                decrptedMessage[i] = code.charAt(i);
        }
        decrptedMessage[code.length()] = '\0';
        return new String(decrptedMessage);
    }
}
