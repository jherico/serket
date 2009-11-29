package org.saintandreas.serket.impl.didl;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.meta.TypeQualifier;
import static java.lang.annotation.ElementType.*;

@Documented
@TypeQualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD})
public @interface DIDLElement {
    DIDLNamespace namespace() default DIDLNamespace.DIDL;
    boolean required() default false;
    String name();
}
