package org.saintandreas.serket.jetty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class PMSProcessor extends HttpServlet {

    /**
     * This method is here for testing purposes. It can be used to make sure that the servlet is accepting requests.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Unagi Persister Test</TITLE></HEAD>");
        out.println("<BODY");
        out.println("<FORM METHOD=POST ACTION=\"/cms-ws/unagi\">");
        out.println("Enter unagi xml for testing");
        out.println("<INPUT TYPE=TEXT NAME=\"body-text\"><P>");
        out.println("<INPUT TYPE=SUBMIT>");
        out.println("</FORM>");
        out.println("</BODY");
        out.println("</HTML>");
    }

//    /**
//     * This is the method that will accept XML data from the client via the input stream. HTTP status codes are set for
//     * the response based on behavior of handle. No authorization required to upload. On success code 200 on failure
//     * code 500
//     * 
//     * @throws ServletException
//     * @throws IOException
//     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getHeader("soap-action");
        System.out.println();
    }

//    <DIDL-Lite>
//      <item id="0$1$1$0" parentID="0$1$1" restricted="true">
//        <dc:title>JET FM (French Radio) [MPlayer Web]</dc:title>
//        <res protocolInfo="http-get:*:audio/wav:DLNA.ORG_PN=LPCM;DLNA.ORG_OP=01" size="100000000000">http://192.168.0.102:5001/get/0$1$1$0/JET+FM+%28French+Radio%29</res>
//        <upnp:albumArtURI profileID="JPEG_TN">http://192.168.0.102:5001/get/0$1$1$0/thumbnail0000JET+FM+%28French+Radio%29</upnp:albumArtURI>
//        <upnp:class>object.item.audioItem.musicTrack</upnp:class>
//      </item>
//      <container id="0$1$1$1" childCount="1" parentID="0$1$1" restricted="true">
//        <dc:title>Radios With VLC</dc:title>
//        <res protocolInfo="http-get:*:image/jpeg:DLNA.ORG_PN=JPEG_TN">http://192.168.0.102:5001/get/0$1$1$1/thumbnail0000Radios+With+VLC+%5Bvlcaudio%5D</res>
//        <upnp:class>object.container.storageFolder</upnp:class>
//      </container>
//      <item id="0$1$1$2" parentID="0$1$1" restricted="true">
//        <dc:title>Smooth Jazz [MPlayer Web]</dc:title>
//        <res protocolInfo="http-get:*:audio/wav:DLNA.ORG_PN=LPCM;DLNA.ORG_OP=01" size="100000000000">http://192.168.0.102:5001/get/0$1$1$2/Smooth+Jazz</res>
//        <upnp:albumArtURI profileID="JPEG_TN">http://192.168.0.102:5001/get/0$1$1$2/thumbnail0000Smooth+Jazz</upnp:albumArtURI>
//        <upnp:class>object.item.audioItem.musicTrack</upnp:class>
//      </item>
//      <item id="0$1$1$3" parentID="0$1$1" restricted="true">
//        <dc:title>KBPS All-classical [MPlayer Web]</dc:title>
//        <res protocolInfo="http-get:*:audio/wav:DLNA.ORG_PN=LPCM;DLNA.ORG_OP=01" size="100000000000">http://192.168.0.102:5001/get/0$1$1$3/KBPS+All-classical</res>
//        <upnp:albumArtURI profileID="JPEG_TN">http://192.168.0.102:5001/get/0$1$1$3/thumbnail0000KBPS+All-classical</upnp:albumArtURI>
//        <upnp:class>object.item.audioItem.musicTrack</upnp:class>
//      </item>
//    </DIDL-Lite>
}
