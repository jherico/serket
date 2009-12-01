package org.saintandreas.serket.didl;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.saintandreas.util.ReflectUtil;
import org.saintandreas.util.ReflectUtil.ValueAccessor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AnnotatedClassInfo {
    private DIDLItem itemAnnotation = null;

    private class DIDLElementComparator implements Comparator<DIDLElement> {

        @Override
        public int compare(DIDLElement o1, DIDLElement o2) {
            return o1.order() == o2.order() ? 0 : (o1.order() > o2.order() ? 1 : -1);
        }

    }

    private SortedMap<DIDLElement, ValueAccessor<Method>> elementMap = new TreeMap<DIDLElement, ValueAccessor<Method>>(new DIDLElementComparator());
    private Map<DIDLAttribute, ValueAccessor<Method>> attributeMap = new HashMap<DIDLAttribute, ValueAccessor<Method>>();

    public AnnotatedClassInfo(Class<?> annotatedClass) {
        Set<Class<?>> processedClasses = new HashSet<Class<?>>();
        Class<?> currentClass = annotatedClass;
        while (currentClass != null) {
            if (processedClasses.add(currentClass)) {
                processClass(currentClass, elementMap, attributeMap);
            }
            if (itemAnnotation == null) {
                itemAnnotation = currentClass.getAnnotation(DIDLItem.class);
            }
            currentClass = currentClass.getSuperclass();
        }

        currentClass = annotatedClass;
        while (currentClass != null) {
            for (Class<?> interfaze : currentClass.getInterfaces()) {
                if (processedClasses.add(interfaze)) {
                    processClass(interfaze, elementMap, attributeMap);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }

    private static void processClass(Class<?> annotatedClass, Map<DIDLElement, ValueAccessor<Method>> elementMap, Map<DIDLAttribute, ValueAccessor<Method>> attributeMap) {
        for (Method m : annotatedClass.getMethods()) {
            DIDLAttribute attr = m.getAnnotation(DIDLAttribute.class);
            if (attr != null && !attributeMap.containsKey(attr)) {
                attributeMap.put(attr, ReflectUtil.getValueAccessor(m));
            }

            DIDLElement ele = m.getAnnotation(DIDLElement.class);
            if (ele != null && !elementMap.containsKey(ele)) {
                elementMap.put(ele, ReflectUtil.getValueAccessor(m));
            }
        }
    }

    public Node createNode(Object obj, Node parent) {
        Element retVal = parent.getOwnerDocument().createElementNS(DIDLNamespace.DIDL.uri, itemAnnotation.value());
        for (Map.Entry<DIDLAttribute, ValueAccessor<Method>> entry : attributeMap.entrySet()) {
            addAttribute(retVal, entry.getKey(), entry.getValue().getValueSafely(obj));
        }

        for (Map.Entry<DIDLElement, ValueAccessor<Method>> entry : elementMap.entrySet()) {
            addElement(retVal, entry.getKey(), entry.getValue().getValueSafely(obj));
        }
        
        return retVal;
    }

    private static void addAttribute(Element node, DIDLAttribute annotation, Object value) {
        if (value == null) {
            if (annotation.required()) {
                throw new RuntimeException("required attribute " + annotation.value() + " had null value");
            }
            return;
        }
        node.setAttribute(annotation.value(), value.toString());
    }

    private static void addElement(Element node, DIDLElement annotation, Object value) {
        if (value == null) {
            if (annotation.required()) {
                throw new RuntimeException("required element " + annotation.value() + " had null value");
            }
            return;
        }
        Element newChild = node.getOwnerDocument().createElementNS(annotation.namespace().uri, annotation.value());
        if (annotation.namespace() != DIDLNamespace.DIDL) {
            newChild.setPrefix(annotation.namespace().prefix);
        }
        newChild.setTextContent(value.toString());
        node.appendChild(newChild);
    }

}
