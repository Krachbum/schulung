package at.gv.brz.training.krachbum;

import at.gv.brz.training.krachbum.listener.FileChangeListener;

public class GetInfoAboutFileChange implements FileChangeListener {

  @Override
  public void fileChangedEvent() {
    System.out.println("it works!");

  }

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    GetInfoAboutFileChange gIAFC = new GetInfoAboutFileChange();

    WatchService ws = new WatchService();
    ws.addFileChangeListener(gIAFC);

    ws.prozessEventsInBackground();

    Thread.sleep(50000000);
  }

}
