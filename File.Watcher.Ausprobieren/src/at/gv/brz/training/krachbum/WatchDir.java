package at.gv.brz.training.krachbum;

/*
 * Copyright (c) 2008, 2010, Oracle and/or its affiliates. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 
 * - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * - Neither the name of Oracle nor the names of its contributors may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import at.gv.brz.training.krachbum.listener.FileChangeListener;

/**
 * Example to watch a directory (or tree) for changes to files.
 */

public class WatchDir {

  private final WatchService watcher;

  private final Path dir;

  /**
   * Creates a WatchService and registers the given directory
   */
  WatchDir() throws IOException {
    this.watcher = FileSystems.getDefault().newWatchService();
    this.dir = Paths.get("C:/tmp/watchfile");
    this.dir.register(watcher, ENTRY_MODIFY);
  }

  /**
   * Process all events for keys queued to the watcher
   */
  void processEvents(List<FileChangeListener> lListeners) {
    for (;;) {

      // wait for key to be signalled
      WatchKey key;
      try {
        key = watcher.take();
      } catch (InterruptedException x) {
        System.out.println("Interrupted Exception");
        return;
      }

      if (this.dir == null) {
        System.err.println("WatchKey not recognized!!");
        continue;
      }

      for (WatchEvent<?> event : key.pollEvents()) {
        WatchEvent.Kind<?> kind = event.kind();

        // TBD - provide example of how OVERFLOW event is handled
        if (kind == OVERFLOW) {
          continue;
        }

        // Context for directory entry event is the file name of entry
        Path name = (Path) event.context();
        Path child = this.dir.resolve(name);

        // print out event
        if (child.toString().equals("C:\\tmp\\watchfile\\tesi.txt")) {
          for (FileChangeListener l : lListeners) {
            l.fileChangedEvent();
          }
          System.out.format("%s: %s\n", event.kind().name(), child);
        }

      }

    }
  }

}
