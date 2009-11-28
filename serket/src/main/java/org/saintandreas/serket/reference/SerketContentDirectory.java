package org.saintandreas.serket.reference;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.util.component.Container;
import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.util.AContainer;
import org.saintandreas.serket.didl.util.ANode;
import org.saintandreas.serket.didl.util.DIDLHelper;
import org.saintandreas.serket.didl.util.RootContainer;
import org.saintandreas.serket.scpd.ContentDirectory;
import org.saintandreas.serket.service.ServiceType;
import org.saintandreas.serket.test.IntegrationTest;

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
        BrowseResponse response = new BrowseResponse();
        List<? extends Base> children = rootContainer.getChildren();
        response.result = DIDLHelper.format(children);
        response.numberReturned = response.totalMatches = children.size();
        response.updateID = 0;
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

    public AContainer getRootContainer() {
        // TODO Auto-generated method stub
        return rootContainer;
    }

}
