
package org.saintandreas.serket.scpd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.saintandreas.serket.impl.BaseService;
import org.saintandreas.serket.soap.SOAPSerializable;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Element;

public abstract class ConnectionManager
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:ConnectionManager:1";

    public ConnectionManager(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract ConnectionManager.GetProtocolInfoResponse getProtocolInfo(ConnectionManager.GetProtocolInfoRequest input)
        throws IOException, ServletException
    ;

    public abstract ConnectionManager.PrepareForConnectionResponse prepareForConnection(ConnectionManager.PrepareForConnectionRequest input)
        throws IOException, ServletException
    ;

    public abstract ConnectionManager.ConnectionCompleteResponse connectionComplete(ConnectionManager.ConnectionCompleteRequest input)
        throws IOException, ServletException
    ;

    public abstract ConnectionManager.GetCurrentConnectionIDsResponse getCurrentConnectionIDs(ConnectionManager.GetCurrentConnectionIDsRequest input)
        throws IOException, ServletException
    ;

    public abstract ConnectionManager.GetCurrentConnectionInfoResponse getCurrentConnectionInfo(ConnectionManager.GetCurrentConnectionInfoRequest input)
        throws IOException, ServletException
    ;

    public static class ConnectionCompleteRequest
        extends SOAPSerializable
    {

        public int connectionID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ConnectionID".equals(name)) {
                    connectionID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.ConnectionCompleteRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ConnectionCompleteRequest", "u"));
            soapBodyElement.addChildElement("ConnectionID").setTextContent(Integer.toString(connectionID));
            return retVal;
        }

    }

    public static class ConnectionCompleteResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.ConnectionCompleteResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "ConnectionCompleteResponse", "u"));
            return retVal;
        }

    }

    public enum ConnectionStatus {

        OK,
        ContentFormatMismatch,
        InsufficientBandwidth,
        UnreliableChannel,
        Unknown;

    }

    public enum Direction {

        Input,
        Output;

    }

    public static class GetCurrentConnectionIDsRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.GetCurrentConnectionIDsRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentConnectionIDsRequest", "u"));
            return retVal;
        }

    }

    public static class GetCurrentConnectionIDsResponse
        extends SOAPSerializable
    {

        public String connectionIDs;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ConnectionIDs".equals(name)) {
                    connectionIDs = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.GetCurrentConnectionIDsResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentConnectionIDsResponse", "u"));
            soapBodyElement.addChildElement("ConnectionIDs").setTextContent(connectionIDs.toString());
            return retVal;
        }

    }

    public static class GetCurrentConnectionInfoRequest
        extends SOAPSerializable
    {

        public int connectionID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ConnectionID".equals(name)) {
                    connectionID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.GetCurrentConnectionInfoRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentConnectionInfoRequest", "u"));
            soapBodyElement.addChildElement("ConnectionID").setTextContent(Integer.toString(connectionID));
            return retVal;
        }

    }

    public static class GetCurrentConnectionInfoResponse
        extends SOAPSerializable
    {

        public int rcsID;
        public int aVTransportID;
        public String protocolInfo;
        public String peerConnectionManager;
        public int peerConnectionID;
        public org.saintandreas.serket.scpd.ConnectionManager.Direction direction;
        public ConnectionManager.ConnectionStatus status;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RcsID".equals(name)) {
                    rcsID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("AVTransportID".equals(name)) {
                    aVTransportID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("ProtocolInfo".equals(name)) {
                    protocolInfo = e.getTextContent();
                    continue;
                }
                if ("PeerConnectionManager".equals(name)) {
                    peerConnectionManager = e.getTextContent();
                    continue;
                }
                if ("PeerConnectionID".equals(name)) {
                    peerConnectionID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Direction".equals(name)) {
                    direction = org.saintandreas.serket.scpd.ConnectionManager.Direction.valueOf(e.getTextContent());
                    continue;
                }
                if ("Status".equals(name)) {
                    status = ConnectionManager.ConnectionStatus.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.GetCurrentConnectionInfoResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentConnectionInfoResponse", "u"));
            soapBodyElement.addChildElement("RcsID").setTextContent(Integer.toString(rcsID));
            soapBodyElement.addChildElement("AVTransportID").setTextContent(Integer.toString(aVTransportID));
            soapBodyElement.addChildElement("ProtocolInfo").setTextContent(protocolInfo.toString());
            soapBodyElement.addChildElement("PeerConnectionManager").setTextContent(peerConnectionManager.toString());
            soapBodyElement.addChildElement("PeerConnectionID").setTextContent(Integer.toString(peerConnectionID));
            soapBodyElement.addChildElement("Direction").setTextContent(direction.toString());
            soapBodyElement.addChildElement("Status").setTextContent(status.toString());
            return retVal;
        }

    }

    public static class GetProtocolInfoRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.GetProtocolInfoRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetProtocolInfoRequest", "u"));
            return retVal;
        }

    }

    public static class GetProtocolInfoResponse
        extends SOAPSerializable
    {

        public String source;
        public String sink;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("Source".equals(name)) {
                    source = e.getTextContent();
                    continue;
                }
                if ("Sink".equals(name)) {
                    sink = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.GetProtocolInfoResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetProtocolInfoResponse", "u"));
            soapBodyElement.addChildElement("Source").setTextContent(source.toString());
            soapBodyElement.addChildElement("Sink").setTextContent(sink.toString());
            return retVal;
        }

    }

    public static class PrepareForConnectionRequest
        extends SOAPSerializable
    {

        public String remoteProtocolInfo;
        public String peerConnectionManager;
        public int peerConnectionID;
        public ConnectionManager.Direction direction;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RemoteProtocolInfo".equals(name)) {
                    remoteProtocolInfo = e.getTextContent();
                    continue;
                }
                if ("PeerConnectionManager".equals(name)) {
                    peerConnectionManager = e.getTextContent();
                    continue;
                }
                if ("PeerConnectionID".equals(name)) {
                    peerConnectionID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Direction".equals(name)) {
                    direction = ConnectionManager.Direction.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.PrepareForConnectionRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "PrepareForConnectionRequest", "u"));
            soapBodyElement.addChildElement("RemoteProtocolInfo").setTextContent(remoteProtocolInfo.toString());
            soapBodyElement.addChildElement("PeerConnectionManager").setTextContent(peerConnectionManager.toString());
            soapBodyElement.addChildElement("PeerConnectionID").setTextContent(Integer.toString(peerConnectionID));
            soapBodyElement.addChildElement("Direction").setTextContent(direction.toString());
            return retVal;
        }

    }

    public static class PrepareForConnectionResponse
        extends SOAPSerializable
    {

        public int connectionID;
        public int aVTransportID;
        public int rcsID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ConnectionID".equals(name)) {
                    connectionID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("AVTransportID".equals(name)) {
                    aVTransportID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("RcsID".equals(name)) {
                    rcsID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ConnectionManager.PrepareForConnectionResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "PrepareForConnectionResponse", "u"));
            soapBodyElement.addChildElement("ConnectionID").setTextContent(Integer.toString(connectionID));
            soapBodyElement.addChildElement("AVTransportID").setTextContent(Integer.toString(aVTransportID));
            soapBodyElement.addChildElement("RcsID").setTextContent(Integer.toString(rcsID));
            return retVal;
        }

    }

}
