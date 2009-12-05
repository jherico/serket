package org.saintandreas.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReflectUtil {
    private static final Log LOG = LogFactory.getLog(ReflectUtil.class);

    public static abstract class ValueAccessor<T extends AccessibleObject> {
        protected final T accessor;

        public ValueAccessor(T accessor) {
            this.accessor = accessor;
        }

        public abstract Object getValue(Object owner) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException;

        public Object getValueSafely(Object owner) {
            try {
                return getValue(owner);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                LOG.warn(e);
                return null;
            }
        }
    }

    public static class FieldAccessor extends ValueAccessor<Field> {
        public FieldAccessor(Field accessor) {
            super(accessor);
        }

        @Override
        public Object getValue(Object owner) throws IllegalArgumentException, IllegalAccessException {
            return accessor.get(owner);
        }
    }

    public static class MethodAccessor extends ValueAccessor<Method> {
        public MethodAccessor(Method accessor) {
            super(accessor);
        }

        @Override
        public Object getValue(Object owner) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            return accessor.invoke(owner, new Object[] {});
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends AccessibleObject> ValueAccessor<T> getValueAccessor(T accessor) {
        if (accessor instanceof Field) {
            return (ValueAccessor<T>) new FieldAccessor((Field)accessor);
        } else if (accessor instanceof Method){
            return (ValueAccessor<T>) new MethodAccessor((Method)accessor);
        }
        return null;
    }

}
