
package org.saintandreas.serket.scpd;

import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.saintandreas.serket.soap.SOAPSerializable;
import org.w3c.dom.Element;

public interface ContentDirectory {

    public final static String URI = "urn:schemas-upnp-org:service:ContentDirectory:1";

    public ContentDirectory.GetSearchCapabilitiesResponse getSearchCapabilities(ContentDirectory.GetSearchCapabilitiesRequest input);

    public ContentDirectory.GetSortCapabilitiesResponse getSortCapabilities(ContentDirectory.GetSortCapabilitiesRequest input);

    public ContentDirectory.GetSystemUpdateIDResponse getSystemUpdateID(ContentDirectory.GetSystemUpdateIDRequest input);

    public ContentDirectory.BrowseResponse browse(ContentDirectory.BrowseRequest input);

    public ContentDirectory.SearchResponse search(ContentDirectory.SearchRequest input);

    public ContentDirectory.CreateObjectResponse createObject(ContentDirectory.CreateObjectRequest input);

    public ContentDirectory.DestroyObjectResponse destroyObject(ContentDirectory.DestroyObjectRequest input);

    public ContentDirectory.UpdateObjectResponse updateObject(ContentDirectory.UpdateObjectRequest input);

    public ContentDirectory.ImportResourceResponse importResource(ContentDirectory.ImportResourceRequest input);

    public ContentDirectory.ExportResourceResponse exportResource(ContentDirectory.ExportResourceRequest input);

    public ContentDirectory.StopTransferResourceResponse stopTransferResource(ContentDirectory.StopTransferResourceRequest input);

    public ContentDirectory.GetTransferProgressResponse getTransferProgress(ContentDirectory.GetTransferProgressRequest input);

    public ContentDirectory.DeleteResourceResponse deleteResource(ContentDirectory.DeleteResourceRequest input);

    public ContentDirectory.CreateReferenceResponse createReference(ContentDirectory.CreateReferenceRequest input);

    public enum BrowseFlag {

        BrowseMetadata,
        BrowseDirectChildren;

    }

    public static abstract class BrowseRequest
        extends SOAPSerializable
    {

        public String objectID;
        public ContentDirectory.BrowseFlag browseFlag;
        public String filter;
        public int startingIndex;
        public int requestedCount;
        public String sortCriteria;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("objectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
                if ("browseFlag".equals(name)) {
                    browseFlag = ContentDirectory.BrowseFlag.valueOf(e.getTextContent());
                    continue;
                }
                if ("filter".equals(name)) {
                    filter = e.getTextContent();
                    continue;
                }
                if ("startingIndex".equals(name)) {
                    startingIndex = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("requestedCount".equals(name)) {
                    requestedCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("sortCriteria".equals(name)) {
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

    public static abstract class BrowseResponse
        extends SOAPSerializable
    {

        public String result;
        public int numberReturned;
        public int totalMatches;
        public int updateID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("result".equals(name)) {
                    result = e.getTextContent();
                    continue;
                }
                if ("numberReturned".equals(name)) {
                    numberReturned = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("totalMatches".equals(name)) {
                    totalMatches = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("updateID".equals(name)) {
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

    public static abstract class CreateObjectRequest
        extends SOAPSerializable
    {

        public String containerID;
        public String elements;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("containerID".equals(name)) {
                    containerID = e.getTextContent();
                    continue;
                }
                if ("elements".equals(name)) {
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

    public static abstract class CreateObjectResponse
        extends SOAPSerializable
    {

        public String objectID;
        public String result;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("objectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
                if ("result".equals(name)) {
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

    public static abstract class CreateReferenceRequest
        extends SOAPSerializable
    {

        public String containerID;
        public String objectID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("containerID".equals(name)) {
                    containerID = e.getTextContent();
                    continue;
                }
                if ("objectID".equals(name)) {
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

    public static abstract class CreateReferenceResponse
        extends SOAPSerializable
    {

        public String newID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("newID".equals(name)) {
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

    public static abstract class DeleteResourceRequest
        extends SOAPSerializable
    {

        public String resourceURI;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("resourceURI".equals(name)) {
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

    public static abstract class DeleteResourceResponse
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

    public static abstract class DestroyObjectRequest
        extends SOAPSerializable
    {

        public String objectID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("objectID".equals(name)) {
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

    public static abstract class DestroyObjectResponse
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

    public static abstract class ExportResourceRequest
        extends SOAPSerializable
    {

        public String sourceURI;
        public String destinationURI;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("sourceURI".equals(name)) {
                    sourceURI = e.getTextContent();
                    continue;
                }
                if ("destinationURI".equals(name)) {
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

    public static abstract class ExportResourceResponse
        extends SOAPSerializable
    {

        public Integer transferID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("transferID".equals(name)) {
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

    public static abstract class GetSearchCapabilitiesRequest
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

    public static abstract class GetSearchCapabilitiesResponse
        extends SOAPSerializable
    {

        public String searchCaps;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("searchCaps".equals(name)) {
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

    public static abstract class GetSortCapabilitiesRequest
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

    public static abstract class GetSortCapabilitiesResponse
        extends SOAPSerializable
    {

        public String sortCaps;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("sortCaps".equals(name)) {
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

    public static abstract class GetSystemUpdateIDRequest
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

    public static abstract class GetSystemUpdateIDResponse
        extends SOAPSerializable
    {

        public int id;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("id".equals(name)) {
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

    public static abstract class GetTransferProgressRequest
        extends SOAPSerializable
    {

        public Integer transferID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("transferID".equals(name)) {
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

    public static abstract class GetTransferProgressResponse
        extends SOAPSerializable
    {

        public ContentDirectory.TransferStatus transferStatus;
        public String transferLength;
        public String transferTotal;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("transferStatus".equals(name)) {
                    transferStatus = ContentDirectory.TransferStatus.valueOf(e.getTextContent());
                    continue;
                }
                if ("transferLength".equals(name)) {
                    transferLength = e.getTextContent();
                    continue;
                }
                if ("transferTotal".equals(name)) {
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

    public static abstract class ImportResourceRequest
        extends SOAPSerializable
    {

        public String sourceURI;
        public String destinationURI;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("sourceURI".equals(name)) {
                    sourceURI = e.getTextContent();
                    continue;
                }
                if ("destinationURI".equals(name)) {
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

    public static abstract class ImportResourceResponse
        extends SOAPSerializable
    {

        public Integer transferID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("transferID".equals(name)) {
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

    public static abstract class SearchRequest
        extends SOAPSerializable
    {

        public String containerID;
        public String searchCriteria;
        public String filter;
        public int startingIndex;
        public int requestedCount;
        public String sortCriteria;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("containerID".equals(name)) {
                    containerID = e.getTextContent();
                    continue;
                }
                if ("searchCriteria".equals(name)) {
                    searchCriteria = e.getTextContent();
                    continue;
                }
                if ("filter".equals(name)) {
                    filter = e.getTextContent();
                    continue;
                }
                if ("startingIndex".equals(name)) {
                    startingIndex = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("requestedCount".equals(name)) {
                    requestedCount = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("sortCriteria".equals(name)) {
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

    public static abstract class SearchResponse
        extends SOAPSerializable
    {

        public String result;
        public int numberReturned;
        public int totalMatches;
        public int updateID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("result".equals(name)) {
                    result = e.getTextContent();
                    continue;
                }
                if ("numberReturned".equals(name)) {
                    numberReturned = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("totalMatches".equals(name)) {
                    totalMatches = Integer.valueOf(e.getTextContent());
                    continue;
                }
                if ("updateID".equals(name)) {
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

    public static abstract class StopTransferResourceRequest
        extends SOAPSerializable
    {

        public Integer transferID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("transferID".equals(name)) {
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

    public static abstract class StopTransferResourceResponse
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

    public static abstract class UpdateObjectRequest
        extends SOAPSerializable
    {

        public String objectID;
        public String currentTagValue;
        public String newTagValue;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("objectID".equals(name)) {
                    objectID = e.getTextContent();
                    continue;
                }
                if ("currentTagValue".equals(name)) {
                    currentTagValue = e.getTextContent();
                    continue;
                }
                if ("newTagValue".equals(name)) {
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

    public static abstract class UpdateObjectResponse
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