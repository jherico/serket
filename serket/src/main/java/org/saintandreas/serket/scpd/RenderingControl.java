
package org.saintandreas.serket.scpd;

import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.saintandreas.serket.soap.SOAPSerializable;
import org.w3c.dom.Element;

public interface RenderingControl {

    public final static String URI = "urn:schemas-upnp-org:service:RenderingControl:1";

    public RenderingControl.ListPresetsResponse listPresets(RenderingControl.ListPresetsRequest input);

    public RenderingControl.SelectPresetResponse selectPreset(RenderingControl.SelectPresetRequest input);

    public RenderingControl.GetBrightnessResponse getBrightness(RenderingControl.GetBrightnessRequest input);

    public RenderingControl.SetBrightnessResponse setBrightness(RenderingControl.SetBrightnessRequest input);

    public RenderingControl.GetContrastResponse getContrast(RenderingControl.GetContrastRequest input);

    public RenderingControl.SetContrastResponse setContrast(RenderingControl.SetContrastRequest input);

    public RenderingControl.GetSharpnessResponse getSharpness(RenderingControl.GetSharpnessRequest input);

    public RenderingControl.SetSharpnessResponse setSharpness(RenderingControl.SetSharpnessRequest input);

    public RenderingControl.GetRedVideoGainResponse getRedVideoGain(RenderingControl.GetRedVideoGainRequest input);

    public RenderingControl.SetRedVideoGainResponse setRedVideoGain(RenderingControl.SetRedVideoGainRequest input);

    public RenderingControl.GetGreenVideoGainResponse getGreenVideoGain(RenderingControl.GetGreenVideoGainRequest input);

    public RenderingControl.SetGreenVideoGainResponse setGreenVideoGain(RenderingControl.SetGreenVideoGainRequest input);

    public RenderingControl.GetBlueVideoGainResponse getBlueVideoGain(RenderingControl.GetBlueVideoGainRequest input);

    public RenderingControl.SetBlueVideoGainResponse setBlueVideoGain(RenderingControl.SetBlueVideoGainRequest input);

    public RenderingControl.GetRedVideoBlackLevelResponse getRedVideoBlackLevel(RenderingControl.GetRedVideoBlackLevelRequest input);

    public RenderingControl.SetRedVideoBlackLevelResponse setRedVideoBlackLevel(RenderingControl.SetRedVideoBlackLevelRequest input);

    public RenderingControl.GetGreenVideoBlackLevelResponse getGreenVideoBlackLevel(RenderingControl.GetGreenVideoBlackLevelRequest input);

    public RenderingControl.SetGreenVideoBlackLevelResponse setGreenVideoBlackLevel(RenderingControl.SetGreenVideoBlackLevelRequest input);

    public RenderingControl.GetBlueVideoBlackLevelResponse getBlueVideoBlackLevel(RenderingControl.GetBlueVideoBlackLevelRequest input);

    public RenderingControl.SetBlueVideoBlackLevelResponse setBlueVideoBlackLevel(RenderingControl.SetBlueVideoBlackLevelRequest input);

    public RenderingControl.GetColorTemperatureResponse getColorTemperature(RenderingControl.GetColorTemperatureRequest input);

    public RenderingControl.SetColorTemperatureResponse setColorTemperature(RenderingControl.SetColorTemperatureRequest input);

    public RenderingControl.GetHorizontalKeystoneResponse getHorizontalKeystone(RenderingControl.GetHorizontalKeystoneRequest input);

    public RenderingControl.SetHorizontalKeystoneResponse setHorizontalKeystone(RenderingControl.SetHorizontalKeystoneRequest input);

    public RenderingControl.GetVerticalKeystoneResponse getVerticalKeystone(RenderingControl.GetVerticalKeystoneRequest input);

    public RenderingControl.SetVerticalKeystoneResponse setVerticalKeystone(RenderingControl.SetVerticalKeystoneRequest input);

    public RenderingControl.GetMuteResponse getMute(RenderingControl.GetMuteRequest input);

    public RenderingControl.SetMuteResponse setMute(RenderingControl.SetMuteRequest input);

    public RenderingControl.GetVolumeResponse getVolume(RenderingControl.GetVolumeRequest input);

    public RenderingControl.SetVolumeResponse setVolume(RenderingControl.SetVolumeRequest input);

    public RenderingControl.GetVolumeDBResponse getVolumeDB(RenderingControl.GetVolumeDBRequest input);

    public RenderingControl.SetVolumeDBResponse setVolumeDB(RenderingControl.SetVolumeDBRequest input);

    public RenderingControl.GetVolumeDBRangeResponse getVolumeDBRange(RenderingControl.GetVolumeDBRangeRequest input);

    public RenderingControl.GetLoudnessResponse getLoudness(RenderingControl.GetLoudnessRequest input);

    public RenderingControl.SetLoudnessResponse setLoudness(RenderingControl.SetLoudnessRequest input);

    public enum Channel {

        Master;

    }

    public static abstract class GetBlueVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetBlueVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetBlueVideoBlackLevelResponse
        extends SOAPSerializable
    {

        public Integer currentBlueVideoBlackLevel;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentBlueVideoBlackLevel".equals(name)) {
                    currentBlueVideoBlackLevel = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetBlueVideoBlackLevelResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoBlackLevelResponse", "u"));
            soapBodyElement.addChildElement("CurrentBlueVideoBlackLevel").setTextContent(currentBlueVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static abstract class GetBlueVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetBlueVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetBlueVideoGainResponse
        extends SOAPSerializable
    {

        public Integer currentBlueVideoGain;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentBlueVideoGain".equals(name)) {
                    currentBlueVideoGain = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetBlueVideoGainResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoGainResponse", "u"));
            soapBodyElement.addChildElement("CurrentBlueVideoGain").setTextContent(currentBlueVideoGain.toString());
            return retVal;
        }

    }

    public static abstract class GetBrightnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetBrightnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBrightnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetBrightnessResponse
        extends SOAPSerializable
    {

        public Integer currentBrightness;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentBrightness".equals(name)) {
                    currentBrightness = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetBrightnessResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBrightnessResponse", "u"));
            soapBodyElement.addChildElement("CurrentBrightness").setTextContent(currentBrightness.toString());
            return retVal;
        }

    }

    public static abstract class GetColorTemperatureRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetColorTemperatureRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetColorTemperatureRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetColorTemperatureResponse
        extends SOAPSerializable
    {

        public Integer currentColorTemperature;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentColorTemperature".equals(name)) {
                    currentColorTemperature = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetColorTemperatureResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetColorTemperatureResponse", "u"));
            soapBodyElement.addChildElement("CurrentColorTemperature").setTextContent(currentColorTemperature.toString());
            return retVal;
        }

    }

    public static abstract class GetContrastRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetContrastRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetContrastRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetContrastResponse
        extends SOAPSerializable
    {

        public Integer currentContrast;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentContrast".equals(name)) {
                    currentContrast = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetContrastResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetContrastResponse", "u"));
            soapBodyElement.addChildElement("CurrentContrast").setTextContent(currentContrast.toString());
            return retVal;
        }

    }

    public static abstract class GetGreenVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetGreenVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetGreenVideoBlackLevelResponse
        extends SOAPSerializable
    {

        public Integer currentGreenVideoBlackLevel;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentGreenVideoBlackLevel".equals(name)) {
                    currentGreenVideoBlackLevel = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetGreenVideoBlackLevelResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoBlackLevelResponse", "u"));
            soapBodyElement.addChildElement("CurrentGreenVideoBlackLevel").setTextContent(currentGreenVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static abstract class GetGreenVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetGreenVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetGreenVideoGainResponse
        extends SOAPSerializable
    {

        public Integer currentGreenVideoGain;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentGreenVideoGain".equals(name)) {
                    currentGreenVideoGain = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetGreenVideoGainResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoGainResponse", "u"));
            soapBodyElement.addChildElement("CurrentGreenVideoGain").setTextContent(currentGreenVideoGain.toString());
            return retVal;
        }

    }

    public static abstract class GetHorizontalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetHorizontalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetHorizontalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetHorizontalKeystoneResponse
        extends SOAPSerializable
    {

        public Integer currentHorizontalKeystone;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentHorizontalKeystone".equals(name)) {
                    currentHorizontalKeystone = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetHorizontalKeystoneResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetHorizontalKeystoneResponse", "u"));
            soapBodyElement.addChildElement("CurrentHorizontalKeystone").setTextContent(currentHorizontalKeystone.toString());
            return retVal;
        }

    }

    public static abstract class GetLoudnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetLoudnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetLoudnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            return retVal;
        }

    }

    public static abstract class GetLoudnessResponse
        extends SOAPSerializable
    {

        public Boolean currentLoudness;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentLoudness".equals(name)) {
                    currentLoudness = Boolean.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetLoudnessResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetLoudnessResponse", "u"));
            soapBodyElement.addChildElement("CurrentLoudness").setTextContent(currentLoudness.toString());
            return retVal;
        }

    }

    public static abstract class GetMuteRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public RenderingControl.Channel channel;

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
                if ("channel".equals(name)) {
                    channel = RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetMuteRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMuteRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            return retVal;
        }

    }

    public static abstract class GetMuteResponse
        extends SOAPSerializable
    {

        public Boolean currentMute;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentMute".equals(name)) {
                    currentMute = Boolean.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetMuteResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMuteResponse", "u"));
            soapBodyElement.addChildElement("CurrentMute").setTextContent(currentMute.toString());
            return retVal;
        }

    }

    public static abstract class GetRedVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetRedVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetRedVideoBlackLevelResponse
        extends SOAPSerializable
    {

        public Integer currentRedVideoBlackLevel;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentRedVideoBlackLevel".equals(name)) {
                    currentRedVideoBlackLevel = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetRedVideoBlackLevelResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoBlackLevelResponse", "u"));
            soapBodyElement.addChildElement("CurrentRedVideoBlackLevel").setTextContent(currentRedVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static abstract class GetRedVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetRedVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetRedVideoGainResponse
        extends SOAPSerializable
    {

        public Integer currentRedVideoGain;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentRedVideoGain".equals(name)) {
                    currentRedVideoGain = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetRedVideoGainResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoGainResponse", "u"));
            soapBodyElement.addChildElement("CurrentRedVideoGain").setTextContent(currentRedVideoGain.toString());
            return retVal;
        }

    }

    public static abstract class GetSharpnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetSharpnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSharpnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetSharpnessResponse
        extends SOAPSerializable
    {

        public Integer currentSharpness;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentSharpness".equals(name)) {
                    currentSharpness = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetSharpnessResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSharpnessResponse", "u"));
            soapBodyElement.addChildElement("CurrentSharpness").setTextContent(currentSharpness.toString());
            return retVal;
        }

    }

    public static abstract class GetVerticalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.GetVerticalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVerticalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class GetVerticalKeystoneResponse
        extends SOAPSerializable
    {

        public Integer currentVerticalKeystone;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentVerticalKeystone".equals(name)) {
                    currentVerticalKeystone = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetVerticalKeystoneResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVerticalKeystoneResponse", "u"));
            soapBodyElement.addChildElement("CurrentVerticalKeystone").setTextContent(currentVerticalKeystone.toString());
            return retVal;
        }

    }

    public static abstract class GetVolumeDBRangeRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetVolumeDBRangeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBRangeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            return retVal;
        }

    }

    public static abstract class GetVolumeDBRangeResponse
        extends SOAPSerializable
    {

        public Integer minValue;
        public Integer maxValue;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("minValue".equals(name)) {
                    minValue = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("maxValue".equals(name)) {
                    maxValue = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetVolumeDBRangeResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBRangeResponse", "u"));
            soapBodyElement.addChildElement("MinValue").setTextContent(minValue.toString());
            soapBodyElement.addChildElement("MaxValue").setTextContent(maxValue.toString());
            return retVal;
        }

    }

    public static abstract class GetVolumeDBRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetVolumeDBRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            return retVal;
        }

    }

    public static abstract class GetVolumeDBResponse
        extends SOAPSerializable
    {

        public Integer currentVolume;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentVolume".equals(name)) {
                    currentVolume = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetVolumeDBResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBResponse", "u"));
            soapBodyElement.addChildElement("CurrentVolume").setTextContent(currentVolume.toString());
            return retVal;
        }

    }

    public static abstract class GetVolumeRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetVolumeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            return retVal;
        }

    }

    public static abstract class GetVolumeResponse
        extends SOAPSerializable
    {

        public Integer currentVolume;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentVolume".equals(name)) {
                    currentVolume = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.GetVolumeResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeResponse", "u"));
            soapBodyElement.addChildElement("CurrentVolume").setTextContent(currentVolume.toString());
            return retVal;
        }

    }

    public static abstract class ListPresetsRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

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
            SOAPMessage retVal = RenderingControl.ListPresetsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ListPresetsRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static abstract class ListPresetsResponse
        extends SOAPSerializable
    {

        public String currentPresetNameList;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("currentPresetNameList".equals(name)) {
                    currentPresetNameList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.ListPresetsResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ListPresetsResponse", "u"));
            soapBodyElement.addChildElement("CurrentPresetNameList").setTextContent(currentPresetNameList.toString());
            return retVal;
        }

    }

    public enum PresetName {

        FactoryDefaults;

    }

    public static abstract class SelectPresetRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public RenderingControl.PresetName presetName;

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
                if ("presetName".equals(name)) {
                    presetName = RenderingControl.PresetName.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SelectPresetRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SelectPresetRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("PresetName").setTextContent(presetName.toString());
            return retVal;
        }

    }

    public static abstract class SelectPresetResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SelectPresetResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SelectPresetResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetBlueVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredBlueVideoBlackLevel;

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
                if ("desiredBlueVideoBlackLevel".equals(name)) {
                    desiredBlueVideoBlackLevel = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetBlueVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredBlueVideoBlackLevel").setTextContent(desiredBlueVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static abstract class SetBlueVideoBlackLevelResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetBlueVideoBlackLevelResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoBlackLevelResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetBlueVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredBlueVideoGain;

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
                if ("desiredBlueVideoGain".equals(name)) {
                    desiredBlueVideoGain = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetBlueVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredBlueVideoGain").setTextContent(desiredBlueVideoGain.toString());
            return retVal;
        }

    }

    public static abstract class SetBlueVideoGainResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetBlueVideoGainResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoGainResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetBrightnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredBrightness;

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
                if ("desiredBrightness".equals(name)) {
                    desiredBrightness = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetBrightnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBrightnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredBrightness").setTextContent(desiredBrightness.toString());
            return retVal;
        }

    }

    public static abstract class SetBrightnessResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetBrightnessResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBrightnessResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetColorTemperatureRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredColorTemperature;

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
                if ("desiredColorTemperature".equals(name)) {
                    desiredColorTemperature = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetColorTemperatureRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetColorTemperatureRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredColorTemperature").setTextContent(desiredColorTemperature.toString());
            return retVal;
        }

    }

    public static abstract class SetColorTemperatureResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetColorTemperatureResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetColorTemperatureResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetContrastRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredContrast;

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
                if ("desiredContrast".equals(name)) {
                    desiredContrast = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetContrastRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetContrastRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredContrast").setTextContent(desiredContrast.toString());
            return retVal;
        }

    }

    public static abstract class SetContrastResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetContrastResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetContrastResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetGreenVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredGreenVideoBlackLevel;

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
                if ("desiredGreenVideoBlackLevel".equals(name)) {
                    desiredGreenVideoBlackLevel = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetGreenVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredGreenVideoBlackLevel").setTextContent(desiredGreenVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static abstract class SetGreenVideoBlackLevelResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetGreenVideoBlackLevelResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoBlackLevelResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetGreenVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredGreenVideoGain;

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
                if ("desiredGreenVideoGain".equals(name)) {
                    desiredGreenVideoGain = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetGreenVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredGreenVideoGain").setTextContent(desiredGreenVideoGain.toString());
            return retVal;
        }

    }

    public static abstract class SetGreenVideoGainResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetGreenVideoGainResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoGainResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetHorizontalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredHorizontalKeystone;

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
                if ("desiredHorizontalKeystone".equals(name)) {
                    desiredHorizontalKeystone = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetHorizontalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetHorizontalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredHorizontalKeystone").setTextContent(desiredHorizontalKeystone.toString());
            return retVal;
        }

    }

    public static abstract class SetHorizontalKeystoneResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetHorizontalKeystoneResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetHorizontalKeystoneResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetLoudnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Boolean desiredLoudness;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("desiredLoudness".equals(name)) {
                    desiredLoudness = Boolean.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetLoudnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetLoudnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            soapBodyElement.addChildElement("DesiredLoudness").setTextContent(desiredLoudness.toString());
            return retVal;
        }

    }

    public static abstract class SetLoudnessResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetLoudnessResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetLoudnessResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetMuteRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Boolean desiredMute;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("desiredMute".equals(name)) {
                    desiredMute = Boolean.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetMuteRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetMuteRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            soapBodyElement.addChildElement("DesiredMute").setTextContent(desiredMute.toString());
            return retVal;
        }

    }

    public static abstract class SetMuteResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetMuteResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetMuteResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetRedVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredRedVideoBlackLevel;

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
                if ("desiredRedVideoBlackLevel".equals(name)) {
                    desiredRedVideoBlackLevel = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetRedVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredRedVideoBlackLevel").setTextContent(desiredRedVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static abstract class SetRedVideoBlackLevelResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetRedVideoBlackLevelResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoBlackLevelResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetRedVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredRedVideoGain;

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
                if ("desiredRedVideoGain".equals(name)) {
                    desiredRedVideoGain = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetRedVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredRedVideoGain").setTextContent(desiredRedVideoGain.toString());
            return retVal;
        }

    }

    public static abstract class SetRedVideoGainResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetRedVideoGainResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoGainResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetSharpnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredSharpness;

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
                if ("desiredSharpness".equals(name)) {
                    desiredSharpness = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetSharpnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetSharpnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredSharpness").setTextContent(desiredSharpness.toString());
            return retVal;
        }

    }

    public static abstract class SetSharpnessResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetSharpnessResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetSharpnessResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetVerticalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredVerticalKeystone;

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
                if ("desiredVerticalKeystone".equals(name)) {
                    desiredVerticalKeystone = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetVerticalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVerticalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("DesiredVerticalKeystone").setTextContent(desiredVerticalKeystone.toString());
            return retVal;
        }

    }

    public static abstract class SetVerticalKeystoneResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetVerticalKeystoneResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVerticalKeystoneResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetVolumeDBRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Integer desiredVolume;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("desiredVolume".equals(name)) {
                    desiredVolume = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetVolumeDBRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeDBRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            soapBodyElement.addChildElement("DesiredVolume").setTextContent(desiredVolume.toString());
            return retVal;
        }

    }

    public static abstract class SetVolumeDBResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetVolumeDBResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeDBResponse", "u"));
            return retVal;
        }

    }

    public static abstract class SetVolumeRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Integer desiredVolume;

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
                if ("channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("desiredVolume".equals(name)) {
                    desiredVolume = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetVolumeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            soapBodyElement.addChildElement("Channel").setTextContent(channel.toString());
            soapBodyElement.addChildElement("DesiredVolume").setTextContent(desiredVolume.toString());
            return retVal;
        }

    }

    public static abstract class SetVolumeResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl.SetVolumeResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeResponse", "u"));
            return retVal;
        }

    }

}
