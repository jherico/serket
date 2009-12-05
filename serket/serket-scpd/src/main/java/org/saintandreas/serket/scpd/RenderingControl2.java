
package org.saintandreas.serket.scpd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.saintandreas.serket.service.BaseService;
import org.saintandreas.util.SOAPSerializable;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Element;

public abstract class RenderingControl2
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:RenderingControl:2";

    public RenderingControl2(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract RenderingControl2 .ListPresetsResponse listPresets(RenderingControl2 .ListPresetsRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SelectPresetResponse selectPreset(RenderingControl2 .SelectPresetRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetBrightnessResponse getBrightness(RenderingControl2 .GetBrightnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetBrightnessResponse setBrightness(RenderingControl2 .SetBrightnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetContrastResponse getContrast(RenderingControl2 .GetContrastRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetContrastResponse setContrast(RenderingControl2 .SetContrastRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetSharpnessResponse getSharpness(RenderingControl2 .GetSharpnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetSharpnessResponse setSharpness(RenderingControl2 .SetSharpnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetRedVideoGainResponse getRedVideoGain(RenderingControl2 .GetRedVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetRedVideoGainResponse setRedVideoGain(RenderingControl2 .SetRedVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetGreenVideoGainResponse getGreenVideoGain(RenderingControl2 .GetGreenVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetGreenVideoGainResponse setGreenVideoGain(RenderingControl2 .SetGreenVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetBlueVideoGainResponse getBlueVideoGain(RenderingControl2 .GetBlueVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetBlueVideoGainResponse setBlueVideoGain(RenderingControl2 .SetBlueVideoGainRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetRedVideoBlackLevelResponse getRedVideoBlackLevel(RenderingControl2 .GetRedVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetRedVideoBlackLevelResponse setRedVideoBlackLevel(RenderingControl2 .SetRedVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetGreenVideoBlackLevelResponse getGreenVideoBlackLevel(RenderingControl2 .GetGreenVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetGreenVideoBlackLevelResponse setGreenVideoBlackLevel(RenderingControl2 .SetGreenVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetBlueVideoBlackLevelResponse getBlueVideoBlackLevel(RenderingControl2 .GetBlueVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetBlueVideoBlackLevelResponse setBlueVideoBlackLevel(RenderingControl2 .SetBlueVideoBlackLevelRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetColorTemperatureResponse getColorTemperature(RenderingControl2 .GetColorTemperatureRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetColorTemperatureResponse setColorTemperature(RenderingControl2 .SetColorTemperatureRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetHorizontalKeystoneResponse getHorizontalKeystone(RenderingControl2 .GetHorizontalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetHorizontalKeystoneResponse setHorizontalKeystone(RenderingControl2 .SetHorizontalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetVerticalKeystoneResponse getVerticalKeystone(RenderingControl2 .GetVerticalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetVerticalKeystoneResponse setVerticalKeystone(RenderingControl2 .SetVerticalKeystoneRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetMuteResponse getMute(RenderingControl2 .GetMuteRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetMuteResponse setMute(RenderingControl2 .SetMuteRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetVolumeResponse getVolume(RenderingControl2 .GetVolumeRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetVolumeResponse setVolume(RenderingControl2 .SetVolumeRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetVolumeDBResponse getVolumeDB(RenderingControl2 .GetVolumeDBRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetVolumeDBResponse setVolumeDB(RenderingControl2 .SetVolumeDBRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetVolumeDBRangeResponse getVolumeDBRange(RenderingControl2 .GetVolumeDBRangeRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetLoudnessResponse getLoudness(RenderingControl2 .GetLoudnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetLoudnessResponse setLoudness(RenderingControl2 .SetLoudnessRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .GetStateVariablesResponse getStateVariables(RenderingControl2 .GetStateVariablesRequest input)
        throws IOException, ServletException
    ;

    public abstract RenderingControl2 .SetStateVariablesResponse setStateVariables(RenderingControl2 .SetStateVariablesRequest input)
        throws IOException, ServletException
    ;

    public enum Channel {

        Master;

    }

    public static class GetBlueVideoBlackLevelRequest
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
            SOAPMessage retVal = RenderingControl2 .GetBlueVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetBlueVideoBlackLevelResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoBlackLevelResponse", "u"));
            soapBodyElement.addChildElement("CurrentBlueVideoBlackLevel").setTextContent(currentBlueVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static class GetBlueVideoGainRequest
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
            SOAPMessage retVal = RenderingControl2 .GetBlueVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetBlueVideoGainResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBlueVideoGainResponse", "u"));
            soapBodyElement.addChildElement("CurrentBlueVideoGain").setTextContent(currentBlueVideoGain.toString());
            return retVal;
        }

    }

    public static class GetBrightnessRequest
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
            SOAPMessage retVal = RenderingControl2 .GetBrightnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBrightnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetBrightnessResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetBrightnessResponse", "u"));
            soapBodyElement.addChildElement("CurrentBrightness").setTextContent(currentBrightness.toString());
            return retVal;
        }

    }

    public static class GetColorTemperatureRequest
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
            SOAPMessage retVal = RenderingControl2 .GetColorTemperatureRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetColorTemperatureRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetColorTemperatureResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetColorTemperatureResponse", "u"));
            soapBodyElement.addChildElement("CurrentColorTemperature").setTextContent(currentColorTemperature.toString());
            return retVal;
        }

    }

    public static class GetContrastRequest
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
            SOAPMessage retVal = RenderingControl2 .GetContrastRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetContrastRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetContrastResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetContrastResponse", "u"));
            soapBodyElement.addChildElement("CurrentContrast").setTextContent(currentContrast.toString());
            return retVal;
        }

    }

    public static class GetGreenVideoBlackLevelRequest
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
            SOAPMessage retVal = RenderingControl2 .GetGreenVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetGreenVideoBlackLevelResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoBlackLevelResponse", "u"));
            soapBodyElement.addChildElement("CurrentGreenVideoBlackLevel").setTextContent(currentGreenVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static class GetGreenVideoGainRequest
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
            SOAPMessage retVal = RenderingControl2 .GetGreenVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetGreenVideoGainResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetGreenVideoGainResponse", "u"));
            soapBodyElement.addChildElement("CurrentGreenVideoGain").setTextContent(currentGreenVideoGain.toString());
            return retVal;
        }

    }

    public static class GetHorizontalKeystoneRequest
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
            SOAPMessage retVal = RenderingControl2 .GetHorizontalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetHorizontalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetHorizontalKeystoneResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetHorizontalKeystoneResponse", "u"));
            soapBodyElement.addChildElement("CurrentHorizontalKeystone").setTextContent(currentHorizontalKeystone.toString());
            return retVal;
        }

    }

    public static class GetLoudnessRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;

        
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .GetLoudnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetLoudnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetLoudnessResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetLoudnessResponse", "u"));
            soapBodyElement.addChildElement("CurrentLoudness").setTextContent(currentLoudness.toString());
            return retVal;
        }

    }

    public static class GetMuteRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public RenderingControl2 .Channel channel;

        
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
                    channel = RenderingControl2 .Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .GetMuteRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMuteRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetMuteResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetMuteResponse", "u"));
            soapBodyElement.addChildElement("CurrentMute").setTextContent(currentMute.toString());
            return retVal;
        }

    }

    public static class GetRedVideoBlackLevelRequest
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
            SOAPMessage retVal = RenderingControl2 .GetRedVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetRedVideoBlackLevelResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoBlackLevelResponse", "u"));
            soapBodyElement.addChildElement("CurrentRedVideoBlackLevel").setTextContent(currentRedVideoBlackLevel.toString());
            return retVal;
        }

    }

    public static class GetRedVideoGainRequest
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
            SOAPMessage retVal = RenderingControl2 .GetRedVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetRedVideoGainResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRedVideoGainResponse", "u"));
            soapBodyElement.addChildElement("CurrentRedVideoGain").setTextContent(currentRedVideoGain.toString());
            return retVal;
        }

    }

    public static class GetSharpnessRequest
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
            SOAPMessage retVal = RenderingControl2 .GetSharpnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSharpnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetSharpnessResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSharpnessResponse", "u"));
            soapBodyElement.addChildElement("CurrentSharpness").setTextContent(currentSharpness.toString());
            return retVal;
        }

    }

    public static class GetStateVariablesRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String stateVariableList;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("StateVariableList".equals(name)) {
                    stateVariableList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .GetStateVariablesRequest.createMessage();
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

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("StateVariableValuePairs".equals(name)) {
                    stateVariableValuePairs = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .GetStateVariablesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetStateVariablesResponse", "u"));
            soapBodyElement.addChildElement("StateVariableValuePairs").setTextContent(stateVariableValuePairs.toString());
            return retVal;
        }

    }

    public static class GetVerticalKeystoneRequest
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
            SOAPMessage retVal = RenderingControl2 .GetVerticalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVerticalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetVerticalKeystoneResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVerticalKeystoneResponse", "u"));
            soapBodyElement.addChildElement("CurrentVerticalKeystone").setTextContent(currentVerticalKeystone.toString());
            return retVal;
        }

    }

    public static class GetVolumeDBRangeRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;

        
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .GetVolumeDBRangeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBRangeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetVolumeDBRangeResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBRangeResponse", "u"));
            soapBodyElement.addChildElement("MinValue").setTextContent(minValue.toString());
            soapBodyElement.addChildElement("MaxValue").setTextContent(maxValue.toString());
            return retVal;
        }

    }

    public static class GetVolumeDBRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;

        
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .GetVolumeDBRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetVolumeDBResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeDBResponse", "u"));
            soapBodyElement.addChildElement("CurrentVolume").setTextContent(currentVolume.toString());
            return retVal;
        }

    }

    public static class GetVolumeRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;

        
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .GetVolumeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .GetVolumeResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetVolumeResponse", "u"));
            soapBodyElement.addChildElement("CurrentVolume").setTextContent(currentVolume.toString());
            return retVal;
        }

    }

    public static class ListPresetsRequest
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
            SOAPMessage retVal = RenderingControl2 .ListPresetsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ListPresetsRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .ListPresetsResponse.createMessage();
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

        public int instanceID;
        public RenderingControl2 .PresetName presetName;

        
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
                    presetName = RenderingControl2 .PresetName.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .SelectPresetRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SelectPresetRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SelectPresetResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SelectPresetResponse", "u"));
            return retVal;
        }

    }

    public static class SetBlueVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetBlueVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetBlueVideoBlackLevelResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoBlackLevelResponse", "u"));
            return retVal;
        }

    }

    public static class SetBlueVideoGainRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetBlueVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetBlueVideoGainResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBlueVideoGainResponse", "u"));
            return retVal;
        }

    }

    public static class SetBrightnessRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetBrightnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBrightnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetBrightnessResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetBrightnessResponse", "u"));
            return retVal;
        }

    }

    public static class SetColorTemperatureRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetColorTemperatureRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetColorTemperatureRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetColorTemperatureResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetColorTemperatureResponse", "u"));
            return retVal;
        }

    }

    public static class SetContrastRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetContrastRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetContrastRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetContrastResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetContrastResponse", "u"));
            return retVal;
        }

    }

    public static class SetGreenVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetGreenVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetGreenVideoBlackLevelResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoBlackLevelResponse", "u"));
            return retVal;
        }

    }

    public static class SetGreenVideoGainRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetGreenVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetGreenVideoGainResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetGreenVideoGainResponse", "u"));
            return retVal;
        }

    }

    public static class SetHorizontalKeystoneRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetHorizontalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetHorizontalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetHorizontalKeystoneResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetHorizontalKeystoneResponse", "u"));
            return retVal;
        }

    }

    public static class SetLoudnessRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
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
            SOAPMessage retVal = RenderingControl2 .SetLoudnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetLoudnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetLoudnessResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetLoudnessResponse", "u"));
            return retVal;
        }

    }

    public static class SetMuteRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
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
            SOAPMessage retVal = RenderingControl2 .SetMuteRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetMuteRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetMuteResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetMuteResponse", "u"));
            return retVal;
        }

    }

    public static class SetRedVideoBlackLevelRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetRedVideoBlackLevelRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoBlackLevelRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetRedVideoBlackLevelResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoBlackLevelResponse", "u"));
            return retVal;
        }

    }

    public static class SetRedVideoGainRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetRedVideoGainRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoGainRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetRedVideoGainResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetRedVideoGainResponse", "u"));
            return retVal;
        }

    }

    public static class SetSharpnessRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetSharpnessRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetSharpnessRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetSharpnessResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetSharpnessResponse", "u"));
            return retVal;
        }

    }

    public static class SetStateVariablesRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public String renderingControlUDN;
        public String serviceType;
        public String serviceId;
        public String stateVariableValuePairs;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("InstanceID".equals(name)) {
                    instanceID = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("RenderingControlUDN".equals(name)) {
                    renderingControlUDN = e.getTextContent();
                    continue;
                }
                if ("ServiceType".equals(name)) {
                    serviceType = e.getTextContent();
                    continue;
                }
                if ("ServiceId".equals(name)) {
                    serviceId = e.getTextContent();
                    continue;
                }
                if ("StateVariableValuePairs".equals(name)) {
                    stateVariableValuePairs = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .SetStateVariablesRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetStateVariablesRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
            soapBodyElement.addChildElement("RenderingControlUDN").setTextContent(renderingControlUDN.toString());
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

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("StateVariableList".equals(name)) {
                    stateVariableList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = RenderingControl2 .SetStateVariablesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetStateVariablesResponse", "u"));
            soapBodyElement.addChildElement("StateVariableList").setTextContent(stateVariableList.toString());
            return retVal;
        }

    }

    public static class SetVerticalKeystoneRequest
        extends SOAPSerializable
    {

        public int instanceID;
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
            SOAPMessage retVal = RenderingControl2 .SetVerticalKeystoneRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVerticalKeystoneRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetVerticalKeystoneResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVerticalKeystoneResponse", "u"));
            return retVal;
        }

    }

    public static class SetVolumeDBRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
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
            SOAPMessage retVal = RenderingControl2 .SetVolumeDBRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeDBRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetVolumeDBResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeDBResponse", "u"));
            return retVal;
        }

    }

    public static class SetVolumeRequest
        extends SOAPSerializable
    {

        public int instanceID;
        public org.saintandreas.serket.scpd.RenderingControl2.Channel channel;
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
                    channel = org.saintandreas.serket.scpd.RenderingControl2.Channel.valueOf(e.getTextContent());
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
            SOAPMessage retVal = RenderingControl2 .SetVolumeRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeRequest", "u"));
            soapBodyElement.addChildElement("InstanceID").setTextContent(Integer.toString(instanceID));
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
            SOAPMessage retVal = RenderingControl2 .SetVolumeResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "SetVolumeResponse", "u"));
            return retVal;
        }

    }

}
