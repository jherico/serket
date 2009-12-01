package org.saintandreas.serket.test;

import java.io.File;

import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.saintandreas.serket.didl.DIDLHelper;
import org.saintandreas.serket.impl.didl.RootContainer;
import org.saintandreas.serket.impl.didl.file.FileContainer;
import org.saintandreas.util.XmlUtil;

public class DIDLTest {

    @Test
    public void testFileDIDL() throws TransformerException {
        RootContainer root = new RootContainer();
        FileContainer fileContainer = new FileContainer(new File("c:\\media"), root);
        System.out.println(XmlUtil.prettyPrint(DIDLHelper.createDocument(fileContainer)));
    }
}
