package org.saintandreas.serket.impl.av;

import org.saintandreas.serket.scpd.ConnectionManager;
import org.saintandreas.serket.service.ServiceType;

public class SerketConnectionManager extends ConnectionManager {

    public SerketConnectionManager(String controlURL, String eventURL) {
        super(SERVICE_ID_PREFIX + "ConnectionManager", controlURL, eventURL);
    }

    @Override
    public ServiceType getServiceTypeEnum() {
        return ServiceType.ConnectionManager;
    }

    @Override
    public ConnectionCompleteResponse connectionComplete(ConnectionCompleteRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GetCurrentConnectionIDsResponse getCurrentConnectionIDs(GetCurrentConnectionIDsRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GetCurrentConnectionInfoResponse getCurrentConnectionInfo(GetCurrentConnectionInfoRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GetProtocolInfoResponse getProtocolInfo(GetProtocolInfoRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PrepareForConnectionResponse prepareForConnection(PrepareForConnectionRequest input) {
        // TODO Auto-generated method stub
        return null;
    }

}
