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
package org.saintandreas.serket.jetty;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jetty.util.resource.Resource;

public class ClasspathResource extends Resource {

    @Override
    public Resource addPath(String path) throws IOException, MalformedURLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete() throws SecurityException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean exists() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public File getFile() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OutputStream getOutputStream() throws IOException, SecurityException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public URL getURL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isContainedIn(Resource r) throws MalformedURLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDirectory() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public long lastModified() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long length() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String[] list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void release() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean renameTo(Resource dest) throws SecurityException {
        // TODO Auto-generated method stub
        return false;
    }

}
