package data;

import java.io.*;
import java.util.*;

public class FileManager {

    public static List<String> readFile(String filename) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File("database/" + filename);
            if (!file.exists()) file.createNewFile();
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) list.add(sc.nextLine());
            sc.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static void writeFile(String filename, String data) {
        try (FileWriter fw = new FileWriter("database/" + filename, true)) {
            fw.write(data + "\n");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
