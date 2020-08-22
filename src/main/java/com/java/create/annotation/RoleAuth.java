package com.java.create.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*** Custom java annotation**/
/*** @Target defines where you are targeting to use this annotation like method,class constructor etc**/
/*** @Retention Indicates how long annotations with the annotated type are tobe retained.**/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleAuth {

}
