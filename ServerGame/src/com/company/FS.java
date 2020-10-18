package com.company;

import java.io.FileReader;
import java.io.IOException;

public class FS {
    private String path = "src/jsons/plants.json";

    public String readJson() {
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
//        System.out.println(fileData);
        return fileData;
    }

}
