
package org.saintandreas.serket.scpd;

import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.saintandreas.serket.soap.SOAPSerializable;
import org.w3c.dom.Element;

public interface ContentDirectory2 {

    public final static String URI = "urn:schemas-upnp-org:service:ContentDirectory:2";

    public ContentDirectory2 .GetSearchCapabilitiesResponse getSearchCapabilities(ContentDirectory2 .GetSearchCapabilitiesRequest input);

    public ContentDirectory2 .GetSortCapabilitiesResponse getSortCapabilities(ContentDirectory2 .GetSortCapabilitiesRequest input);

    public ContentDirectory2 .GetSortExtensionCapabilitiesResponse getSortExtensionCapabilities(ContentDirectory2 .GetSortExtensionCapabilitiesRequest input);

    public ContentDirectory2 .GetFeatureListResponse getFeatureList(ContentDirectory2 .GetFeatureListRequest input);

    public ContentDirectory2 .GetSystemUpdateIDResponse getSystemUpdateID(ContentDirectory2 .GetSystemUpdateIDRequest input);

    public ContentDirectory2 .BrowseResponse browse(ContentDirectory2 .BrowseRequest input);

    public ContentDirectory2 .SearchResponse search(ContentDirectory2 .SearchRequest input);

    public ContentDirectory2 .CreateObjectResponse createObject(ContentDirectory2 .CreateObjectRequest input);

    public ContentDirectory2 .DestroyObjectResponse destroyObject(ContentDirectory2 .DestroyObjectRequest input);

    public ContentDirectory2 .UpdateObjectResponse updateObject(ContentDirectory2 .UpdateObjectRequest input);

    public ContentDirectory2 .MoveObjectResponse moveObject(ContentDirectory2 .MoveObjectRequest input);

    public ContentDirectory2 .ImportResourceResponse importResource(ContentDirectory2 .ImportResourceRequest input);

    public ContentDirectory2 .ExportResourceResponse exportResource(ContentDirectory2 .ExportResourceRequest input);

    public ContentDirectory2 .DeleteResourceResponse deleteResource(ContentDirectory2 .DeleteResourceRequest input);

    public ContentDirectory2 .StopTransferResourceResponse stopTransferResource(ContentDirectory2 .StopTransferResourceRequest input);

    public ContentDirectory2 .GetTransferProgressResponse getTransferProgress(ContentDirectory2 .GetTransferProgressRequest input);

    public ContentDirectory2 .CreateReferenceResponse createReference(ContentDirectory2 .CreateReferenceRequest input);

    public enum BrowseFlag {

        BrowseMetadata,
        BrowseDirectChildren;

    }

    public static abstract class BrowseRequest
        extends SOAPSerializable
    {

        public String objectID;
        public BrowseFlag browseFlag;
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
                    browseFlag = ContentDirectory2 .BrowseFlag.valueOf(e.getTextContent());
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
            SOAPMessage retVal = ContentDirectory2 .BrowseRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .BrowseResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .CreateObjectRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .CreateObjectResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .CreateReferenceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .CreateReferenceResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .DeleteResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .DeleteResourceResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .DestroyObjectRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .DestroyObjectResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .ExportResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .ExportResourceResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ExportResourceResponse", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static abstract class GetFeatureListRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory2 .GetFeatureListRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetFeatureListRequest", "u"));
            return retVal;
        }

    }

    public static abstract class GetFeatureListResponse
        extends SOAPSerializable
    {

        public String featureList;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("featureList".equals(name)) {
                    featureList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory2 .GetFeatureListResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetFeatureListResponse", "u"));
            soapBodyElement.addChildElement("FeatureList").setTextContent(featureList.toString());
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
            SOAPMessage retVal = ContentDirectory2 .GetSearchCapabilitiesRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .GetSearchCapabilitiesResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .GetSortCapabilitiesRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .GetSortCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SortCaps").setTextContent(sortCaps.toString());
            return retVal;
        }

    }

    public static abstract class GetSortExtensionCapabilitiesRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory2 .GetSortExtensionCapabilitiesRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortExtensionCapabilitiesRequest", "u"));
            return retVal;
        }

    }

    public static abstract class GetSortExtensionCapabilitiesResponse
        extends SOAPSerializable
    {

        public String sortExtensionCaps;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("sortExtensionCaps".equals(name)) {
                    sortExtensionCaps = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory2 .GetSortExtensionCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortExtensionCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SortExtensionCaps").setTextContent(sortExtensionCaps.toString());
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
            SOAPMessage retVal = ContentDirectory2 .GetSystemUpdateIDRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .GetSystemUpdateIDResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .GetTransferProgressRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetTransferProgressRequest", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static abstract class GetTransferProgressResponse
        extends SOAPSerializable
    {

        public ContentDirectory2 .TransferStatus transferStatus;
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
                    transferStatus = ContentDirectory2 .TransferStatus.valueOf(e.getTextContent());
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
            SOAPMessage retVal = ContentDirectory2 .GetTransferProgressResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .ImportResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .ImportResourceResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ImportResourceResponse", "u"));
            soapBodyElement.addChildElement("TransferID").setTextContent(transferID.toString());
            return retVal;
        }

    }

    public static abstract class MoveObjectRequest
        extends SOAPSerializable
    {

        public String objectID;
        public String newParentID;

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
                if ("newParentID".equals(name)) {
                    newParentID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory2 .MoveObjectRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "MoveObjectRequest", "u"));
            soapBodyElement.addChildElement("ObjectID").setTextContent(objectID.toString());
            soapBodyElement.addChildElement("NewParentID").setTextContent(newParentID.toString());
            return retVal;
        }

    }

    public static abstract class MoveObjectResponse
        extends SOAPSerializable
    {

        public String newObjectID;

        @SuppressWarnings("unchecked")
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            Iterator itr = soapMessage.getSOAPBody().getChildElements();
            for (; itr.hasNext(); ) {
                Element e = ((Element) itr.next());
                String name = e.getNodeName();
                if ("newObjectID".equals(name)) {
                    newObjectID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ContentDirectory2 .MoveObjectResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "MoveObjectResponse", "u"));
            soapBodyElement.addChildElement("NewObjectID").setTextContent(newObjectID.toString());
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
            SOAPMessage retVal = ContentDirectory2 .SearchRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .SearchResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .StopTransferResourceRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .StopTransferResourceResponse.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .UpdateObjectRequest.createMessage();
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
            SOAPMessage retVal = ContentDirectory2 .UpdateObjectResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "UpdateObjectResponse", "u"));
            return retVal;
        }

    }
}