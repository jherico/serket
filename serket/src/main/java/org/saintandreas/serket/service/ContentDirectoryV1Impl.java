package org.saintandreas.serket.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


import org.saintandreas.serket.didl.Container;
import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.util.DIDLHelper;
import org.saintandreas.serket.didl.util.DLNAProvider;
import org.saintandreas.util.CollectionUtil;
import org.saintandreas.util.StringUtil;

public class ContentDirectoryV1Impl implements ContentDirectoryV1 {
    DLNAProvider provider;
    

    @Override
    public SOAPMessage browse(String objectId, boolean self, String filter, int offset, int count, String sortCriteria) throws SOAPException, IOException {
        List<Base> resultList = new ArrayList<Base>();
        int total = 0;
        int resultCount = 0;
        // TODO integrate into API
        String updateId = "0";
        Base resultNode = provider.getById(objectId);
        if (resultNode != null) {
            if (self) {
                total = resultCount = 1;
                resultList.add(resultNode);
            } else if (resultNode instanceof Container) {
                Container ctr = (Container) resultNode;
                resultList.addAll(ctr.getChildren(offset, count));
                resultCount = resultList.size();
                total = ctr.getChildCount();
                resultList.addAll(CollectionUtil.getSubList(offset, count, ctr.getChildren()));
            }
        }
        return ContentDirectoryV1Helper.createBrowseResponse(DIDLHelper.format(resultList), resultCount, total, updateId);
    }

    @Override
    public SOAPMessage getSearchCapabilities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SOAPMessage getSortCapabilities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SOAPMessage getSystemUpdateId() {
        // TODO Auto-generated method stub
        return null;
    }
}
