
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

public abstract class ContentDirectory3
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:ContentDirectory:3";

    public ContentDirectory3(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract ContentDirectory3 .GetSearchCapabilitiesResponse getSearchCapabilities(ContentDirectory3 .GetSearchCapabilitiesRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .GetSortCapabilitiesResponse getSortCapabilities(ContentDirectory3 .GetSortCapabilitiesRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .GetSortExtensionCapabilitiesResponse getSortExtensionCapabilities(ContentDirectory3 .GetSortExtensionCapabilitiesRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .GetFeatureListResponse getFeatureList(ContentDirectory3 .GetFeatureListRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .GetSystemUpdateIDResponse getSystemUpdateID(ContentDirectory3 .GetSystemUpdateIDRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .GetServiceResetTokenResponse getServiceResetToken(ContentDirectory3 .GetServiceResetTokenRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .BrowseResponse browse(ContentDirectory3 .BrowseRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .SearchResponse search(ContentDirectory3 .SearchRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .CreateObjectResponse createObject(ContentDirectory3 .CreateObjectRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .DestroyObjectResponse destroyObject(ContentDirectory3 .DestroyObjectRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .UpdateObjectResponse updateObject(ContentDirectory3 .UpdateObjectRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .MoveObjectResponse moveObject(ContentDirectory3 .MoveObjectRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .ImportResourceResponse importResource(ContentDirectory3 .ImportResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .ExportResourceResponse exportResource(ContentDirectory3 .ExportResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .DeleteResourceResponse deleteResource(ContentDirectory3 .DeleteResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .StopTransferResourceResponse stopTransferResource(ContentDirectory3 .StopTransferResourceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .GetTransferProgressResponse getTransferProgress(ContentDirectory3 .GetTransferProgressRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .CreateReferenceResponse createReference(ContentDirectory3 .CreateReferenceRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .FreeFormQueryResponse freeFormQuery(ContentDirectory3 .FreeFormQueryRequest input)
        throws IOException, ServletException
    ;

    public abstract ContentDirectory3 .GetFreeFormQueryCapabilitiesResponse getFreeFormQueryCapabilities(ContentDirectory3 .GetFreeFormQueryCapabilitiesRequest input)
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
        public ContentDirectory3 .BrowseFlag browseFlag;
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
                    browseFlag = ContentDirectory3 .BrowseFlag.valueOf(e.getTextContent());
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
            SOAPMessage retVal = ContentDirectory3 .BrowseRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .BrowseResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .CreateObjectRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .CreateObjectResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .CreateReferenceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .CreateReferenceResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .DeleteResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .DeleteResourceResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .DestroyObjectRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .DestroyObjectResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .ExportResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .ExportResourceResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ExportResourceResponse", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static class FreeFormQueryRequest
        extends SOAPSerializable
    {

        public String containerID;
        public Integer cDSView;
        public String queryRequest;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ContainerID".equals(name)) {
                    containerID = e.getTextContent();
                    continue;
                }
                if ("CDSView".equals(name)) {
                    cDSView = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("QueryRequest".equals(name)) {
                    queryRequest = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .FreeFormQueryRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "FreeFormQueryRequest", "u"));
            soapBodyElement.addChildElement("ContainerID").setTextContent(containerID.toString());
            soapBodyElement.addChildElement("CDSView").setTextContent(cDSView.toString());
            soapBodyElement.addChildElement("QueryRequest").setTextContent(queryRequest.toString());
            return retVal;
        }

    }

    public static class FreeFormQueryResponse
        extends SOAPSerializable
    {

        public String queryResult;
        public int updateID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("QueryResult".equals(name)) {
                    queryResult = e.getTextContent();
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
            SOAPMessage retVal = ContentDirectory3 .FreeFormQueryResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "FreeFormQueryResponse", "u"));
            soapBodyElement.addChildElement("QueryResult").setTextContent(queryResult.toString());
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class GetFeatureListRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetFeatureListRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetFeatureListRequest", "u"));
            return retVal;
        }

    }

    public static class GetFeatureListResponse
        extends SOAPSerializable
    {

        public String featureList;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("FeatureList".equals(name)) {
                    featureList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetFeatureListResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetFeatureListResponse", "u"));
            soapBodyElement.addChildElement("FeatureList").setTextContent(featureList.toString());
            return retVal;
        }

    }

    public static class GetFreeFormQueryCapabilitiesRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetFreeFormQueryCapabilitiesRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetFreeFormQueryCapabilitiesRequest", "u"));
            return retVal;
        }

    }

    public static class GetFreeFormQueryCapabilitiesResponse
        extends SOAPSerializable
    {

        public String fFQCapabilities;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("FFQCapabilities".equals(name)) {
                    fFQCapabilities = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetFreeFormQueryCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetFreeFormQueryCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("FFQCapabilities").setTextContent(fFQCapabilities.toString());
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
            SOAPMessage retVal = ContentDirectory3 .GetSearchCapabilitiesRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .GetSearchCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSearchCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SearchCaps").setTextContent(searchCaps.toString());
            return retVal;
        }

    }

    public static class GetServiceResetTokenRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetServiceResetTokenRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetServiceResetTokenRequest", "u"));
            return retVal;
        }

    }

    public static class GetServiceResetTokenResponse
        extends SOAPSerializable
    {

        public String resetToken;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ResetToken".equals(name)) {
                    resetToken = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetServiceResetTokenResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetServiceResetTokenResponse", "u"));
            soapBodyElement.addChildElement("ResetToken").setTextContent(resetToken.toString());
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
            SOAPMessage retVal = ContentDirectory3 .GetSortCapabilitiesRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .GetSortCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SortCaps").setTextContent(sortCaps.toString());
            return retVal;
        }

    }

    public static class GetSortExtensionCapabilitiesRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetSortExtensionCapabilitiesRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortExtensionCapabilitiesRequest", "u"));
            return retVal;
        }

    }

    public static class GetSortExtensionCapabilitiesResponse
        extends SOAPSerializable
    {

        public String sortExtensionCaps;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("SortExtensionCaps".equals(name)) {
                    sortExtensionCaps = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .GetSortExtensionCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortExtensionCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SortExtensionCaps").setTextContent(sortExtensionCaps.toString());
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
            SOAPMessage retVal = ContentDirectory3 .GetSystemUpdateIDRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .GetSystemUpdateIDResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .GetTransferProgressRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransferProgressRequest", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static class GetTransferProgressResponse
        extends SOAPSerializable
    {

        public ContentDirectory3 .TransferStatus transferStatus;
        public String transferLength;
        public String transferTotal;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("TransferStatus".equals(name)) {
                    transferStatus = ContentDirectory3 .TransferStatus.valueOf(e.getTextContent());
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
            SOAPMessage retVal = ContentDirectory3 .GetTransferProgressResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .ImportResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .ImportResourceResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ImportResourceResponse", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static class MoveObjectRequest
        extends SOAPSerializable
    {

        public String objectID;
        public String newParentID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("ObjectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
                if ("NewParentID".equals(name)) {
                    newParentID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .MoveObjectRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "MoveObjectRequest", "u"));
            soapBodyElement.addChildElement("ObjectID").setTextContent(objectID.toString());
            soapBodyElement.addChildElement("NewParentID").setTextContent(newParentID.toString());
            return retVal;
        }

    }

    public static class MoveObjectResponse
        extends SOAPSerializable
    {

        public String newObjectID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("NewObjectID".equals(name)) {
                    newObjectID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory3 .MoveObjectResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "MoveObjectResponse", "u"));
            soapBodyElement.addChildElement("NewObjectID").setTextContent(newObjectID.toString());
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
            SOAPMessage retVal = ContentDirectory3 .SearchRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .SearchResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .StopTransferResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .StopTransferResourceResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .UpdateObjectRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory3 .UpdateObjectResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "UpdateObjectResponse", "u"));
            return retVal;
        }

    }

}
