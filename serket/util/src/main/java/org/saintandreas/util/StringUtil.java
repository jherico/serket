/*
 * Copyright (C) 2009 Bradley Austin Davis.
 * 
 * This file is part of serket.
 * 
 * serket is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * serket is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * serket. If not, see <http://www.gnu.org/licenses/>.
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return readFromFile(file, Charsets.UTF_8);
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
        return read(stream, Charsets.UTF_8);
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

    public static String concat(String[] strings) {
        return concat(strings, ',');
    }

    public static String concat(String[] strings, char sep) {
        StringBuffer mRetVal = new StringBuffer();
        if (strings != null) {
            for (String s : strings) {
                if (mRetVal.length() != 0) {
                    mRetVal.append(sep);
                }
                mRetVal.append(s);
            }
        }
        return mRetVal.toString();
    }

    /**
     * parses a line by a regular expression and returns the first hit. If the
     * regular expression doesn't fit, it returns the default value
     * 
     * @param s
     *            the line to be parsed
     * @param regex
     *            the parsing regular expression
     * @param default_value
     *            the value to be returned, if teh regex doesn't apply
     * @return either the parsed result or the default_value
     */
    public static String parseStringByRE(String s, String regex, String default_value) {
        Pattern p = Pattern.compile(regex, Pattern.DOTALL + Pattern.MULTILINE + Pattern.CASE_INSENSITIVE + Pattern.UNIX_LINES);
        Matcher m = p.matcher(s);
        if (m.find()) {
            return m.group(1);
        }
        return default_value;
    }


}
