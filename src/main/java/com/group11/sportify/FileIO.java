package com.group11.sportify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
    public Object importBinary(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(fileName);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        Object object = objectStream.readObject();
        objectStream.close();
        return object;
    }

    public void exportBinary(String fileName, Object object) throws FileNotFoundException, IOException {
        FileOutputStream fileStream = new FileOutputStream(fileName);
        ObjectOutputStream  objectStream = new ObjectOutputStream(fileStream);
        objectStream.writeObject(object);
        objectStream.flush();
        objectStream.close();
    }
}
