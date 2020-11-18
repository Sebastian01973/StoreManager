package persistence;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonFileManager {
    public ArrayList<Object[]> readFile(String pathFile){
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            JsonArray root = (JsonArray) Jsoner.deserialize(new FileReader(pathFile));
            for (int i = 0; i < 20; i++) {
                JsonObject obj1 = (JsonObject) root.get(i);
                String name = obj1.getString("Name");
                String address = obj1.getString("Adress");
                list.add(new Object[]{name,address});
            }
        } catch (DeserializationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
