package model.persistence;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class XMLPersistence implements Persistence<Object> {

    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;
    private FileOutputStream fileOutput;
    private FileInputStream fileInput;

    @Override
    public void openInput(String nombre) throws IOException {
        fileInput = new FileInputStream(nombre);
        xmlDecoder = new XMLDecoder(fileInput);
    }

    @Override
    public void openOutput(String nombre) throws IOException {
        fileOutput = new FileOutputStream(nombre);
        xmlEncoder = new XMLEncoder(fileOutput);
    }

    @Override
    public void closeOutput() throws IOException {
        this.xmlEncoder.close();
    }

    @Override
    public void closeInput() throws IOException {
        this.xmlDecoder.close();
    }

    @Override
    public void write(Object objeto) throws IOException {
        xmlEncoder.writeObject(objeto);

    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        if (xmlDecoder == null)
            return null;

        return (Serializable) xmlDecoder.readObject();
    }

}
