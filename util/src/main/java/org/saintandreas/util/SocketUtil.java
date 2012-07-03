package org.saintandreas.util;

import java.io.IOException;
import java.net.Socket;

public class SocketUtil {
  public static void safeClose(Socket socket) {
    if (socket != null) {
      try {
        socket.close();
      } catch (IOException e) {
        
      }
    }
   }
}
