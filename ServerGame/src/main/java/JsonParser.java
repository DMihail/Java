
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonParser {
    private String path = "src/main/jsons/plants.json";

    private String readJson() {
        String fileData = "";
        try(FileReader reader = new FileReader(path))
        {
            int c;
            while((c=reader.read())!=-1){
                fileData += (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return fileData;
    }

    public Map<String, JsonNode> getMapPlantsObj () {
        Map<String,JsonNode> plants = new  HashMap<String,JsonNode>();
        try {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(readJson());
        for (JsonNode obj: jsonNode) {
            System.out.println(obj.get("name"));
            String name = obj.get("name").asText();
            plants.put(name, obj);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plants;
    }

}