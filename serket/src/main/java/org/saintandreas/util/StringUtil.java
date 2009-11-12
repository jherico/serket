/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

import com.google.common.base.Charsets;

/**
 * @author bdavis@saintandreas.org
 *
 */
public final class StringUtil {
    private StringUtil() {
    }

    /** The empty string: {@value} */
    public static final String EMPTY_STRING = "";

    public static void writeToFile(String value, String file) throws IOException {
        writeToFile(value, file, Charsets.UTF_8);
    }

    public static void writeToFile(String value, String file, Charset charset) throws IOException {
        writeToFile(value, new File(file), charset);
    }

    public static void writeToFile(String value, File file) throws IOException {
        writeToFile(value, file, Charsets.UTF_8);
    }

    public static void writeToFile(String value, File file, Charset charset) throws IOException {
        FileOutputStream mStream = null;
        OutputStreamWriter mOutput = null;
        try {
            mStream = new FileOutputStream(file);
            mOutput = new OutputStreamWriter(mStream, charset);
            mOutput.write(value);
        } finally {
            if (mOutput != null) {
                mOutput.close();
            }
            StreamUtil.safeClose(mStream);
        }
    }

    public static void write(String value, OutputStream stream) throws Exception {
        write(value, stream, null);
    }

    public static void write(String value, OutputStream stream, Charset charset) throws Exception {
        Writer mWriter = null;
        try {
            mWriter = new OutputStreamWriter(stream, charset);
            mWriter.write(value);
        } finally {
            StreamUtil.safeClose(mWriter);
        }
    }

    public static String readFromResource(String resource, Class<?> clazz) throws IOException {
        return readFromResource(resource, Charsets.UTF_8, clazz);
    }

    public static String readFromResource(String resource, Charset charset, Class<?> clazz) throws IOException {
        String mRetVal = null;
        InputStream stream = clazz.getResourceAsStream(resource);
        try {
            mRetVal = read(stream, charset);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return mRetVal;
    }

    public static String readFromResource(String resource) throws IOException {
        return readFromResource(resource, Charsets.UTF_8, StringUtil.class);
    }

    public static String readFromResource(String resource, Charset charset) throws IOException {
        return readFromResource(resource, charset, StringUtil.class);
    }

    public static String readFromFile(String file) throws IOException {
        return readFromFile(file, null);
    }

    public static String readFromFile(String file, Charset charset) throws IOException {
        return readFromFile(new File(file), charset);
    }

    public static String readFromFile(File file) throws IOException {
        return readFromFile(file, null);
    }

    public static String readFromFile(File file, Charset charset) throws IOException {
        FileInputStream mInput = null;
        String mRetVal = null;
        try {
            mInput = new FileInputStream(file);
            mRetVal = read(mInput, charset);
        } finally {
            StreamUtil.safeClose(mInput);
        }
        return mRetVal;
    }

    public static String read(Reader reader) throws IOException {
        if (!(reader instanceof BufferedReader)) {
            reader = new BufferedReader(reader);
        }
        StringBuffer mRetVal = new StringBuffer();
        int mRead = -1;
        char buffer[] = new char[8192];
        while (-1 != (mRead = reader.read(buffer))) {
            mRetVal.append(buffer, 0, mRead);
        }
        return mRetVal.toString();
    }

    public static String read(InputStream stream) throws IOException {
        return read(stream, null);
    }

    public static String read(InputStream stream, Charset charset) throws IOException {
        Reader mReader = new BufferedReader(new InputStreamReader(stream, charset));
        String mRetVal = null;
        try {
            mRetVal = read(mReader);
        } finally {
            try {
                mReader.close();
            } catch (IOException e) {
                // ignore
            }
        }
        return mRetVal;
    }

}