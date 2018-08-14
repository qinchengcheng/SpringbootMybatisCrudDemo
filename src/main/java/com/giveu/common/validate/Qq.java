package com.giveu.common.validate;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Qq {
    public boolean qq() default true;

    public String message() default "员工QQ校验错误！";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}