package at.gv.brz.training.krachbum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import at.gv.brz.training.krachbum.listener.FileChangeListener;

public class WatchService {

  private List<FileChangeListener> lListeners = new ArrayList<>();

  public void addFileChangeListener(FileChangeListener extFCL) {
    lListeners.add(extFCL);
  }

  public void prozessEventsInBackground() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          new WatchDir().processEvents(lListeners);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          assert false : "IOException thrown";
        }

      }
    }).start();
  }
}
