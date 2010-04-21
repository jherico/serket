package org.saintandreas.serket.didl.types;

import java.net.URI;

import org.saintandreas.serket.didl.annotations.DIDLAttribute;
import org.saintandreas.serket.didl.annotations.DIDLElement;
import org.saintandreas.serket.didl.annotations.DIDLText;

@DIDLElement("res")
public interface Resource {
//    <res protocolInfo="http-get:*:video/mp4:DLNA.ORG_OP=01" size="592528474"
//        duration="02:32:59.620" resolution="480x202" bitrate="66048"
//        nrAudioChannels="2" sampleFrequency="48000">http://172.21.136.219:5001/get/0$0$3/Inglourious+Basterds.avi
//      </res>

    @DIDLText
    public String getText();

    @DIDLAttribute(value = "protocolInfo", required=true)
    public String getProtocolInfo();

    @DIDLAttribute(value = "importUri")
    public URI getImportURI();

    @DIDLAttribute(value = "size")
    public Long getSize();

    @DIDLAttribute(value = "duration")
    public String getDuration();

    @DIDLAttribute(value = "protection")
    public String getProtection();

    @DIDLAttribute(value = "bitrate")
    public Long getBitrate();

    @DIDLAttribute(value = "bitsPerSample")
    public Long getBitsPerSample();

    @DIDLAttribute(value = "sampleFrequency")
    public Long getSampleFrequency();

    @DIDLAttribute(value = "nrAudioChannels")
    public Long getNrAudioChannels();

    @DIDLAttribute(value = "resolution")
    public String getResolution();

    @DIDLAttribute(value = "colorDepth")
    public Long getColorDepth();

    @DIDLAttribute(value = "tspec")
    public String getTspec();

    @DIDLAttribute(value = "allowedUse")
    public String getAllowedUse();

    @DIDLAttribute(value = "validityStart")
    public String getValidityStart();

    @DIDLAttribute(value = "validityEnd")
    public String getValidityEnd();

    @DIDLAttribute(value = "remainingTime")
    public String getRemainingTime();

    @DIDLAttribute(value = "usageInfo")
    public String getUsageInfo();

    @DIDLAttribute(value = "rightsInfoURI")
    public URI getRightsInfoURI();

    @DIDLAttribute(value = "contentInfoURI")
    public URI getContentInfoURI();

    @DIDLAttribute(value = "recordQuality")
    public String getRecordQuality();

    @DIDLAttribute(value = "daylightSaving")
    public String getDaylightSaving();
}
