package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FS {
    private String path = "src/files/oldGames.txt";
    public void setHistory(String name1, String name2, String winner, String grid) {
        String gameHistory = name1 + '\n' + name2 + '\n'+ winner + '\n'  + grid + '\n';
        writeHistory(gameHistory);
    }
    private void writeHistory(String data) {
        String fileData = getHistoryGame();
        try(FileWriter writer = new FileWriter(path, false))
        {
            fileData += data;
            writer.write(fileData);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public String getHistoryGame() {
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

}
