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
import org.saintandreas.serket.didl.annotations.DIDLProperty;
import org.saintandreas.serket.didl.annotations.DIDLText;
import org.saintandreas.util.ReflectUtil;
import org.saintandreas.util.ReflectUtil.ValueAccessor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AnnotatedClassInfo {
    private static Map<Class<?>, AnnotatedClassInfo> ANNOTATION_MAP = new HashMap<Class<?>, AnnotatedClassInfo>();

    public static AnnotatedClassInfo getInfo(Class<?> clazz) {
        if (!ANNOTATION_MAP.containsKey(clazz)) {
            synchronized (ANNOTATION_MAP) {
                if (!ANNOTATION_MAP.containsKey(clazz)) {
                    ANNOTATION_MAP.put(clazz, new AnnotatedClassInfo(clazz));
                }
            }
        }
        return ANNOTATION_MAP.get(clazz);
    }

    private DIDLElement itemAnnotation = null;

    private class DIDLElementComparator implements Comparator<DIDLProperty> {

        @Override
        public int compare(DIDLProperty o1, DIDLProperty o2) {
            return o1.order() == o2.order() ? 0 : (o1.order() > o2.order() ? 1 : -1);
        }

    }

    private SortedMap<DIDLProperty, ValueAccessor<Method>> elementMap = new TreeMap<DIDLProperty, ValueAccessor<Method>>(new DIDLElementComparator());
    private Map<DIDLAttribute, ValueAccessor<Method>> attributeMap = new HashMap<DIDLAttribute, ValueAccessor<Method>>();
    private Map<DIDLElement, ValueAccessor<Method>> childMap = new HashMap<DIDLElement, ValueAccessor<Method>>();
    private ValueAccessor<Method> textAccessor = null;


    public static List<Class<?>> getAncestorsAndInterfaces(Class<?> clazz) {
        Set<Class<?>> seen = new HashSet<Class<?>>();
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

                DIDLProperty childElement = m.getAnnotation(DIDLProperty.class);
                if (childElement != null && !elementMap.containsKey(childElement)) {
                    elementMap.put(childElement, ReflectUtil.getValueAccessor(m));
                }
                
                DIDLElement childNode = m.getAnnotation(DIDLElement.class);
                if (childNode != null && !childMap.containsKey(childNode)) {
                    childMap.put(childNode, ReflectUtil.getValueAccessor(m));
                }

                if (m.getAnnotation(DIDLText.class) != null) {
                    if (this.textAccessor != null) {
                        throw new IllegalStateException("A DIDLElement may not have more than one DIDLText annotation");
                    }
                    textAccessor = ReflectUtil.getValueAccessor(m);
                }
                
                if (childNode != null && !childMap.containsKey(childNode)) {
                    childMap.put(childNode, ReflectUtil.getValueAccessor(m));
                }
            }
        }
        
        if (!childMap.isEmpty() && textAccessor != null) {
            throw new IllegalStateException("A DIDLElement may not have both DIDLProperty and DIDLText annotations");
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

        for (Map.Entry<DIDLProperty, ValueAccessor<Method>> entry : elementMap.entrySet()) {
            addElement(retVal, entry.getKey(), entry.getValue().getValueSafely(obj));
        }
        
        for (Map.Entry<DIDLElement, ValueAccessor<Method>> entry : childMap.entrySet()) {
            Object childObj = entry.getValue().getValueSafely(obj);
            if (childObj != null) {
                AnnotatedClassInfo.getInfo(childObj.getClass()).createNode(childObj, retVal);
            }
        }
        
        if (textAccessor != null) {
            Object value = textAccessor.getValueSafely(obj);
            if (value != null) {
                retVal.setTextContent(value.toString());
            }
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

    private static void addElement(Element node, DIDLProperty annotation, Object value) {
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
