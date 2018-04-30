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

/**
 *
 * @author a21220528
 */
public class FileManager {

    private final String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }
    
    public FileManager() {
        this("savegame.9cs");
    }

    public void SaveGameDataToFile(GameData gameData) throws IOException {
        FileOutputStream fos = new FileOutputStream(this.fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameData);
            oos.close();
        }

    }

    public GameData GetGameDataFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(this.fileName);
        GameData gameData;
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameData = (GameData) ois.readObject();
            ois.close();
        }
        return gameData;
    }
    
    public boolean checkSavegameFile(){
        return new File(this.fileName).isFile();
    }
}
