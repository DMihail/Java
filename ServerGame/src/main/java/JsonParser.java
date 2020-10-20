
import java.io.*;
import java.util.*;
import com.google.gson.*;

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

    public Map<String, Plant> getMapPlantsObj() {
        Map<String,String> map = new HashMap<String,String>();
        Map<String,Plant> plants = new HashMap<String,Plant>();
        Gson g = new Gson();

        JsonElement element = g.fromJson (readJson(), JsonElement.class);
        JsonObject jsonObj = element.getAsJsonObject();
//        Plant plant = g.fromJson(jsonObj.get("tomato"), Plant.class);
        JsonObject name = (JsonObject) jsonObj.get("tomato");
        System.out.println(name);
//        JSONObject obj = new JSONObject(readJson());
//        Iterator iter = obj.keys();
//        while(iter.hasNext()){
//            String key = (String)iter.next();
//            System.out.println(key );
//            JSONObject plantObj = obj.getJSONObject(key);
//            Iterator objIter = plantObj.keys();
//            while (objIter.hasNext()) {
//                String key2 = (String)objIter.next();
//                String value2 = plantObj.getString(key2);
//                map.put(key2, value2);
//                System.out.println(key2 + " " + value2);
//            }
//            Plant plant = new Plant();
//            plant.setPlantData(map.get("name"),  Integer.parseInt(map.get("harvestCost")),
//                    Integer.parseInt(map.get("seedCost")), Integer.parseInt(map.get("speedMaturation")));
//        plants.put(key, plant);
//        }
        return plants;
    }

}
