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

public abstract class ScheduledRecording
    extends BaseService
{

    public final static String URI = "urn:schemas-upnp-org:service:ScheduledRecording:1";

    public ScheduledRecording(String id, String controlURL, String eventURL) {
        super(id, controlURL, eventURL);
    }

    public String getURI() {
        return URI;
    }

    public abstract ScheduledRecording.GetSortCapabilitiesResponse getSortCapabilities(ScheduledRecording.GetSortCapabilitiesRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.GetPropertyListResponse getPropertyList(ScheduledRecording.GetPropertyListRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.GetAllowedValuesResponse getAllowedValues(ScheduledRecording.GetAllowedValuesRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.GetStateUpdateIDResponse getStateUpdateID(ScheduledRecording.GetStateUpdateIDRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.BrowseRecordSchedulesResponse browseRecordSchedules(ScheduledRecording.BrowseRecordSchedulesRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.BrowseRecordTasksResponse browseRecordTasks(ScheduledRecording.BrowseRecordTasksRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.CreateRecordScheduleResponse createRecordSchedule(ScheduledRecording.CreateRecordScheduleRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.DeleteRecordScheduleResponse deleteRecordSchedule(ScheduledRecording.DeleteRecordScheduleRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.GetRecordScheduleResponse getRecordSchedule(ScheduledRecording.GetRecordScheduleRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.EnableRecordScheduleResponse enableRecordSchedule(ScheduledRecording.EnableRecordScheduleRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.DisableRecordScheduleResponse disableRecordSchedule(ScheduledRecording.DisableRecordScheduleRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.DeleteRecordTaskResponse deleteRecordTask(ScheduledRecording.DeleteRecordTaskRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.GetRecordTaskResponse getRecordTask(ScheduledRecording.GetRecordTaskRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.EnableRecordTaskResponse enableRecordTask(ScheduledRecording.EnableRecordTaskRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.DisableRecordTaskResponse disableRecordTask(ScheduledRecording.DisableRecordTaskRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.ResetRecordTaskResponse resetRecordTask(ScheduledRecording.ResetRecordTaskRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.GetRecordScheduleConflictsResponse getRecordScheduleConflicts(ScheduledRecording.GetRecordScheduleConflictsRequest input)
        throws IOException, ServletException
    ;

    public abstract ScheduledRecording.GetRecordTaskConflictsResponse getRecordTaskConflicts(ScheduledRecording.GetRecordTaskConflictsRequest input)
        throws IOException, ServletException
    ;

    public static class BrowseRecordSchedulesRequest
        extends SOAPSerializable
    {

        public String filter;
        public int startingIndex;
        public int requestedCount;
        public String sortCriteria;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
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
            SOAPMessage retVal = ScheduledRecording.BrowseRecordSchedulesRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "BrowseRecordSchedulesRequest", "u"));
            soapBodyElement.addChildElement("Filter").setTextContent(filter.toString());
            soapBodyElement.addChildElement("StartingIndex").setTextContent(Integer.toString(startingIndex));
            soapBodyElement.addChildElement("RequestedCount").setTextContent(Integer.toString(requestedCount));
            soapBodyElement.addChildElement("SortCriteria").setTextContent(sortCriteria.toString());
            return retVal;
        }

    }

    public static class BrowseRecordSchedulesResponse
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
            SOAPMessage retVal = ScheduledRecording.BrowseRecordSchedulesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "BrowseRecordSchedulesResponse", "u"));
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            soapBodyElement.addChildElement("NumberReturned").setTextContent(Integer.toString(numberReturned));
            soapBodyElement.addChildElement("TotalMatches").setTextContent(Integer.toString(totalMatches));
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class BrowseRecordTasksRequest
        extends SOAPSerializable
    {

        public String recordScheduleID;
        public String filter;
        public int startingIndex;
        public int requestedCount;
        public String sortCriteria;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleID".equals(name)) {
                    recordScheduleID = e.getTextContent();
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
            SOAPMessage retVal = ScheduledRecording.BrowseRecordTasksRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "BrowseRecordTasksRequest", "u"));
            soapBodyElement.addChildElement("RecordScheduleID").setTextContent(recordScheduleID.toString());
            soapBodyElement.addChildElement("Filter").setTextContent(filter.toString());
            soapBodyElement.addChildElement("StartingIndex").setTextContent(Integer.toString(startingIndex));
            soapBodyElement.addChildElement("RequestedCount").setTextContent(Integer.toString(requestedCount));
            soapBodyElement.addChildElement("SortCriteria").setTextContent(sortCriteria.toString());
            return retVal;
        }

    }

    public static class BrowseRecordTasksResponse
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
            SOAPMessage retVal = ScheduledRecording.BrowseRecordTasksResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "BrowseRecordTasksResponse", "u"));
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            soapBodyElement.addChildElement("NumberReturned").setTextContent(Integer.toString(numberReturned));
            soapBodyElement.addChildElement("TotalMatches").setTextContent(Integer.toString(totalMatches));
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class CreateRecordScheduleRequest
        extends SOAPSerializable
    {

        public String elements;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("Elements".equals(name)) {
                    elements = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.CreateRecordScheduleRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "CreateRecordScheduleRequest", "u"));
            soapBodyElement.addChildElement("Elements").setTextContent(elements.toString());
            return retVal;
        }

    }

    public static class CreateRecordScheduleResponse
        extends SOAPSerializable
    {

        public String recordScheduleID;
        public String result;
        public int updateID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleID".equals(name)) {
                    recordScheduleID = e.getTextContent();
                    continue;
                }
                if ("Result".equals(name)) {
                    result = e.getTextContent();
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
            SOAPMessage retVal = ScheduledRecording.CreateRecordScheduleResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "CreateRecordScheduleResponse", "u"));
            soapBodyElement.addChildElement("RecordScheduleID").setTextContent(recordScheduleID.toString());
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public enum DataTypeID {

        A_ARG_TYPE_RecordSchedule,
        A_ARG_TYPE_RecordTask,
        A_ARG_TYPE_RecordScheduleParts;

    }

    public static class DeleteRecordScheduleRequest
        extends SOAPSerializable
    {

        public String recordScheduleID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleID".equals(name)) {
                    recordScheduleID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DeleteRecordScheduleRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "DeleteRecordScheduleRequest", "u"));
            soapBodyElement.addChildElement("RecordScheduleID").setTextContent(recordScheduleID.toString());
            return retVal;
        }

    }

    public static class DeleteRecordScheduleResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DeleteRecordScheduleResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "DeleteRecordScheduleResponse", "u"));
            return retVal;
        }

    }

    public static class DeleteRecordTaskRequest
        extends SOAPSerializable
    {

        public String recordTaskID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordTaskID".equals(name)) {
                    recordTaskID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DeleteRecordTaskRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "DeleteRecordTaskRequest", "u"));
            soapBodyElement.addChildElement("RecordTaskID").setTextContent(recordTaskID.toString());
            return retVal;
        }

    }

    public static class DeleteRecordTaskResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DeleteRecordTaskResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "DeleteRecordTaskResponse", "u"));
            return retVal;
        }

    }

    public static class DisableRecordScheduleRequest
        extends SOAPSerializable
    {

        public String recordScheduleID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleID".equals(name)) {
                    recordScheduleID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DisableRecordScheduleRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "DisableRecordScheduleRequest", "u"));
            soapBodyElement.addChildElement("RecordScheduleID").setTextContent(recordScheduleID.toString());
            return retVal;
        }

    }

    public static class DisableRecordScheduleResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DisableRecordScheduleResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "DisableRecordScheduleResponse", "u"));
            return retVal;
        }

    }

    public static class DisableRecordTaskRequest
        extends SOAPSerializable
    {

        public String recordTaskID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordTaskID".equals(name)) {
                    recordTaskID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DisableRecordTaskRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "DisableRecordTaskRequest", "u"));
            soapBodyElement.addChildElement("RecordTaskID").setTextContent(recordTaskID.toString());
            return retVal;
        }

    }

    public static class DisableRecordTaskResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.DisableRecordTaskResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "DisableRecordTaskResponse", "u"));
            return retVal;
        }

    }

    public static class EnableRecordScheduleRequest
        extends SOAPSerializable
    {

        public String recordScheduleID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleID".equals(name)) {
                    recordScheduleID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.EnableRecordScheduleRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "EnableRecordScheduleRequest", "u"));
            soapBodyElement.addChildElement("RecordScheduleID").setTextContent(recordScheduleID.toString());
            return retVal;
        }

    }

    public static class EnableRecordScheduleResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.EnableRecordScheduleResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "EnableRecordScheduleResponse", "u"));
            return retVal;
        }

    }

    public static class EnableRecordTaskRequest
        extends SOAPSerializable
    {

        public String recordTaskID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordTaskID".equals(name)) {
                    recordTaskID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.EnableRecordTaskRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "EnableRecordTaskRequest", "u"));
            soapBodyElement.addChildElement("RecordTaskID").setTextContent(recordTaskID.toString());
            return retVal;
        }

    }

    public static class EnableRecordTaskResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.EnableRecordTaskResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "EnableRecordTaskResponse", "u"));
            return retVal;
        }

    }

    public static class GetAllowedValuesRequest
        extends SOAPSerializable
    {

        public org.saintandreas.serket.scpd.ScheduledRecording.DataTypeID dataTypeID;
        public String filter;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("DataTypeID".equals(name)) {
                    dataTypeID = org.saintandreas.serket.scpd.ScheduledRecording.DataTypeID.valueOf(e.getTextContent());
                    continue;
                }
                if ("Filter".equals(name)) {
                    filter = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetAllowedValuesRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetAllowedValuesRequest", "u"));
            soapBodyElement.addChildElement("DataTypeID").setTextContent(dataTypeID.toString());
            soapBodyElement.addChildElement("Filter").setTextContent(filter.toString());
            return retVal;
        }

    }

    public static class GetAllowedValuesResponse
        extends SOAPSerializable
    {

        public String propertyInfo;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("PropertyInfo".equals(name)) {
                    propertyInfo = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetAllowedValuesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetAllowedValuesResponse", "u"));
            soapBodyElement.addChildElement("PropertyInfo").setTextContent(propertyInfo.toString());
            return retVal;
        }

    }

    public static class GetPropertyListRequest
        extends SOAPSerializable
    {

        public ScheduledRecording.DataTypeID dataTypeID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("DataTypeID".equals(name)) {
                    dataTypeID = ScheduledRecording.DataTypeID.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetPropertyListRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetPropertyListRequest", "u"));
            soapBodyElement.addChildElement("DataTypeID").setTextContent(dataTypeID.toString());
            return retVal;
        }

    }

    public static class GetPropertyListResponse
        extends SOAPSerializable
    {

        public String propertyList;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("PropertyList".equals(name)) {
                    propertyList = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetPropertyListResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetPropertyListResponse", "u"));
            soapBodyElement.addChildElement("PropertyList").setTextContent(propertyList.toString());
            return retVal;
        }

    }

    public static class GetRecordScheduleConflictsRequest
        extends SOAPSerializable
    {

        public String recordScheduleID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleID".equals(name)) {
                    recordScheduleID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetRecordScheduleConflictsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordScheduleConflictsRequest", "u"));
            soapBodyElement.addChildElement("RecordScheduleID").setTextContent(recordScheduleID.toString());
            return retVal;
        }

    }

    public static class GetRecordScheduleConflictsResponse
        extends SOAPSerializable
    {

        public String recordScheduleConflictIDList;
        public int updateID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleConflictIDList".equals(name)) {
                    recordScheduleConflictIDList = e.getTextContent();
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
            SOAPMessage retVal = ScheduledRecording.GetRecordScheduleConflictsResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordScheduleConflictsResponse", "u"));
            soapBodyElement.addChildElement("RecordScheduleConflictIDList").setTextContent(recordScheduleConflictIDList.toString());
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class GetRecordScheduleRequest
        extends SOAPSerializable
    {

        public String recordScheduleID;
        public String filter;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordScheduleID".equals(name)) {
                    recordScheduleID = e.getTextContent();
                    continue;
                }
                if ("Filter".equals(name)) {
                    filter = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetRecordScheduleRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordScheduleRequest", "u"));
            soapBodyElement.addChildElement("RecordScheduleID").setTextContent(recordScheduleID.toString());
            soapBodyElement.addChildElement("Filter").setTextContent(filter.toString());
            return retVal;
        }

    }

    public static class GetRecordScheduleResponse
        extends SOAPSerializable
    {

        public String result;
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
                if ("UpdateID".equals(name)) {
                    updateID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetRecordScheduleResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordScheduleResponse", "u"));
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class GetRecordTaskConflictsRequest
        extends SOAPSerializable
    {

        public String recordTaskID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordTaskID".equals(name)) {
                    recordTaskID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetRecordTaskConflictsRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordTaskConflictsRequest", "u"));
            soapBodyElement.addChildElement("RecordTaskID").setTextContent(recordTaskID.toString());
            return retVal;
        }

    }

    public static class GetRecordTaskConflictsResponse
        extends SOAPSerializable
    {

        public String recordTaskConflictIDList;
        public int updateID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordTaskConflictIDList".equals(name)) {
                    recordTaskConflictIDList = e.getTextContent();
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
            SOAPMessage retVal = ScheduledRecording.GetRecordTaskConflictsResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordTaskConflictsResponse", "u"));
            soapBodyElement.addChildElement("RecordTaskConflictIDList").setTextContent(recordTaskConflictIDList.toString());
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
            return retVal;
        }

    }

    public static class GetRecordTaskRequest
        extends SOAPSerializable
    {

        public String recordTaskID;
        public String filter;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordTaskID".equals(name)) {
                    recordTaskID = e.getTextContent();
                    continue;
                }
                if ("Filter".equals(name)) {
                    filter = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetRecordTaskRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordTaskRequest", "u"));
            soapBodyElement.addChildElement("RecordTaskID").setTextContent(recordTaskID.toString());
            soapBodyElement.addChildElement("Filter").setTextContent(filter.toString());
            return retVal;
        }

    }

    public static class GetRecordTaskResponse
        extends SOAPSerializable
    {

        public String result;
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
                if ("UpdateID".equals(name)) {
                    updateID = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetRecordTaskResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetRecordTaskResponse", "u"));
            soapBodyElement.addChildElement("Result").setTextContent(result.toString());
            soapBodyElement.addChildElement("UpdateID").setTextContent(Integer.toString(updateID));
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
            SOAPMessage retVal = ScheduledRecording.GetSortCapabilitiesRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortCapabilitiesRequest", "u"));
            return retVal;
        }

    }

    public static class GetSortCapabilitiesResponse
        extends SOAPSerializable
    {

        public String sortCaps;
        public int sortLevelCap;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("SortCaps".equals(name)) {
                    sortCaps = e.getTextContent();
                    continue;
                }
                if ("SortLevelCap".equals(name)) {
                    sortLevelCap = Integer.valueOf(e.getTextContent());
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetSortCapabilitiesResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetSortCapabilitiesResponse", "u"));
            soapBodyElement.addChildElement("SortCaps").setTextContent(sortCaps.toString());
            soapBodyElement.addChildElement("SortLevelCap").setTextContent(Integer.toString(sortLevelCap));
            return retVal;
        }

    }

    public static class GetStateUpdateIDRequest
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.GetStateUpdateIDRequest.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "GetStateUpdateIDRequest", "u"));
            return retVal;
        }

    }

    public static class GetStateUpdateIDResponse
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
            SOAPMessage retVal = ScheduledRecording.GetStateUpdateIDResponse.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "GetStateUpdateIDResponse", "u"));
            soapBodyElement.addChildElement("Id").setTextContent(Integer.toString(id));
            return retVal;
        }

    }

    public static class ResetRecordTaskRequest
        extends SOAPSerializable
    {

        public String recordTaskID;

        
        public void parse(SOAPMessage soapMessage)
            throws SOAPException
        {
            for (Element e: XmlUtil.getChildElements(XmlUtil.getChildElements(soapMessage.getSOAPBody()).get(0))) {
                String name = e.getNodeName();
                if ("RecordTaskID".equals(name)) {
                    recordTaskID = e.getTextContent();
                    continue;
                }
            }
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.ResetRecordTaskRequest.createMessage();
            SOAPBodyElement soapBodyElement = retVal.getSOAPBody().addBodyElement(new QName(URI, "ResetRecordTaskRequest", "u"));
            soapBodyElement.addChildElement("RecordTaskID").setTextContent(recordTaskID.toString());
            return retVal;
        }

    }

    public static class ResetRecordTaskResponse
        extends SOAPSerializable
    {


        public void parse(SOAPMessage soapMessage) {
        }

        public SOAPMessage format()
            throws SOAPException
        {
            SOAPMessage retVal = ScheduledRecording.ResetRecordTaskResponse.createMessage();
            retVal.getSOAPBody().addBodyElement(new QName(URI, "ResetRecordTaskResponse", "u"));
            return retVal;
        }

    }

}
