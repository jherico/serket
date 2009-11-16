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
package org.saintandreas.serket.device;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.saintandreas.serket.service.Service;

public interface Device {
    @Nonnull
    public String getDeviceType();

    @Nonnull
    public String getFriendlyName();

    @Nonnull
    public Manufacturer getManufacturer();

    @Nonnull
    public Model getModel();

    @Nullable
    public String getSerialNumber();

    @Nullable
    public String getPresentationURL();

    @Nonnull
    public String getUDN();

    @Nonnull
    public List<Icon> getIconList();

    @Nonnull
    public List<Service> getServiceList();

    @Nonnull
    public List<Device> getDeviceList();
}
