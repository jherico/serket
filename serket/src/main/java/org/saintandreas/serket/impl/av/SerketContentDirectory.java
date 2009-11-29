package org.saintandreas.serket.impl.av;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.impl.didl.RootContainer;
import org.saintandreas.serket.scpd.ContentDirectory;
import org.saintandreas.serket.service.ServiceType;

public class SerketContentDirectory extends ContentDirectory {
    private static final Log LOG = LogFactory.getLog(SerketContentDirectory.class);
    private RootContainer rootContainer = new RootContainer();

    public SerketContentDirectory(String controlURL, String eventURL) {
        super(SERVICE_ID_PREFIX + "ContentDirectory", controlURL, eventURL);
    }
    
    @Override
    public ServiceType getServiceTypeEnum() {
        return ServiceType.ContentDirectory;
    }

    @Override
    public BrowseResponse browse(BrowseRequest input) throws IOException {
        LOG.debug(input.objectID + " : " + input.browseFlag);
        // find results
        BrowseResponse response = new BrowseResponse();
        List<? extends Base> children = findResults(input);
        response.numberReturned = response.totalMatches = children.size();
        response.updateID = 0;
        return response;
    }

    private List<? extends Base> findResults(BrowseRequest input) {
        return null;
    }

    @Override
    public CreateObjectResponse createObject(CreateObjectRequest input) {
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
        retVal.id = rootContainer.getUpdateId();
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

    public RootContainer getRootContainer() {
        return rootContainer;
    }

}
