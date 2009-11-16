package org.saintandreas.serket.scpd;

public interface ContentDirectory3 {

    public String getSearchCapabilities();

    public String getSortCapabilities();

    public String getSortExtensionCapabilities();

    public String getFeatureList();

    public Integer getSystemUpdateID();

    public String getServiceResetToken();

    public ContentDirectory3.BrowseResponse browse();

    public ContentDirectory3.SearchResponse search();

    public ContentDirectory3.CreateObjectResponse createObject();

    public void destroyObject();

    public void updateObject();

    public String moveObject();

    public Integer importResource();

    public Integer exportResource();

    public void deleteResource();

    public void stopTransferResource();

    public ContentDirectory3.GetTransferProgressResponse getTransferProgress();

    public String createReference();

    public ContentDirectory3.FreeFormQueryResponse freeFormQuery();

    public String getFreeFormQueryCapabilities();

    public class BrowseResponse {

        public String Result;
        public Integer NumberReturned;
        public Integer TotalMatches;
        public Integer UpdateID;

    }

    public class CreateObjectResponse {

        public String ObjectID;
        public String Result;

    }

    public class FreeFormQueryResponse {

        public String QueryResult;
        public Integer UpdateID;

    }

    public class GetTransferProgressResponse {

        public Object TransferStatus;
        public String TransferLength;
        public String TransferTotal;

    }

    public class SearchResponse {

        public String Result;
        public Integer NumberReturned;
        public Integer TotalMatches;
        public Integer UpdateID;

    }

}