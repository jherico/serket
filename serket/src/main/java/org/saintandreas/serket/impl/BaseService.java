/*
 * Copyright (C) 2009 Bradley Austin Davis.
 * 
 * This file is part of serket.
 * 
 * serket is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * serket is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * serket. If not, see <http://www.gnu.org/licenses/>.
*/
package org.saintandreas.serket.impl;

import org.saintandreas.serket.service.Service;
import org.saintandreas.serket.service.ServiceType;

public abstract class BaseService implements Service {

    public abstract ServiceType getServiceTypeEnum();
    private final String eventURL;
    private final String controlURL;
    private final String id;
    
    protected BaseService(String id, String controlURL, String eventURL) {
        this.id = id;
        this.controlURL = controlURL;
        this.eventURL = eventURL;
    }
    
    @Override
    public String getDescriptionURL() {
        return getServiceTypeEnum().scpdResourcePath();
    }

    @Override
    public String getServiceType() {
        return getServiceTypeEnum().getTypeName();
    }

    @Override
    public String getControlURL() {
        return controlURL;
    }

    @Override
    public String getEventURL() {
        return eventURL;
    }

    @Override
    public String getId() {
       return id;
    }

}
