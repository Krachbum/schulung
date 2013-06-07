package dataaccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * @author Spch05
 */
public class ObjectDao {

  private static final String FILE = "C:\\tmp\\test\\Mitarbeiter.txt";

  public List<Object> getAllObjects() throws FileNotFoundException, IOException, ClassNotFoundException {

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
      return (List<Object>) ois.readObject();
    }
  }

  public void saveAllObjects(List<Serializable> list) throws IOException {
    if (list == null || list.size() < 1) { throw new IllegalArgumentException(); }
    // try with resources (Java 7)
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
      oos.writeObject(list);
    }

  }

}
