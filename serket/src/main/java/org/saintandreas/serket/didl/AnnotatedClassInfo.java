package org.saintandreas.serket.didl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.saintandreas.serket.didl.annotations.DIDLAttribute;
import org.saintandreas.serket.didl.annotations.DIDLElement;
import org.saintandreas.serket.didl.annotations.DIDLSubElement;
import org.saintandreas.util.ReflectUtil;
import org.saintandreas.util.ReflectUtil.ValueAccessor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AnnotatedClassInfo {
    private DIDLElement itemAnnotation = null;

    private class DIDLElementComparator implements Comparator<DIDLSubElement> {

        @Override
        public int compare(DIDLSubElement o1, DIDLSubElement o2) {
            return o1.order() == o2.order() ? 0 : (o1.order() > o2.order() ? 1 : -1);
        }

    }

    private SortedMap<DIDLSubElement, ValueAccessor<Method>> elementMap = new TreeMap<DIDLSubElement, ValueAccessor<Method>>(new DIDLElementComparator());
    private Map<DIDLAttribute, ValueAccessor<Method>> attributeMap = new HashMap<DIDLAttribute, ValueAccessor<Method>>();


//
//    List<Class<?>> getClassesAndInterfaces(Class<?> clazz) {
//        List<Class<?>> retVal = new ArrayList<Class<?>>();
//        Set<Class<?>> seen = new HashSet<Class<?>>();
//        retVal.addAll(getAncestors(clazz, seen));
//        while (clazz != null) {
//            for (Class<?> interfaze : clazz.getInterfaces()) {
//                if (seen.add(interfaze)) {
//                    retVal.add(interfaze);
//                    retVal.addAll(getAncestors(interfaze, seen));
//                }
//            }
//            clazz = clazz.getSuperclass();
//        }
//        retVal.addAll(getAncestors(clazz, seen));
//        Class<?> current = clazz;
//        while (current != null) {
//            retVal.add(current);
//            seen.add(current);
//            current = current.getSuperclass();
//        }
//    }

    public static List<Class<?>> getAncestorsAndInterfaces(Class<?> clazz) {
        Set<Class<?>> seen = new HashSet<Class<?>>();
//        List<Class<?>> retVal = new ArrayList<Class<?>>();
//        retVal.add(clazz);
//        seen.add(clazz);
        return getAncestorsAndInterfaces(clazz, seen); 
    }
    
    public static List<Class<?>> getAncestorsAndInterfaces(Class<?> clazz, Set<Class<?>> seen) {
        List<Class<?>> retVal = new ArrayList<Class<?>>();
        retVal.addAll(getAncestors(clazz, seen));
        retVal.addAll(getInterfaces(clazz, seen));
        while (clazz != null) {
            for (Class<?> interfaze : clazz.getInterfaces()) {
                retVal.addAll(getAncestorsAndInterfaces(interfaze, seen));
            }
            clazz = clazz.getSuperclass();
        }
        return retVal;
    }    
    
    public static List<Class<?>> getAncestors(Class<?> clazz, Set<Class<?>> seen) {
        List<Class<?>> retVal = new ArrayList<Class<?>>();
        while (clazz != null) {
            if (seen.add(clazz)) {
                retVal.add(clazz);
            }
            clazz = clazz.getSuperclass();
        }
        return retVal;
    }

    public static List<Class<?>> getInterfaces(Class<?> clazz, Set<Class<?>> seen) {
        List<Class<?>> retVal = new ArrayList<Class<?>>();
        for (Class<?> interfaze : clazz.getInterfaces()) {
            if (seen.add(interfaze)) {
                retVal.add(interfaze);
            }
        }
        return retVal;
    }
    
    public AnnotatedClassInfo(Class<?> annotatedClass) {
        List<Class<?>> clazzes = getAncestorsAndInterfaces(annotatedClass);
        for (Class<?> clazz : clazzes) {
            if (itemAnnotation == null) {
                itemAnnotation = clazz.getAnnotation(DIDLElement.class);
            }
            
            for (Method m : clazz.getMethods()) {
                DIDLAttribute attr = m.getAnnotation(DIDLAttribute.class);
                if (attr != null && !attributeMap.containsKey(attr)) {
                    attributeMap.put(attr, ReflectUtil.getValueAccessor(m));
                }

                DIDLSubElement ele = m.getAnnotation(DIDLSubElement.class);
                if (ele != null && !elementMap.containsKey(ele)) {
                    elementMap.put(ele, ReflectUtil.getValueAccessor(m));
                }
            }
        }

        if (itemAnnotation == null) {
            throw new RuntimeException();
        }
    }

    public Node createNode(Object obj, Node parent) {
        Element retVal = parent.getOwnerDocument().createElementNS(DIDLNamespace.DIDL.uri, itemAnnotation.value());
        for (Map.Entry<DIDLAttribute, ValueAccessor<Method>> entry : attributeMap.entrySet()) {
            addAttribute(retVal, entry.getKey(), entry.getValue().getValueSafely(obj));
        }

        for (Map.Entry<DIDLSubElement, ValueAccessor<Method>> entry : elementMap.entrySet()) {
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

    private static void addElement(Element node, DIDLSubElement annotation, Object value) {
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
