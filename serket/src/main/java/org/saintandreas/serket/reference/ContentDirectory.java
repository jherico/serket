package org.saintandreas.serket.reference;

import org.saintandreas.serket.impl.BaseService;
import org.saintandreas.serket.service.ServiceType;

public class ContentDirectory extends BaseService {

    protected ContentDirectory(String controlURL, String eventURL) {
        super(SERVICE_ID_PREFIX + "ContentDirectory", "service/cd/control", "service/cd/event");
    }

    @Override
    public ServiceType getServiceTypeEnum() {
        return ServiceType.ContentDirectory3;
    }

}
