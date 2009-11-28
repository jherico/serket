
package org.saintandreas.serket.scpd;

import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.saintandreas.serket.impl.BaseService;
import org.saintandreas.serket.soap.SOAPSerializable;
import org.w3c.dom.Element;

public abstract class AVTransport2
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:AVTransport:2";

    public AVTransport2(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract AVTransport2 .SetAVTransportURIResponse setAVTransportURI(AVTransport2 .SetAVTransportURIRequest input);

    public abstract AVTransport2 .SetNextAVTransportURIResponse setNextAVTransportURI(AVTransport2 .SetNextAVTransportURIRequest input);

    public abstract AVTransport2 .GetMediaInfoResponse getMediaInfo(AVTransport2 .GetMediaInfoRequest input);

    public abstract AVTransport2 .GetMediaInfo_ExtResponse getMediaInfo_Ext(AVTransport2 .GetMediaInfo_ExtRequest input);

    public abstract AVTransport2 .GetTransportInfoResponse getTransportInfo(AVTransport2 .GetTransportInfoRequest input);

    public abstract AVTransport2 .GetPositionInfoResponse getPositionInfo(AVTransport2 .GetPositionInfoRequest input);

    public abstract AVTransport2 .GetDeviceCapabilitiesResponse getDeviceCapabilities(AVTransport2 .GetDeviceCapabilitiesRequest input);

    public abstract AVTransport2 .GetTransportSettingsResponse getTransportSettings(AVTransport2 .GetTransportSettingsRequest input);

    public abstract AVTransport2 .StopResponse stop(AVTransport2 .StopRequest input);

    public abstract AVTransport2 .PlayResponse play(AVTransport2 .PlayRequest input);

    public abstract AVTransport2 .PauseResponse pause(AVTransport2 .PauseRequest input);

    public abstract AVTransport2 .RecordResponse record(AVTransport2 .RecordRequest input);

    public abstract AVTransport2 .SeekResponse seek(AVTransport2 .SeekRequest input);

    public abstract AVTransport2 .NextResponse next(AVTransport2 .NextRequest input);

    public abstract AVTransport2 .PreviousResponse previous(AVTransport2 .PreviousRequest input);

    public abstract AVTransport2 .SetPlayModeResponse setPlayMode(AVTransport2 .SetPlayModeRequest input);

    public abstract AVTransport2 .SetRecordQualityModeResponse setRecordQualityMode(AVTransport2 .SetRecordQualityModeRequest input);

    public abstract AVTransport2 .GetCurrentTransportActionsResponse getCurrentTransportActions(AVTransport2 .GetCurrentTransportActionsRequest input);

    public abstract AVTransport2 .GetDRMStateResponse getDRMState(AVTransport2 .GetDRMStateRequest input);

    public abstract AVTransport2 .GetStateVariablesResponse getStateVariables(AVTransport2 .GetStateVariablesRequest input);

    public abstract AVTransport2 .SetStateVariablesResponse setStateVariables(AVTransport2 .SetStateVariablesRequest input);

    public enum CurrentMediaCategory {

        NO_MEDIA,
        TRACK_AWARE,
        TRACK_UNAWARE;

    }

    public enum CurrentPlayMode {

        NORMAL;

    }

    public enum DRMState {

        OK;

    }

    public static class GetCurrentTransportActionsRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetCurrentTransportActionsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentTransportActionsRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetCurrentTransportActionsResponse
        extends SOAPSerializable
    {

        public String actions;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("actions".equals(name)) {
                    actions = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetCurrentTransportActionsResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetCurrentTransportActionsResponse", "u"));
            soapBodyElement.addChildElement("Actions").setTextContent(actions.toString());
            return retVal;
        }

    }

    public static class GetDRMStateRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetDRMStateRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetDRMStateRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetDRMStateResponse
        extends SOAPSerializable
    {

        public AVTransport2 .DRMState currentDRMState;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentDRMState".equals(name)) {
                    currentDRMState = AVTransport2 .DRMState.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetDRMStateResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetDRMStateResponse", "u"));
            soapBodyElement.addChildElement("CurrentDRMState").setTextContent(currentDRMState.toString());
            return retVal;
        }

    }

    public static class GetDeviceCapabilitiesRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetDeviceCapabilitiesRequest.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("playMedia".equals(name)) {
                    playMedia = e.getTextContent();
                    continue;
                }
                if ("recMedia".equals(name)) {
                    recMedia = e.getTextContent();
                    continue;
                }
                if ("recQualityModes".equals(name)) {
                    recQualityModes = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetDeviceCapabilitiesResponse.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetMediaInfoRequest.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("nrTracks".equals(name)) {
                    nrTracks = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("mediaDuration".equals(name)) {
                    mediaDuration = e.getTextContent();
                    continue;
                }
                if ("currentURI".equals(name)) {
                    currentURI = e.getTextContent();
                    continue;
                }
                if ("currentURIMetaData".equals(name)) {
                    currentURIMetaData = e.getTextContent();
                    continue;
                }
                if ("nextURI".equals(name)) {
                    nextURI = e.getTextContent();
                    continue;
                }
                if ("nextURIMetaData".equals(name)) {
                    nextURIMetaData = e.getTextContent();
                    continue;
                }
                if ("playMedium".equals(name)) {
                    playMedium = e.getTextContent();
                    continue;
                }
                if ("recordMedium".equals(name)) {
                    recordMedium = e.getTextContent();
                    continue;
                }
                if ("writeStatus".equals(name)) {
                    writeStatus = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetMediaInfoResponse.createMessage();
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

    public static class GetMediaInfo_ExtRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetMediaInfo_ExtRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMediaInfo_ExtRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetMediaInfo_ExtResponse
        extends SOAPSerializable
    {

        public AVTransport2 .CurrentMediaCategory currentType;
        public int nrTracks;
        public String mediaDuration;
        public String currentURI;
        public String currentURIMetaData;
        public String nextURI;
        public String nextURIMetaData;
        public String playMedium;
        public String recordMedium;
        public String writeStatus;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentType".equals(name)) {
                    currentType = AVTransport2 .CurrentMediaCategory.valueOf(e.getTextContent());
                    continue;
                }
                if ("nrTracks".equals(name)) {
                    nrTracks = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("mediaDuration".equals(name)) {
                    mediaDuration = e.getTextContent();
                    continue;
                }
                if ("currentURI".equals(name)) {
                    currentURI = e.getTextContent();
                    continue;
                }
                if ("currentURIMetaData".equals(name)) {
                    currentURIMetaData = e.getTextContent();
                    continue;
                }
                if ("nextURI".equals(name)) {
                    nextURI = e.getTextContent();
                    continue;
                }
                if ("nextURIMetaData".equals(name)) {
                    nextURIMetaData = e.getTextContent();
                    continue;
                }
                if ("playMedium".equals(name)) {
                    playMedium = e.getTextContent();
                    continue;
                }
                if ("recordMedium".equals(name)) {
                    recordMedium = e.getTextContent();
                    continue;
                }
                if ("writeStatus".equals(name)) {
                    writeStatus = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetMediaInfo_ExtResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMediaInfo_ExtResponse", "u"));
            soapBodyElement.addChildElement("CurrentType").setTextContent(currentType.toString());
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetPositionInfoRequest.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("track".equals(name)) {
                    track = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("trackDuration".equals(name)) {
                    trackDuration = e.getTextContent();
                    continue;
                }
                if ("trackMetaData".equals(name)) {
                    trackMetaData = e.getTextContent();
                    continue;
                }
                if ("trackURI".equals(name)) {
                    trackURI = e.getTextContent();
                    continue;
                }
                if ("relTime".equals(name)) {
                    relTime = e.getTextContent();
                    continue;
                }
                if ("absTime".equals(name)) {
                    absTime = e.getTextContent();
                    continue;
                }
                if ("relCount".equals(name)) {
                    relCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("absCount".equals(name)) {
                    absCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetPositionInfoResponse.createMessage();
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

    public static class GetStateVariablesRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String stateVariableList;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("stateVariableList".equals(name)) {
                    stateVariableList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetStateVariablesRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetStateVariablesRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("StateVariableList").setTextContent(stateVariableList.toString());
            return retVal;
        }

    }

    public static class GetStateVariablesResponse
        extends SOAPSerializable
    {

        public String stateVariableValuePairs;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("stateVariableValuePairs".equals(name)) {
                    stateVariableValuePairs = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetStateVariablesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetStateVariablesResponse", "u"));
            soapBodyElement.addChildElement("StateVariableValuePairs").setTextContent(stateVariableValuePairs.toString());
            return retVal;
        }

    }

    public static class GetTransportInfoRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetTransportInfoRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransportInfoRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetTransportInfoResponse
        extends SOAPSerializable
    {

        public AVTransport2 .TransportState currentTransportState;
        public AVTransport2 .TransportStatus currentTransportStatus;
        public AVTransport2 .TransportPlaySpeed currentSpeed;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentTransportState".equals(name)) {
                    currentTransportState = AVTransport2 .TransportState.valueOf(e.getTextContent());
                    continue;
                }
                if ("currentTransportStatus".equals(name)) {
                    currentTransportStatus = AVTransport2 .TransportStatus.valueOf(e.getTextContent());
                    continue;
                }
                if ("currentSpeed".equals(name)) {
                    currentSpeed = AVTransport2 .TransportPlaySpeed.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetTransportInfoResponse.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetTransportSettingsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransportSettingsRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            return retVal;
        }

    }

    public static class GetTransportSettingsResponse
        extends SOAPSerializable
    {

        public AVTransport2 .CurrentPlayMode playMode;
        public String recQualityMode;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("playMode".equals(name)) {
                    playMode = AVTransport2 .CurrentPlayMode.valueOf(e.getTextContent());
                    continue;
                }
                if ("recQualityMode".equals(name)) {
                    recQualityMode = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .GetTransportSettingsResponse.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .NextRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .NextResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "NextResponse", "u"));
            return retVal;
        }

    }

    public static class PauseRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .PauseRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .PauseResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "PauseResponse", "u"));
            return retVal;
        }

    }

    public static class PlayRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.AVTransport2.TransportPlaySpeed speed;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("speed".equals(name)) {
                    speed = org.saintandreas.serket.scpd.AVTransport2.TransportPlaySpeed.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .PlayRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .PlayResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "PlayResponse", "u"));
            return retVal;
        }

    }

    public static class PreviousRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .PreviousRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .PreviousResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "PreviousResponse", "u"));
            return retVal;
        }

    }

    public static class RecordRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .RecordRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .RecordResponse.createMessage();
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
        public AVTransport2 .SeekMode unit;
        public String target;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("unit".equals(name)) {
                    unit = AVTransport2 .SeekMode.valueOf(e.getTextContent());
                    continue;
                }
                if ("target".equals(name)) {
                    target = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .SeekRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .SeekResponse.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("currentURI".equals(name)) {
                    currentURI = e.getTextContent();
                    continue;
                }
                if ("currentURIMetaData".equals(name)) {
                    currentURIMetaData = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .SetAVTransportURIRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .SetAVTransportURIResponse.createMessage();
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

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("nextURI".equals(name)) {
                    nextURI = e.getTextContent();
                    continue;
                }
                if ("nextURIMetaData".equals(name)) {
                    nextURIMetaData = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .SetNextAVTransportURIRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .SetNextAVTransportURIResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetNextAVTransportURIResponse", "u"));
            return retVal;
        }

    }

    public static class SetPlayModeRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.AVTransport2.CurrentPlayMode newPlayMode;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("newPlayMode".equals(name)) {
                    newPlayMode = org.saintandreas.serket.scpd.AVTransport2.CurrentPlayMode.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .SetPlayModeRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .SetPlayModeResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetPlayModeResponse", "u"));
            return retVal;
        }

    }

    public static class SetRecordQualityModeRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String newRecordQualityMode;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("newRecordQualityMode".equals(name)) {
                    newRecordQualityMode = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .SetRecordQualityModeRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .SetRecordQualityModeResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRecordQualityModeResponse", "u"));
            return retVal;
        }

    }

    public static class SetStateVariablesRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String aVTransportUDN;
        public String serviceType;
        public String serviceId;
        public String stateVariableValuePairs;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("aVTransportUDN".equals(name)) {
                    aVTransportUDN = e.getTextContent();
                    continue;
                }
                if ("serviceType".equals(name)) {
                    serviceType = e.getTextContent();
                    continue;
                }
                if ("serviceId".equals(name)) {
                    serviceId = e.getTextContent();
                    continue;
                }
                if ("stateVariableValuePairs".equals(name)) {
                    stateVariableValuePairs = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .SetStateVariablesRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetStateVariablesRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("AVTransportUDN").setTextContent(aVTransportUDN.toString());
            soapBodyElement.addChildElement("ServiceType").setTextContent(serviceType.toString());
            soapBodyElement.addChildElement("ServiceId").setTextContent(serviceId.toString());
            soapBodyElement.addChildElement("StateVariableValuePairs").setTextContent(stateVariableValuePairs.toString());
            return retVal;
        }

    }

    public static class SetStateVariablesResponse
        extends SOAPSerializable
    {

        public String stateVariableList;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("stateVariableList".equals(name)) {
                    stateVariableList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .SetStateVariablesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetStateVariablesResponse", "u"));
            soapBodyElement.addChildElement("StateVariableList").setTextContent(stateVariableList.toString());
            return retVal;
        }

    }

    public static class StopRequest
        extends SOAPSerializable
    {

        public int instanceID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("instanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = AVTransport2 .StopRequest.createMessage();
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
            SOAPMessage retVal = AVTransport2 .StopResponse.createMessage();
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
