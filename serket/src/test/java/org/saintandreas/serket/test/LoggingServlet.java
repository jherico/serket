package org.saintandreas.serket.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class LoggingServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogFactory.getLog(getClass()).debug(request.getPathInfo() + " from " + request.getRemoteAddr());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogFactory.getLog(getClass()).debug(request.getPathInfo() + " from " + request.getRemoteAddr());
        if (request.getHeader("SOAPACTION") != null) {
            LogFactory.getLog(getClass()).debug("SOAPACTION: " + request.getHeader("SOAPACTION"));
        }
    }

}
