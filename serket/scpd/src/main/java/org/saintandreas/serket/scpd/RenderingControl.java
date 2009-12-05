
package org.saintandreas.serket.scpd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.saintandreas.serket.impl.BaseService;
import org.saintandreas.util.SOAPSerializable;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Element;

public abstract class RenderingControl
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:RenderingControl:1";

    public RenderingControl(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract RenderingControl.ListPresetsResponse listPresets(RenderingControl.ListPresetsRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SelectPresetResponse selectPreset(RenderingControl.SelectPresetRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetBrightnessResponse getBrightness(RenderingControl.GetBrightnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetBrightnessResponse setBrightness(RenderingControl.SetBrightnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetContrastResponse getContrast(RenderingControl.GetContrastRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetContrastResponse setContrast(RenderingControl.SetContrastRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetSharpnessResponse getSharpness(RenderingControl.GetSharpnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetSharpnessResponse setSharpness(RenderingControl.SetSharpnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetRedVideoGainResponse getRedVideoGain(RenderingControl.GetRedVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetRedVideoGainResponse setRedVideoGain(RenderingControl.SetRedVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetGreenVideoGainResponse getGreenVideoGain(RenderingControl.GetGreenVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetGreenVideoGainResponse setGreenVideoGain(RenderingControl.SetGreenVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetBlueVideoGainResponse getBlueVideoGain(RenderingControl.GetBlueVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetBlueVideoGainResponse setBlueVideoGain(RenderingControl.SetBlueVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetRedVideoBlackLevelResponse getRedVideoBlackLevel(RenderingControl.GetRedVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetRedVideoBlackLevelResponse setRedVideoBlackLevel(RenderingControl.SetRedVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetGreenVideoBlackLevelResponse getGreenVideoBlackLevel(RenderingControl.GetGreenVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetGreenVideoBlackLevelResponse setGreenVideoBlackLevel(RenderingControl.SetGreenVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetBlueVideoBlackLevelResponse getBlueVideoBlackLevel(RenderingControl.GetBlueVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetBlueVideoBlackLevelResponse setBlueVideoBlackLevel(RenderingControl.SetBlueVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetColorTemperatureResponse getColorTemperature(RenderingControl.GetColorTemperatureRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetColorTemperatureResponse setColorTemperature(RenderingControl.SetColorTemperatureRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetHorizontalKeystoneResponse getHorizontalKeystone(RenderingControl.GetHorizontalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetHorizontalKeystoneResponse setHorizontalKeystone(RenderingControl.SetHorizontalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetVerticalKeystoneResponse getVerticalKeystone(RenderingControl.GetVerticalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetVerticalKeystoneResponse setVerticalKeystone(RenderingControl.SetVerticalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetMuteResponse getMute(RenderingControl.GetMuteRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetMuteResponse setMute(RenderingControl.SetMuteRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetVolumeResponse getVolume(RenderingControl.GetVolumeRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetVolumeResponse setVolume(RenderingControl.SetVolumeRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetVolumeDBResponse getVolumeDB(RenderingControl.GetVolumeDBRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetVolumeDBResponse setVolumeDB(RenderingControl.SetVolumeDBRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetVolumeDBRangeResponse getVolumeDBRange(RenderingControl.GetVolumeDBRangeRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.GetLoudnessResponse getLoudness(RenderingControl.GetLoudnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl.SetLoudnessResponse setLoudness(RenderingControl.SetLoudnessRequest input)
        throws IOException, ServletException
    ;

    public enum Channel {

        Master;

    }

    public static class GetBlueVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetBlueVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetBlueVideoBlackLevelResponse
        extends SOAPSerializable
    {

        public Integer currentBlueVideoBlackLevel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentBlueVideoBlackLevel".equals(name)) {
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

    public static class GetBlueVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetBlueVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetBlueVideoGainResponse
        extends SOAPSerializable
    {

        public Integer currentBlueVideoGain;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentBlueVideoGain".equals(name)) {
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

    public static class GetBrightnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetBrightnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBrightnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetBrightnessResponse
        extends SOAPSerializable
    {

        public Integer currentBrightness;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentBrightness".equals(name)) {
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

    public static class GetColorTemperatureRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetColorTemperatureRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetColorTemperatureRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetColorTemperatureResponse
        extends SOAPSerializable
    {

        public Integer currentColorTemperature;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentColorTemperature".equals(name)) {
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

    public static class GetContrastRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetContrastRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetContrastRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetContrastResponse
        extends SOAPSerializable
    {

        public Integer currentContrast;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentContrast".equals(name)) {
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

    public static class GetGreenVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetGreenVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetGreenVideoBlackLevelResponse
        extends SOAPSerializable
    {

        public Integer currentGreenVideoBlackLevel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentGreenVideoBlackLevel".equals(name)) {
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

    public static class GetGreenVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetGreenVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetGreenVideoGainResponse
        extends SOAPSerializable
    {

        public Integer currentGreenVideoGain;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentGreenVideoGain".equals(name)) {
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

    public static class GetHorizontalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetHorizontalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetHorizontalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetHorizontalKeystoneResponse
        extends SOAPSerializable
    {

        public Integer currentHorizontalKeystone;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentHorizontalKeystone".equals(name)) {
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

    public static class GetLoudnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
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

    public static class GetLoudnessResponse
        extends SOAPSerializable
    {

        public Boolean currentLoudness;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentLoudness".equals(name)) {
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

    public static class GetMuteRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public RenderingControl.Channel channel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
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

    public static class GetMuteResponse
        extends SOAPSerializable
    {

        public Boolean currentMute;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentMute".equals(name)) {
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

    public static class GetRedVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetRedVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetRedVideoBlackLevelResponse
        extends SOAPSerializable
    {

        public Integer currentRedVideoBlackLevel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentRedVideoBlackLevel".equals(name)) {
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

    public static class GetRedVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetRedVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetRedVideoGainResponse
        extends SOAPSerializable
    {

        public Integer currentRedVideoGain;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentRedVideoGain".equals(name)) {
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

    public static class GetSharpnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetSharpnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSharpnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetSharpnessResponse
        extends SOAPSerializable
    {

        public Integer currentSharpness;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentSharpness".equals(name)) {
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

    public static class GetVerticalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.GetVerticalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVerticalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class GetVerticalKeystoneResponse
        extends SOAPSerializable
    {

        public Integer currentVerticalKeystone;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentVerticalKeystone".equals(name)) {
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

    public static class GetVolumeDBRangeRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
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

    public static class GetVolumeDBRangeResponse
        extends SOAPSerializable
    {

        public Integer minValue;
        public Integer maxValue;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("MinValue".equals(name)) {
                    minValue = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("MaxValue".equals(name)) {
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

    public static class GetVolumeDBRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
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

    public static class GetVolumeDBResponse
        extends SOAPSerializable
    {

        public Integer currentVolume;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentVolume".equals(name)) {
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

    public static class GetVolumeRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
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

    public static class GetVolumeResponse
        extends SOAPSerializable
    {

        public Integer currentVolume;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentVolume".equals(name)) {
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

    public static class ListPresetsRequest
        extends SOAPSerializable
    {

        public Integer instanceID;

        
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
            SOAPMessage retVal = RenderingControl.ListPresetsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ListPresetsRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(instanceID.toString());
            return retVal;
        }

    }

    public static class ListPresetsResponse
        extends SOAPSerializable
    {

        public String currentPresetNameList;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("CurrentPresetNameList".equals(name)) {
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

    public static class SelectPresetRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public RenderingControl.PresetName presetName;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("PresetName".equals(name)) {
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

    public static class SelectPresetResponse
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

    public static class SetBlueVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredBlueVideoBlackLevel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredBlueVideoBlackLevel".equals(name)) {
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

    public static class SetBlueVideoBlackLevelResponse
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

    public static class SetBlueVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredBlueVideoGain;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredBlueVideoGain".equals(name)) {
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

    public static class SetBlueVideoGainResponse
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

    public static class SetBrightnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredBrightness;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredBrightness".equals(name)) {
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

    public static class SetBrightnessResponse
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

    public static class SetColorTemperatureRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredColorTemperature;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredColorTemperature".equals(name)) {
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

    public static class SetColorTemperatureResponse
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

    public static class SetContrastRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredContrast;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredContrast".equals(name)) {
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

    public static class SetContrastResponse
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

    public static class SetGreenVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredGreenVideoBlackLevel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredGreenVideoBlackLevel".equals(name)) {
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

    public static class SetGreenVideoBlackLevelResponse
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

    public static class SetGreenVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredGreenVideoGain;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredGreenVideoGain".equals(name)) {
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

    public static class SetGreenVideoGainResponse
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

    public static class SetHorizontalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredHorizontalKeystone;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredHorizontalKeystone".equals(name)) {
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

    public static class SetHorizontalKeystoneResponse
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

    public static class SetLoudnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Boolean desiredLoudness;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredLoudness".equals(name)) {
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

    public static class SetLoudnessResponse
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

    public static class SetMuteRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Boolean desiredMute;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredMute".equals(name)) {
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

    public static class SetMuteResponse
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

    public static class SetRedVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredRedVideoBlackLevel;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredRedVideoBlackLevel".equals(name)) {
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

    public static class SetRedVideoBlackLevelResponse
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

    public static class SetRedVideoGainRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredRedVideoGain;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredRedVideoGain".equals(name)) {
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

    public static class SetRedVideoGainResponse
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

    public static class SetSharpnessRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredSharpness;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredSharpness".equals(name)) {
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

    public static class SetSharpnessResponse
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

    public static class SetVerticalKeystoneRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public Integer desiredVerticalKeystone;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredVerticalKeystone".equals(name)) {
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

    public static class SetVerticalKeystoneResponse
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

    public static class SetVolumeDBRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Integer desiredVolume;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredVolume".equals(name)) {
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

    public static class SetVolumeDBResponse
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

    public static class SetVolumeRequest
        extends SOAPSerializable
    {

        public Integer instanceID;
        public org.saintandreas.serket.scpd.RenderingControl.Channel channel;
        public Integer desiredVolume;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("Channel".equals(name)) {
                    channel = org.saintandreas.serket.scpd.RenderingControl.Channel.valueOf(e.getTextContent());
                    continue;
                }
                if ("DesiredVolume".equals(name)) {
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

    public static class SetVolumeResponse
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
