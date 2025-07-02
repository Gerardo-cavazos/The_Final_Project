import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> activePlayers = FileHandler.loadPlayers("data/active.txt");
        String[] injuredPlayers = new String[10];
        int injuredCount = FileHandler.loadInjuredPlayers("data/injured.txt", injuredPlayers);

        while (true) {
            System.out.println("\nSoccer Team Manager:");
            System.out.println("1. View Active Players");
            System.out.println("2. View Injured Players");
            System.out.println("3. Add Player");
            System.out.println("4. Mark Player as Injured");
            System.out.println("5. Exit and Save");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (activePlayers.isEmpty()) {
                        System.out.println("No active players.");
                    } else {
                        for (int i = 0; i < activePlayers.size(); i++) {
                            System.out.println(i + ": " + activePlayers.get(i));
                        }
                    }
                    break;

                case "2":
                    if (injuredCount == 0) {
                        System.out.println("No injured players.");
                    } else {
                        for (int i = 0; i < injuredCount; i++) {
                            System.out.println(i + ": " + injuredPlayers[i]);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter player name: ");
                    String playerName = scanner.nextLine();
                    activePlayers.add(playerName);
                    System.out.println(playerName + " added to active players.");
                    break;

                case "4":
                    if (injuredCount >= injuredPlayers.length) {
                        System.out.println("Injured player list is full.");
                        break;
                    }
                    if (activePlayers.isEmpty()) {
                        System.out.println("No active players to mark as injured.");
                        break;
                    }
                    int index = InputValidator.getValidIndex(scanner, activePlayers.size());
                    injuredPlayers[injuredCount++] = activePlayers.remove(index);
                    System.out.println("Player marked as injured.");
                    break;

                case "5":
                    FileHandler.savePlayers(activePlayers, "data/active.txt");
                    FileHandler.saveInjuredPlayers(injuredPlayers, injuredCount, "data/injured.txt");
                    System.out.println("Data saved. Exiting program.");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
