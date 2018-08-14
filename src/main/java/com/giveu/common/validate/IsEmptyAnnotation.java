package com.giveu.common.validate;


import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsEmptyAnnotation {
    public boolean isEmpty() default true;

    public String message() default "字段不能为空！";
}
