package org.saintandreas.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.LinkedList;

import org.saintandreas.util.Loggable;

public abstract class BufferingSocketHandler extends Loggable implements SocketHandler {
    protected LinkedList<ByteBuffer> outBuffer = new LinkedList<ByteBuffer>();
    protected ByteArrayOutputStream inBuffer = new ByteArrayOutputStream();
    private ByteBuffer readBuffer = ByteBuffer.allocate(8192);
    protected long lastActivityTime = System.currentTimeMillis();
    protected long timeoutValue = Long.MAX_VALUE;
    
    protected int selectionMask = -1;
    protected int desiredMask = -1;

    public final long idleAge() {
        return System.currentTimeMillis() - lastActivityTime;
    }
    
    public final long maxIdleAge() {
        return timeoutValue;
    }
    
    protected abstract Selector getSelector();
    
    @Override
    public boolean isMaskChanged() {
        return desiredMask != selectionMask;
    }

    @Override
    public synchronized int getSelectionMask() {
        if (desiredMask != -1) {
            selectionMask = desiredMask;
            desiredMask = -1;
        }
        return selectionMask;
    }
    
	public void onConnect(SelectionKey sk) throws IOException {
        if (!getSocketChannel().finishConnect()) {
            throw new IOException("failed to complete connection ");
        }
        desiredMask = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
	}

    public void onWrite(SelectionKey sk) throws IOException {
        if (outBuffer.isEmpty()) {
            return;
        }
        ByteBuffer[] out;
        synchronized (outBuffer)  {
            out = outBuffer.toArray(new ByteBuffer[]{});
        }
        @SuppressWarnings("unused")
        long written = getSocketChannel().write(out);
        synchronized (outBuffer)  {
            while (!outBuffer.isEmpty() && 0 == outBuffer.peek().remaining()) {
                outBuffer.removeFirst();
            } 
        }
	}

	public void onRead(SelectionKey sk) throws IOException {
        int read = getSocketChannel().read(readBuffer);
        if (0 != read) {
            lastActivityTime = System.currentTimeMillis();
        }

        if (-1 == read) {
            sk.channel().close();
            onEof();
        } else  if (0 != read) {
            inBuffer.write(readBuffer.array(), 0, read);
            readBuffer.position(0);
        }
	}
	
	protected void onEof() throws IOException {
	    getSocketChannel().close();
    }
	
    protected byte[] getInputBuffer() {
	    return inBuffer.toByteArray();
	}
	
	protected String getInputBufferAsString(Charset charset) {
	    return new String(inBuffer.toByteArray(), charset);
	}

	protected String getInputBufferAsString() {
        return new String(inBuffer.toByteArray());
    }

	public void onAccept(SelectionKey sk) throws IOException {
	    // not implemented
	}
	
    public void write(String out) throws ClosedChannelException {
        write(out.getBytes());
    }

    public void write(byte[] out) throws ClosedChannelException {
	    write(ByteBuffer.wrap(out));
	}

	public void write(ByteBuffer out) throws ClosedChannelException {
        synchronized (outBuffer) {
            outBuffer.add(out);
        }
    }

	public void onTimeout() throws IOException{
	    throw new IOException("Timeout");
	}

	public void onException(IOException e) {
	    getLog().error("Error", e);
	}



}
