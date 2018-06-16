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

    public static final String folder = "savegames/";
    public static final String extension = ".9cs";
    private final String fileName;

    public FileManager(String fileName) {
        this.fileName = folder + fileName;
    }

    public FileManager() {
        this("savegame");
    }

    public void SaveGameDataToFile(Game game) throws IOException {
        //new File(folder).mkdir();
        FileOutputStream fos = new FileOutputStream(this.fileName + extension);
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

    public boolean checkSavegameFile() {
        File file = new File(folder);
        if (!file.exists()) {
            file.mkdir();
        }
        if (file.listFiles().length > 0) {
            return true;
        }
        return false;
    }
}
