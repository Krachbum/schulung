package dataaccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Spch05
 */
public class MitarbeiterDao {

  private static final String FILE = "C:\\tmp\\Mitarbeiter.txt";

  public Map<String, List<Object>> getAllObjects() throws FileNotFoundException, IOException, ClassNotFoundException {

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
      Map<String, List<Object>> map = new HashMap<>();
      map.put("projekte", (List<Object>) ois.readObject());
      map.put("mitarbeiter", (List<Object>) ois.readObject());
      return map;
    }
  }

  public void saveAllObjects(List<Serializable> projektlist, List<Serializable> mitarbeiterlist) throws IOException {
    if ((projektlist == null || projektlist.size() < 1) && (mitarbeiterlist == null || mitarbeiterlist.size() < 1)) { throw new IllegalArgumentException(); }
    // try with resources (Java 7)
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
      oos.writeObject(projektlist);
      oos.writeObject(mitarbeiterlist);
    }

  }

}
