package org.saintandreas.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public interface SocketHandler  {
	public void onConnect(SelectionKey sk) throws IOException;

	public void onWrite(SelectionKey sk) throws IOException;

	public void onRead(SelectionKey sk) throws IOException;

	public void onAccept(SelectionKey sk) throws IOException;

    public void onException(IOException e);
    
    public void onTimeout() throws IOException;
    
    public SocketChannel getSocketChannel();

    public boolean isMaskChanged();
    
    public int getSelectionMask();
    
    public long idleAge();
    
    public long maxIdleAge();

}
