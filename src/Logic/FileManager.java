/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.FileInputStream;
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

    public void SaveGameToFile(Game game) throws IOException {
        try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oout.writeObject(game);
        }
    }

    public Game GetGameFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Game) oin.readObject();
        }
    }
}
