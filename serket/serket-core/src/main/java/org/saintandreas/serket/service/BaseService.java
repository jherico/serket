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
package org.saintandreas.serket.service;


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

    public abstract String getURI();
    
//    @SuppressWarnings("unchecked")
//    protected void doSoap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            String soapAction = request.getHeader("SOAPACTION");
//            String function = soapAction.substring(soapAction.lastIndexOf("#") + 1, soapAction.length() - 1);
//            Method method = findMethod(getClass(), function);
//            Class<? extends SOAPSerializable> input = (Class<? extends SOAPSerializable>) method.getParameterTypes()[0];
//            SOAPSerializable inputObject = input.newInstance();
//            inputObject.parse(SOAPUtil.parse(request));
//            SOAPSerializable outputObject = (SOAPSerializable) method.invoke(this, inputObject);
//            SOAPMessage outputMessage = outputObject.format();
//            outputMessage.writeTo(response.getOutputStream());
//        } catch (SOAPException e) {
//            throw new ServletException(e);
//        } catch (IllegalArgumentException e) {
//            throw new ServletException(e);
//        } catch (IllegalAccessException e) {
//            throw new ServletException(e);
//        } catch (InvocationTargetException e) {
//            throw new ServletException(e);
//        } catch (InstantiationException e) {
//            throw new ServletException(e);
//        } 
//        
//    }
//    
//    protected static Method findMethod(Class<?> clazz, String function) {
//        Method retVal = null;
//        for (Method m : clazz.getMethods()) {
//            if (m.getName().equalsIgnoreCase(function)) {
//                retVal = m;
//                break;
//            }
//        }
//        return retVal;
//    }

}
