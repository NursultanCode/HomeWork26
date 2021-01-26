import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JsonReader {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Product[] readProducts(){
        StringBuilder fromFile = new StringBuilder();
        try (
                FileReader fr = new FileReader("src/products.json");
                Scanner scan = new Scanner(fr)
        ) {
            while (scan.hasNextLine()) {
                fromFile.append(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(fromFile.toString(), Product[].class);
    }
}
