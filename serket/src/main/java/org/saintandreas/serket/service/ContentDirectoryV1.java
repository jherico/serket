/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.service;

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
