package org.saintandreas.serket.reference.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.impl.BaseService;
import org.saintandreas.serket.soap.SOAPSerializable;
import org.saintandreas.serket.soap.SOAPUtil;

@SuppressWarnings("serial")
public class UpnpServiceServlet extends HttpServlet {
    private static final Log LOG = LogFactory.getLog(UpnpServiceServlet.class);

    private final List<BaseService> services = new ArrayList<BaseService>();
    
    @SuppressWarnings("unchecked")
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try {
//            LOG.debug(soapAction);
            String[] soapAction = request.getHeader("SOAPACTION").replaceAll("\"", "").split("#");
            for (BaseService service : services) {
                if (soapAction[0].equals(service.getURI())) {
                    Method method = findMethod(service.getClass(), soapAction[1]);
                    Class<? extends SOAPSerializable> input = (Class<? extends SOAPSerializable>) method.getParameterTypes()[0];
                    SOAPSerializable inputObject = input.newInstance();
                    inputObject.parse(SOAPUtil.parse(request));
                    SOAPSerializable outputObject = (SOAPSerializable) method.invoke(service, inputObject);
                    SOAPMessage outputMessage = outputObject.format();
                    outputMessage.writeTo(response.getOutputStream());
                }
            }
        } catch (IllegalArgumentException e) {
            throw new ServletException(e);
        } catch (SOAPException e) {
            throw new ServletException(e);
        } catch (IllegalAccessException e) {
            throw new ServletException(e);
        } catch (InvocationTargetException e) {
            throw new ServletException(e);
        } catch (InstantiationException e) {
            throw new ServletException(e);
        } 
    }

    public static Method findMethod(Class<?> clazz, String function) {
        Method retVal = null;
        for (Method m : clazz.getMethods()) {
            if (m.getName().equalsIgnoreCase(function)) {
                retVal = m;
                break;
            }
        }
        return retVal;
    }

    public List<BaseService> getServices() {
        return services;
    }
    
}
