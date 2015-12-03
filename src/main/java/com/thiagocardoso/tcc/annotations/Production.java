package com.thiagocardoso.tcc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

@Profile("production")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Production {

}
