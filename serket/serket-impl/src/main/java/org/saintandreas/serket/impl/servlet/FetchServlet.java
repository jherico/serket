package org.saintandreas.serket.impl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.device.Device;
import org.saintandreas.serket.device.Icon;
import org.saintandreas.serket.service.Service;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@SuppressWarnings("serial")
public class FetchServlet extends HttpServlet {
    private static Log LOG = LogFactory.getLog(FetchServlet.class);

    public FetchServlet() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.trace("Got fetch request from " + request.getRemoteAddr());
//        response.setContentType("text/xml");
//        String xml = XmlUtil.formatXmlDocument();
//        response.getWriter().write(xml);
    }

}