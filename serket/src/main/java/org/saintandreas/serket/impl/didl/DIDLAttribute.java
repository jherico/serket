package org.saintandreas.serket.impl.didl;

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
public @interface DIDLAttribute {
    String name();
    boolean required() default false;
}
