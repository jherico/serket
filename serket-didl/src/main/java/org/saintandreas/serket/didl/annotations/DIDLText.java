package org.saintandreas.serket.didl.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.meta.TypeQualifier;

@Documented
@TypeQualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD})
public @interface DIDLText {
}
