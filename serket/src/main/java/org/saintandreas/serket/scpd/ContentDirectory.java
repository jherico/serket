
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

public abstract class ContentDirectory
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:ContentDirectory:1";

    public ContentDirectory(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract ContentDirectory.GetSearchCapabilitiesResponse getSearchCapabilities(ContentDirectory.GetSearchCapabilitiesRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.GetSortCapabilitiesResponse getSortCapabilities(ContentDirectory.GetSortCapabilitiesRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.GetSystemUpdateIDResponse getSystemUpdateID(ContentDirectory.GetSystemUpdateIDRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.BrowseResponse browse(ContentDirectory.BrowseRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.SearchResponse search(ContentDirectory.SearchRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.CreateObjectResponse createObject(ContentDirectory.CreateObjectRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.DestroyObjectResponse destroyObject(ContentDirectory.DestroyObjectRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.UpdateObjectResponse updateObject(ContentDirectory.UpdateObjectRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.ImportResourceResponse importResource(ContentDirectory.ImportResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.ExportResourceResponse exportResource(ContentDirectory.ExportResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.StopTransferResourceResponse stopTransferResource(ContentDirectory.StopTransferResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.GetTransferProgressResponse getTransferProgress(ContentDirectory.GetTransferProgressRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.DeleteResourceResponse deleteResource(ContentDirectory.DeleteResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory.CreateReferenceResponse createReference(ContentDirectory.CreateReferenceRequest input)
        throws IOException, ServletException
    ;

    public enum BrowseFlag {

        BrowseMetadata,
        BrowseDirectChildren;

    }

    public static class BrowseRequest
        extends SOAPSerializable
    {

        public String objectID;
        public ContentDirectory.BrowseFlag browseFlag;
        public String filter;
        public int startingIndex;
        public int requestedCount;
        public String sortCriteria;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ObjectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
                if ("BrowseFlag".equals(name)) {
                    browseFlag = ContentDirectory.BrowseFlag.valueOf(e.getTextContent());
                    continue;
                }
                if ("Filter".equals(name)) {
                    filter = e.getTextContent();
                    continue;
                }
                if ("StartingIndex".equals(name)) {
                    startingIndex = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("RequestedCount".equals(name)) {
                    requestedCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("SortCriteria".equals(name)) {
                    sortCriteria = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.BrowseRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "BrowseRequest", "u"));
            soapBodyElement.addChildElement("ObjectID").setTextContent(objectID.toString());
            soapBodyElement.addChildElement("BrowseFlag").setTextContent(browseFlag.toString());
            soapBodyElement.addChildElement("Filter").setTextContent(filter.toString());
            soapBodyElement.addChildElement("StartingIndex").setTextContent(Integer.toString(startingIndex));
            soapBodyElement.addChildElement("RequestedCount").setTextContent(Integer.toString(requestedCount));
            soapBodyElement.addChildElement("SortCriteria").setTextContent(sortCriteria.toString());
            return retVal;
        }

    }

    public static class BrowseResponse
        extends SOAPSerializable
    {

        public String result;
        public int numberReturned;
        public int totalMatches;
        public int updateID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("Result".equals(name)) {
                    result = e.getTextContent();
                    continue;
                }
                if ("NumberReturned".equals(name)) {
                    numberReturned = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("TotalMatches".equals(name)) {
                    totalMatches = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("UpdateID".equals(name)) {
                    updateID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.BrowseResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "BrowseResponse", "u"));
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            soapBodyElement.addChildElement("NumberReturned").setTextContent(Integer.toString(numberReturned));
            soapBodyElement.addChildElement("TotalMatches").setTextContent(Integer.toString(totalMatches));
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class CreateObjectRequest
        extends SOAPSerializable
    {

        public String containerID;
        public String elements;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ContainerID".equals(name)) {
                    containerID = e.getTextContent();
                    continue;
                }
                if ("Elements".equals(name)) {
                    elements = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.CreateObjectRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "CreateObjectRequest", "u"));
            soapBodyElement.addChildElement("ContainerID").setTextContent(containerID.toString());
            soapBodyElement.addChildElement("Elements").setTextContent(elements.toString());
            return retVal;
        }

    }

    public static class CreateObjectResponse
        extends SOAPSerializable
    {

        public String objectID;
        public String result;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ObjectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
                if ("Result".equals(name)) {
                    result = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.CreateObjectResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "CreateObjectResponse", "u"));
            soapBodyElement.addChildElement("ObjectID").setTextContent(objectID.toString());
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            return retVal;
        }

    }

    public static class CreateReferenceRequest
        extends SOAPSerializable
    {

        public String containerID;
        public String objectID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ContainerID".equals(name)) {
                    containerID = e.getTextContent();
                    continue;
                }
                if ("ObjectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.CreateReferenceRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "CreateReferenceRequest", "u"));
            soapBodyElement.addChildElement("ContainerID").setTextContent(containerID.toString());
            soapBodyElement.addChildElement("ObjectID").setTextContent(objectID.toString());
            return retVal;
        }

    }

    public static class CreateReferenceResponse
        extends SOAPSerializable
    {

        public String newID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("NewID".equals(name)) {
                    newID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.CreateReferenceResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "CreateReferenceResponse", "u"));
            soapBodyElement.addChildElement("NewID").setTextContent(newID.toString());
            return retVal;
        }

    }

    public static class DeleteResourceRequest
        extends SOAPSerializable
    {

        public String resourceURI;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ResourceURI".equals(name)) {
                    resourceURI = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.DeleteResourceRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "DeleteResourceRequest", "u"));
            soapBodyElement.addChildElement("ResourceURI").setTextContent(resourceURI.toString());
            return retVal;
        }

    }

    public static class DeleteResourceResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.DeleteResourceResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "DeleteResourceResponse", "u"));
            return retVal;
        }

    }

    public static class DestroyObjectRequest
        extends SOAPSerializable
    {

        public String objectID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ObjectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.DestroyObjectRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "DestroyObjectRequest", "u"));
            soapBodyElement.addChildElement("ObjectID").setTextContent(objectID.toString());
            return retVal;
        }

    }

    public static class DestroyObjectResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.DestroyObjectResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "DestroyObjectResponse", "u"));
            return retVal;
        }

    }

    public static class ExportResourceRequest
        extends SOAPSerializable
    {

        public String sourceURI;
        public String destinationURI;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("SourceURI".equals(name)) {
                    sourceURI = e.getTextContent();
                    continue;
                }
                if ("DestinationURI".equals(name)) {
                    destinationURI = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.ExportResourceRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ExportResourceRequest", "u"));
            soapBodyElement.addChildElement("SourceURI").setTextContent(sourceURI.toString());
            soapBodyElement.addChildElement("DestinationURI").setTextContent(destinationURI.toString());
            return retVal;
        }

    }

    public static class ExportResourceResponse
        extends SOAPSerializable
    {

        public Integer transferID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("TransferID".equals(name)) {
                    transferID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.ExportResourceResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ExportResourceResponse", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static class GetSearchCapabilitiesRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetSearchCapabilitiesRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSearchCapabilitiesRequest", "u"));
            return retVal;
        }

    }

    public static class GetSearchCapabilitiesResponse
        extends SOAPSerializable
    {

        public String searchCaps;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("SearchCaps".equals(name)) {
                    searchCaps = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetSearchCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSearchCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SearchCaps").setTextContent(searchCaps.toString());
            return retVal;
        }

    }

    public static class GetSortCapabilitiesRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetSortCapabilitiesRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortCapabilitiesRequest", "u"));
            return retVal;
        }

    }

    public static class GetSortCapabilitiesResponse
        extends SOAPSerializable
    {

        public String sortCaps;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("SortCaps".equals(name)) {
                    sortCaps = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetSortCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SortCaps").setTextContent(sortCaps.toString());
            return retVal;
        }

    }

    public static class GetSystemUpdateIDRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetSystemUpdateIDRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSystemUpdateIDRequest", "u"));
            return retVal;
        }

    }

    public static class GetSystemUpdateIDResponse
        extends SOAPSerializable
    {

        public int id;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("Id".equals(name)) {
                    id = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetSystemUpdateIDResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSystemUpdateIDResponse", "u"));
            soapBodyElement.addChildElement("Id").setTextContent(Integer.toString(id));
            return retVal;
        }

    }

    public static class GetTransferProgressRequest
        extends SOAPSerializable
    {

        public Integer transferID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("TransferID".equals(name)) {
                    transferID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetTransferProgressRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransferProgressRequest", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static class GetTransferProgressResponse
        extends SOAPSerializable
    {

        public ContentDirectory.TransferStatus transferStatus;
        public String transferLength;
        public String transferTotal;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("TransferStatus".equals(name)) {
                    transferStatus = ContentDirectory.TransferStatus.valueOf(e.getTextContent());
                    continue;
                }
                if ("TransferLength".equals(name)) {
                    transferLength = e.getTextContent();
                    continue;
                }
                if ("TransferTotal".equals(name)) {
                    transferTotal = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.GetTransferProgressResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransferProgressResponse", "u"));
            soapBodyElement.addChildElement("TransferStatus").setTextContent(transferStatus.toString());
            soapBodyElement.addChildElement("TransferLength").setTextContent(transferLength.toString());
            soapBodyElement.addChildElement("TransferTotal").setTextContent(transferTotal.toString());
            return retVal;
        }

    }

    public static class ImportResourceRequest
        extends SOAPSerializable
    {

        public String sourceURI;
        public String destinationURI;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("SourceURI".equals(name)) {
                    sourceURI = e.getTextContent();
                    continue;
                }
                if ("DestinationURI".equals(name)) {
                    destinationURI = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.ImportResourceRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ImportResourceRequest", "u"));
            soapBodyElement.addChildElement("SourceURI").setTextContent(sourceURI.toString());
            soapBodyElement.addChildElement("DestinationURI").setTextContent(destinationURI.toString());
            return retVal;
        }

    }

    public static class ImportResourceResponse
        extends SOAPSerializable
    {

        public Integer transferID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("TransferID".equals(name)) {
                    transferID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.ImportResourceResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ImportResourceResponse", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static class SearchRequest
        extends SOAPSerializable
    {

        public String containerID;
        public String searchCriteria;
        public String filter;
        public int startingIndex;
        public int requestedCount;
        public String sortCriteria;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ContainerID".equals(name)) {
                    containerID = e.getTextContent();
                    continue;
                }
                if ("SearchCriteria".equals(name)) {
                    searchCriteria = e.getTextContent();
                    continue;
                }
                if ("Filter".equals(name)) {
                    filter = e.getTextContent();
                    continue;
                }
                if ("StartingIndex".equals(name)) {
                    startingIndex = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("RequestedCount".equals(name)) {
                    requestedCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("SortCriteria".equals(name)) {
                    sortCriteria = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.SearchRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SearchRequest", "u"));
            soapBodyElement.addChildElement("ContainerID").setTextContent(containerID.toString());
            soapBodyElement.addChildElement("SearchCriteria").setTextContent(searchCriteria.toString());
            soapBodyElement.addChildElement("Filter").setTextContent(filter.toString());
            soapBodyElement.addChildElement("StartingIndex").setTextContent(Integer.toString(startingIndex));
            soapBodyElement.addChildElement("RequestedCount").setTextContent(Integer.toString(requestedCount));
            soapBodyElement.addChildElement("SortCriteria").setTextContent(sortCriteria.toString());
            return retVal;
        }

    }

    public static class SearchResponse
        extends SOAPSerializable
    {

        public String result;
        public int numberReturned;
        public int totalMatches;
        public int updateID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("Result".equals(name)) {
                    result = e.getTextContent();
                    continue;
                }
                if ("NumberReturned".equals(name)) {
                    numberReturned = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("TotalMatches".equals(name)) {
                    totalMatches = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("UpdateID".equals(name)) {
                    updateID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.SearchResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "SearchResponse", "u"));
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            soapBodyElement.addChildElement("NumberReturned").setTextContent(Integer.toString(numberReturned));
            soapBodyElement.addChildElement("TotalMatches").setTextContent(Integer.toString(totalMatches));
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class StopTransferResourceRequest
        extends SOAPSerializable
    {

        public Integer transferID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("TransferID".equals(name)) {
                    transferID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.StopTransferResourceRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "StopTransferResourceRequest", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static class StopTransferResourceResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.StopTransferResourceResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "StopTransferResourceResponse", "u"));
            return retVal;
        }

    }

    public enum TransferStatus {

        COMPLETED,
        ERROR,
        IN_PROGRESS,
        STOPPED;

    }

    public static class UpdateObjectRequest
        extends SOAPSerializable
    {

        public String objectID;
        public String currentTagValue;
        public String newTagValue;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ObjectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
                if ("CurrentTagValue".equals(name)) {
                    currentTagValue = e.getTextContent();
                    continue;
                }
                if ("NewTagValue".equals(name)) {
                    newTagValue = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.UpdateObjectRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "UpdateObjectRequest", "u"));
            soapBodyElement.addChildElement("ObjectID").setTextContent(objectID.toString());
            soapBodyElement.addChildElement("CurrentTagValue").setTextContent(currentTagValue.toString());
            soapBodyElement.addChildElement("NewTagValue").setTextContent(newTagValue.toString());
            return retVal;
        }

    }

    public static class UpdateObjectResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory.UpdateObjectResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "UpdateObjectResponse", "u"));
            return retVal;
        }

    }

}
