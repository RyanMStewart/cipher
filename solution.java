import java.util.*;

public class Main {
    public static void main(String[] args) {
        String plainText = "hello9world";
        String cipherAlphabet = "bjosxcqukmrhgeynazldwfpvti";
        System.out.println(substitutionCipher(plainText, cipherAlphabet));  // Outputs: ""
        
        plainText = "helloworld";
        cipherAlphabet = "mpgzkeyrsxfwIvjbcnuidhoqat";
        System.out.println(substitutionCipher(plainText, cipherAlphabet));  // Outputs: rkwwjojnwz
    }

    public static String substitutionCipher(String text, String cipherAlphabet) {
        String standardAlphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Character> lookup = new HashMap<>();

        // Check if cipherAlphabet has exactly 26 letters
        // and also check if cipher alphabet has duplicate characters
        Set<Character> charSet = new HashSet<>();
        for (char c : cipherAlphabet.toCharArray()) {
            if (charSet.contains(c)) {
                return "";
            }
            charSet.add(c);
        }
        if (charSet.size() != 26) {
            return "";
        }

        // Create a mapping between the standard alphabet and the cipher alphabet.
        for (int i = 0; i < standardAlphabet.length(); i++) {
            lookup.put(standardAlphabet.charAt(i), cipherAlphabet.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (!lookup.containsKey(c)) { // if the character is not in the lookup table (like a number or special character)
                return "";
            }
            result.append(lookup.get(c));
        }

        return result.toString();
    }
}
