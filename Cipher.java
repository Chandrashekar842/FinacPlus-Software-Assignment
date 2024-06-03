import java.util.*;

public class Cipher {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the input: ");
            String input = sc.nextLine();
            int rotation = 3;
            String result = specialCipher(input, rotation);
            System.out.println("The caesar ciphered code is: " + result);
        }
    }

    public static String specialCipher(String input, int rotation) {
        StringBuilder caesarCiphered = new StringBuilder();
        for(char c: input.toCharArray()) {
            caesarCiphered.append(rotateChar(c, rotation));
        }

        return runLengthEncoding(caesarCiphered.toString());
    }
    //This function takes the character and returns the character after doing rotation
    private static char rotateChar(char c, int rotation) {
        if(c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A'+ rotation) % 26);
        } else if(c >= 'a' && c <= 'z') {
            return (char) ('A' + (c - 'a' + rotation) % 26);
        }
        return c;
    }
    //This function performs RunLengthEncoding
    private static String runLengthEncoding(String input) {
        StringBuilder encoded = new StringBuilder();
        int count = 1;
        for(int i = 1; i<input.length(); i++) {
            if(input.charAt(i) == input.charAt(i-1)) {
                count++;
            } else {
                encoded.append(input.charAt(i-1));
                if(count > 1) {
                    encoded.append(count);
                }
                count = 1;
            }
        }
        encoded.append(input.charAt(input.length()-1));
        if(count > 1) {
            encoded.append(count);
        }
        return encoded.toString();
    }
}