import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static ArrayList<String> loadPlayers(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) list.add(line);
        } catch (IOException e) {
            System.out.println("Load error: " + e.getMessage());
        }
        return list;
    }

    public static void savePlayers(ArrayList<String> list, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String name : list) writer.write(name + "\n");
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    public static int loadInjuredPlayers(String fileName, String[] injuredArray) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null && count < injuredArray.length) {
                injuredArray[count++] = line;
            }
        } catch (IOException e) {
            System.out.println("Load injured error: " + e.getMessage());
        }
        return count;
    }

    public static void saveInjuredPlayers(String[] injuredArray, int count, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < count; i++) {
                writer.write(injuredArray[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Save injured error: " + e.getMessage());
        }
    }
}
