import java.util.Scanner;

public class InputValidator {
    public static int getValidIndex(Scanner scanner, int max) {
        System.out.print("Enter a valid index (0 to " + (max - 1) + "): ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0 || index >= max) throw new IndexOutOfBoundsException();
            return index;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return getValidIndex(scanner, max);
        }
    }
}
