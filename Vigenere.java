import java.util.Scanner;

public class Vigenere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase();

        System.out.print("\nEnter the key: ");
        String key = scanner.nextLine().toUpperCase();

        String ciphertext = vigenereEncrypt(plaintext, key);
        System.out.println("\nYour Encrypted Text is: " + ciphertext);

        String decryptedText = vigenereDecrypt(ciphertext, key);
        System.out.println("\nYour Decrypted Text is: " + decryptedText);

        scanner.close();

        System.out.println("\nCode Executed by Mayank Pahuja");
    }

    public static String vigenereEncrypt(String plaintext, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                int keyShift = key.charAt(keyIndex) - 'A';

                if (Character.isLowerCase(c)) {
                    char encryptedChar = (char) (((c - 'a' + keyShift) % 26) + 'a');
                    encryptedText.append(encryptedChar);
                } else {
                    char encryptedChar = (char) (((c - 'A' + keyShift) % 26) + 'A');
                    encryptedText.append(encryptedChar);
                }

                keyIndex = (keyIndex + 1) % key.length();
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static String vigenereDecrypt(String ciphertext, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyIndex = 0;

        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                int keyShift = key.charAt(keyIndex) - 'A';

                if (Character.isLowerCase(c)) {
                    char decryptedChar = (char) (((c - 'a' - keyShift + 26) % 26) + 'a');
                    decryptedText.append(decryptedChar);
                } else {
                    char decryptedChar = (char) (((c - 'A' - keyShift + 26) % 26) + 'A');
                    decryptedText.append(decryptedChar);
                }

                keyIndex = (keyIndex + 1) % key.length();
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
}
