package jackson;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import game.*;

public class JsonParser {
    private String path = "src/main/resources/jsons/plants.json";

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

    public Map<String, PlantParams> getMapPlantsObj () {
        Map<String,PlantParams> plants = new  HashMap<String,PlantParams>();
        try {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(readJson());
        for (JsonNode obj: jsonNode) {
            PlantParams plant = new PlantParams();
            plant.getPlantParameters(obj.get("name").asText(),
                    obj.get("harvestCost").asInt(), obj.get("seedCost").asInt(),
                    obj.get("speedMaturation").asInt());
            plants.put(obj.get("name").asText(), plant);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plants;
    }

}
