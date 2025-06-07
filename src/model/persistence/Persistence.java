package model.persistence;

import java.io.IOException;
import java.io.Serializable;

public interface Persistence<E> {
    void openInput(String nombre) throws IOException;

    void openOutput(String nombre) throws IOException;

    void closeOutput() throws IOException;

    void closeInput() throws IOException;

    void write(E objecto) throws IOException;

    E read() throws IOException, ClassNotFoundException;
}