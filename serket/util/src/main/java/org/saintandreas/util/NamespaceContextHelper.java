package org.saintandreas.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;

public class NamespaceContextHelper implements NamespaceContext {
    Map<String, String> forwardMap = new HashMap<String, String>();
    Map<String, String> backMap = new HashMap<String, String>();

    public NamespaceContextHelper() {
        init();
    }

    public NamespaceContextHelper(String prefix, String uri) {
        addMapping(prefix, uri);
        init();
    }

    private void init() {
        addMapping("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    }

    public void addMapping(String prefix, String uri) {
        if (forwardMap.containsKey(prefix) && !prefix.equals(backMap.get(uri))) {
            throw new UnsupportedOperationException("unable to remap namespace prefixes");
        }
        forwardMap.put(uri, prefix);
        backMap.put(prefix, uri);
    }

    public String getNamespaceURI(String prefix) {
        return backMap.get(prefix);
    }

    public String getPrefix(String namespaceURI) {
        return forwardMap.get(namespaceURI);
    }

    public Iterator<String> getPrefixes(String namespaceURI) {
        List<String> list = new ArrayList<String>();
        if (forwardMap.containsKey(namespaceURI)) {
            list.add(forwardMap.get(namespaceURI));
        }
        return Collections.unmodifiableList(list).iterator();
    }

}
