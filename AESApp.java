import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESApp {

    public static SecretKeySpec getKey(String key) throws Exception {
        byte[] keyBytes = key.getBytes("UTF-8");

        if (keyBytes.length != 16 && keyBytes.length != 24 && keyBytes.length != 32) {
            throw new Exception("Key must be 16, 24, or 32 characters long.");
        }

        return new SecretKeySpec(keyBytes, "AES");
    }

    public static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, getKey(key));
        byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, getKey(key));
        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted, "UTF-8");
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {

                System.out.println("\n=== AES Encryption App ===");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (choice == 3) {
                    System.out.println("Goodbye!");
                    break;
                }

                System.out.print("Enter text: ");
                String text = sc.nextLine();

                System.out.print("Enter secret key (16/24/32 chars): ");
                String key = sc.nextLine();

                try {
                    if (choice == 1) {
                        String encrypted = encrypt(text, key);
                        System.out.println("Encrypted: " + encrypted);
                    } else if (choice == 2) {
                        String decrypted = decrypt(text, key);
                        System.out.println("Decrypted: " + decrypted);
                    } else {
                        System.out.println("Invalid option.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}