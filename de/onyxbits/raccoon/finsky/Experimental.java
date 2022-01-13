package de.onyxbits.raccoon.finsky;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Experimental {
}
