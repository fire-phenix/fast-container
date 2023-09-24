package com.fire.phenix.container.annotation;

import java.lang.annotation.*;

/**
 * @author fire-phenix
 * @since 2023-09-24
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotControllerRespAdvice {
}
