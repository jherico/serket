package org.saintandreas.serket.reference;

import org.saintandreas.serket.scpd.ContentDirectory;
import org.saintandreas.serket.service.ServiceType;

public class SerketContentDirectory extends ContentDirectory {
    
    public SerketContentDirectory(String controlURL, String eventURL) {
        super(SERVICE_ID_PREFIX + "ContentDirectory", controlURL, eventURL);
    }

    @Override
    public ServiceType getServiceTypeEnum() {
        return ServiceType.ContentDirectory;
    }

    @Override
    public BrowseResponse browse(BrowseRequest input) {
        BrowseResponse response = new BrowseResponse();
        return response;
    }

    @Override
    public CreateObjectResponse createObject(CreateObjectRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CreateReferenceResponse createReference(CreateReferenceRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DeleteResourceResponse deleteResource(DeleteResourceRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DestroyObjectResponse destroyObject(DestroyObjectRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExportResourceResponse exportResource(ExportResourceRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GetSearchCapabilitiesResponse getSearchCapabilities(GetSearchCapabilitiesRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GetSortCapabilitiesResponse getSortCapabilities(GetSortCapabilitiesRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GetSystemUpdateIDResponse getSystemUpdateID(GetSystemUpdateIDRequest input) {
        GetSystemUpdateIDResponse retVal = new GetSystemUpdateIDResponse();
//        retVal.id = System.currentTimeMillis();
        retVal.id = 1; // System.currentTimeMillis();
        return retVal;
    }

    @Override
    public GetTransferProgressResponse getTransferProgress(GetTransferProgressRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ImportResourceResponse importResource(ImportResourceRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResponse search(SearchRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StopTransferResourceResponse stopTransferResource(StopTransferResourceRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UpdateObjectResponse updateObject(UpdateObjectRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

}
