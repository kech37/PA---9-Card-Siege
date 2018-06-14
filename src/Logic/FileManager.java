/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {
    private final String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }
    
    public FileManager() {
        this("savegame.9cs");
    }

    public void SaveGameDataToFile(Game game) throws IOException {
        FileOutputStream fos = new FileOutputStream(this.fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.close();
        }

    }

    public Game GetGameDataFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(this.fileName);
        Game game;
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            game = (Game) ois.readObject();
            ois.close();
        }
        return game;
    }
    
    public boolean checkSavegameFile(){
        return new File(this.fileName).isFile();
    }
}
