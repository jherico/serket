
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

public abstract class AVTransport
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:AVTransport:1";

    public AVTransport(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract AVTransport.SetAVTransportURIResponse setAVTransportURI(AVTransport.SetAVTransportURIRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.SetNextAVTransportURIResponse setNextAVTransportURI(AVTransport.SetNextAVTransportURIRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.GetMediaInfoResponse getMediaInfo(AVTransport.GetMediaInfoRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.GetTransportInfoResponse getTransportInfo(AVTransport.GetTransportInfoRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.GetPositionInfoResponse getPositionInfo(AVTransport.GetPositionInfoRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.GetDeviceCapabilitiesResponse getDeviceCapabilities(AVTransport.GetDeviceCapabilitiesRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.GetTransportSettingsResponse getTransportSettings(AVTransport.GetTransportSettingsRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.StopResponse stop(AVTransport.StopRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.PlayResponse play(AVTransport.PlayRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.PauseResponse pause(AVTransport.PauseRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.RecordResponse record(AVTransport.RecordRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.SeekResponse seek(AVTransport.SeekRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.NextResponse next(AVTransport.NextRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.PreviousResponse previous(AVTransport.PreviousRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.SetPlayModeResponse setPlayMode(AVTransport.SetPlayModeRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.SetRecordQualityModeResponse setRecordQualityMode(AVTransport.SetRecordQualityModeRequest input)
        throws IOException, ServletException
    ;

    public abstract AVTransport.GetCurrentTransportActionsResponse getCurrentTransportActions(AVTransport.GetCurrentTransportActionsRequest input)
        throws IOException, ServletException
    ;

    public enum CurrentPlayMode {

        NORMAL;

    }

    public static class GetCurrentTransportActionsRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetCurrentTransportActionsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentTransportActionsRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetCurrentTransportActionsResponse
        extends SOAPSerializable
    {

        public String actions;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("Actions".equals(name)) {
                    actions = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetCurrentTransportActionsResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentTransportActionsResponse", "u"));
            soapBodyElement.addChildElement("Actions").setTextContent(actions.toString());
            return retVal;
        }

    }

    public static class GetDeviceCapabilitiesRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetDeviceCapabilitiesRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetDeviceCapabilitiesRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetDeviceCapabilitiesResponse
        extends SOAPSerializable
    {

        public String playMedia;
        public String recMedia;
        public String recQualityModes;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("PlayMedia".equals(name)) {
                    playMedia = e.getTextContent();
                    continue;
                }
                if ("RecMedia".equals(name)) {
                    recMedia = e.getTextContent();
                    continue;
                }
                if ("RecQualityModes".equals(name)) {
                    recQualityModes = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetDeviceCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetDeviceCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("PlayMedia").setTextContent(playMedia.toString());
            soapBodyElement.addChildElement("RecMedia").setTextContent(recMedia.toString());
            soapBodyElement.addChildElement("RecQualityModes").setTextContent(recQualityModes.toString());
            return retVal;
        }

    }

    public static class GetMediaInfoRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetMediaInfoRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMediaInfoRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetMediaInfoResponse
        extends SOAPSerializable
    {

        public int nrTracks;
        public String mediaDuration;
        public String currentURI;
        public String currentURIMetaData;
        public String nextURI;
        public String nextURIMetaData;
        public String playMedium;
        public String recordMedium;
        public String writeStatus;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("NrTracks".equals(name)) {
                    nrTracks = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("MediaDuration".equals(name)) {
                    mediaDuration = e.getTextContent();
                    continue;
                }
                if ("CurrentURI".equals(name)) {
                    currentURI = e.getTextContent();
                    continue;
                }
                if ("CurrentURIMetaData".equals(name)) {
                    currentURIMetaData = e.getTextContent();
                    continue;
                }
                if ("NextURI".equals(name)) {
                    nextURI = e.getTextContent();
                    continue;
                }
                if ("NextURIMetaData".equals(name)) {
                    nextURIMetaData = e.getTextContent();
                    continue;
                }
                if ("PlayMedium".equals(name)) {
                    playMedium = e.getTextContent();
                    continue;
                }
                if ("RecordMedium".equals(name)) {
                    recordMedium = e.getTextContent();
                    continue;
                }
                if ("WriteStatus".equals(name)) {
                    writeStatus = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetMediaInfoResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMediaInfoResponse", "u"));
            soapBodyElement.addChildElement("NrTracks").setTextContent(Integer.toString(nrTracks));
            soapBodyElement.addChildElement("MediaDuration").setTextContent(mediaDuration.toString());
            soapBodyElement.addChildElement("CurrentURI").setTextContent(currentURI.toString());
            soapBodyElement.addChildElement("CurrentURIMetaData").setTextContent(currentURIMetaData.toString());
            soapBodyElement.addChildElement("NextURI").setTextContent(nextURI.toString());
            soapBodyElement.addChildElement("NextURIMetaData").setTextContent(nextURIMetaData.toString());
            soapBodyElement.addChildElement("PlayMedium").setTextContent(playMedium.toString());
            soapBodyElement.addChildElement("RecordMedium").setTextContent(recordMedium.toString());
            soapBodyElement.addChildElement("WriteStatus").setTextContent(writeStatus.toString());
            return retVal;
        }

    }

    public static class GetPositionInfoRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetPositionInfoRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetPositionInfoRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetPositionInfoResponse
        extends SOAPSerializable
    {

        public int track;
        public String trackDuration;
        public String trackMetaData;
        public String trackURI;
        public String relTime;
        public String absTime;
        public int relCount;
        public int absCount;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("Track".equals(name)) {
                    track = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("TrackDuration".equals(name)) {
                    trackDuration = e.getTextContent();
                    continue;
                }
                if ("TrackMetaData".equals(name)) {
                    trackMetaData = e.getTextContent();
                    continue;
                }
                if ("TrackURI".equals(name)) {
                    trackURI = e.getTextContent();
                    continue;
                }
                if ("RelTime".equals(name)) {
                    relTime = e.getTextContent();
                    continue;
                }
                if ("AbsTime".equals(name)) {
                    absTime = e.getTextContent();
                    continue;
                }
                if ("RelCount".equals(name)) {
                    relCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("AbsCount".equals(name)) {
                    absCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetPositionInfoResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetPositionInfoResponse", "u"));
            soapBodyElement.addChildElement("Track").setTextContent(Integer.toString(track));
            soapBodyElement.addChildElement("TrackDuration").setTextContent(trackDuration.toString());
            soapBodyElement.addChildElement("TrackMetaData").setTextContent(trackMetaData.toString());
            soapBodyElement.addChildElement("TrackURI").setTextContent(trackURI.toString());
            soapBodyElement.addChildElement("RelTime").setTextContent(relTime.toString());
            soapBodyElement.addChildElement("AbsTime").setTextContent(absTime.toString());
            soapBodyElement.addChildElement("RelCount").setTextContent(Integer.toString(relCount));
            soapBodyElement.addChildElement("AbsCount").setTextContent(Integer.toString(absCount));
            return retVal;
        }

    }

    public static class GetTransportInfoRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetTransportInfoRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransportInfoRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetTransportInfoResponse
        extends SOAPSerializable
    {

        public AVTransport.TransportState currentTransportState;
        public AVTransport.TransportStatus currentTransportStatus;
        public AVTransport.TransportPlaySpeed currentSpeed;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentTransportState".equals(name)) {
                    currentTransportState = AVTransport.TransportState.valueOf(e.getTextContent());
                    continue;
                }
                if ("CurrentTransportStatus".equals(name)) {
                    currentTransportStatus = AVTransport.TransportStatus.valueOf(e.getTextContent());
                    continue;
                }
                if ("CurrentSpeed".equals(name)) {
                    currentSpeed = AVTransport.TransportPlaySpeed.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetTransportInfoResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransportInfoResponse", "u"));
            soapBodyElement.addChildElement("CurrentTransportState").setTextContent(currentTransportState.toString());
            soapBodyElement.addChildElement("CurrentTransportStatus").setTextContent(currentTransportStatus.toString());
            soapBodyElement.addChildElement("CurrentSpeed").setTextContent(currentSpeed.toString());
            return retVal;
        }

    }

    public static class GetTransportSettingsRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetTransportSettingsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransportSettingsRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetTransportSettingsResponse
        extends SOAPSerializable
    {

        public AVTransport.CurrentPlayMode playMode;
        public String recQualityMode;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("PlayMode".equals(name)) {
                    playMode = AVTransport.CurrentPlayMode.valueOf(e.getTextContent());
                    continue;
                }
                if ("RecQualityMode".equals(name)) {
                    recQualityMode = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.GetTransportSettingsResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransportSettingsResponse", "u"));
            soapBodyElement.addChildElement("PlayMode").setTextContent(playMode.toString());
            soapBodyElement.addChildElement("RecQualityMode").setTextContent(recQualityMode.toString());
            return retVal;
        }

    }

    public static class NextRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.NextRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "NextRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class NextResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.NextResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "NextResponse", "u"));
            return retVal;
        }

    }

    public static class PauseRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.PauseRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "PauseRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class PauseResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.PauseResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "PauseResponse", "u"));
            return retVal;
        }

    }

    public static class PlayRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.AVTransport.TransportPlaySpeed speed;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Speed".equals(name)) {
                    speed = org.saintandreas.serket.scpd.AVTransport.TransportPlaySpeed.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.PlayRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "PlayRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("Speed").setTextContent(speed.toString());
            return retVal;
        }

    }

    public static class PlayResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.PlayResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "PlayResponse", "u"));
            return retVal;
        }

    }

    public static class PreviousRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.PreviousRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "PreviousRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class PreviousResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.PreviousResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "PreviousResponse", "u"));
            return retVal;
        }

    }

    public static class RecordRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.RecordRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "RecordRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class RecordResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.RecordResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "RecordResponse", "u"));
            return retVal;
        }

    }

    public enum SeekMode {

        TRACK_NR;

    }

    public static class SeekRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public AVTransport.SeekMode unit;
        public String target;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Unit".equals(name)) {
                    unit = AVTransport.SeekMode.valueOf(e.getTextContent());
                    continue;
                }
                if ("Target".equals(name)) {
                    target = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SeekRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SeekRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("Unit").setTextContent(unit.toString());
            soapBodyElement.addChildElement("Target").setTextContent(target.toString());
            return retVal;
        }

    }

    public static class SeekResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SeekResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SeekResponse", "u"));
            return retVal;
        }

    }

    public static class SetAVTransportURIRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String currentURI;
        public String currentURIMetaData;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("CurrentURI".equals(name)) {
                    currentURI = e.getTextContent();
                    continue;
                }
                if ("CurrentURIMetaData".equals(name)) {
                    currentURIMetaData = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetAVTransportURIRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetAVTransportURIRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("CurrentURI").setTextContent(currentURI.toString());
            soapBodyElement.addChildElement("CurrentURIMetaData").setTextContent(currentURIMetaData.toString());
            return retVal;
        }

    }

    public static class SetAVTransportURIResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetAVTransportURIResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetAVTransportURIResponse", "u"));
            return retVal;
        }

    }

    public static class SetNextAVTransportURIRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String nextURI;
        public String nextURIMetaData;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("NextURI".equals(name)) {
                    nextURI = e.getTextContent();
                    continue;
                }
                if ("NextURIMetaData".equals(name)) {
                    nextURIMetaData = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetNextAVTransportURIRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetNextAVTransportURIRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("NextURI").setTextContent(nextURI.toString());
            soapBodyElement.addChildElement("NextURIMetaData").setTextContent(nextURIMetaData.toString());
            return retVal;
        }

    }

    public static class SetNextAVTransportURIResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetNextAVTransportURIResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetNextAVTransportURIResponse", "u"));
            return retVal;
        }

    }

    public static class SetPlayModeRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.AVTransport.CurrentPlayMode newPlayMode;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("NewPlayMode".equals(name)) {
                    newPlayMode = org.saintandreas.serket.scpd.AVTransport.CurrentPlayMode.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetPlayModeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetPlayModeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("NewPlayMode").setTextContent(newPlayMode.toString());
            return retVal;
        }

    }

    public static class SetPlayModeResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetPlayModeResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetPlayModeResponse", "u"));
            return retVal;
        }

    }

    public static class SetRecordQualityModeRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String newRecordQualityMode;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("NewRecordQualityMode".equals(name)) {
                    newRecordQualityMode = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetRecordQualityModeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRecordQualityModeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("NewRecordQualityMode").setTextContent(newRecordQualityMode.toString());
            return retVal;
        }

    }

    public static class SetRecordQualityModeResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.SetRecordQualityModeResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRecordQualityModeResponse", "u"));
            return retVal;
        }

    }

    public static class StopRequest
        extends SOAPSerializable
    {

        public int instanceID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.StopRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "StopRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class StopResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport.StopResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "StopResponse", "u"));
            return retVal;
        }

    }

    public enum TransportPlaySpeed {

        //1;

    }

    public enum TransportState {

        STOPPED,
        PLAYING;

    }

    public enum TransportStatus {

        OK,
        ERROR_OCCURRED;

    }

}
