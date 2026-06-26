import java.io.*;
import java.util.Scanner;

public class Cryptiva {

    static final int KEY = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== FILE ENCRYPTION / DECRYPTION ==========");
        System.out.println("1. Encrypt File");
        System.out.println("2. Decrypt File");
        System.out.print("Choose option: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter input file name/path: ");
        String inputFile = sc.nextLine();

        System.out.print("Enter output file name/path: ");
        String outputFile = sc.nextLine();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            while ((line = reader.readLine()) != null) {

                String result;

                if (choice == 1) {
                    result = encrypt(line);
                } else if (choice == 2) {
                    result = decrypt(line);
                } else {
                    System.out.println("Invalid Choice!");
                    reader.close();
                    writer.close();
                    return;
                }

                writer.write(result);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("\nOperation Completed Successfully!");
            System.out.println("Output saved to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    public static String encrypt(String text) {

        StringBuilder sb = new StringBuilder();

        for (char ch : text.toCharArray()) {
            sb.append((char)(ch + KEY));
        }

        return sb.toString();
    }

    public static String decrypt(String text) {

        StringBuilder sb = new StringBuilder();

        for (char ch : text.toCharArray()) {
            sb.append((char)(ch - KEY));
        }

        return sb.toString();
    }
}