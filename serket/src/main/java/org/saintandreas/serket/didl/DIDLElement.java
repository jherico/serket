package org.saintandreas.serket.didl;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.meta.TypeQualifier;

@Documented
@TypeQualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD})
public @interface DIDLElement {
    public String value();
    public DIDLNamespace namespace() default DIDLNamespace.DIDL;
    public boolean required() default false;
    public int order() default Integer.MAX_VALUE / 2;
}
