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
package org.saintandreas.serket.service.av;

import java.io.IOException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * @author bdavis@saintandreas.org
 *
 */
public interface ContentDirectoryV1 {
    public static final String URI = "urn:schemas-upnp-org:service:ContentDirectory:1";

    SOAPMessage getSearchCapabilities() throws SOAPException, IOException;

    SOAPMessage getSortCapabilities() throws SOAPException, IOException;

    SOAPMessage getSystemUpdateId() throws SOAPException, IOException;

    SOAPMessage browse(String objectId, boolean children, String filter, int offset, int count, String sortCriteria) throws SOAPException, IOException;
}
