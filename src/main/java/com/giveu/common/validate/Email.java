package com.giveu.common.validate;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    public boolean mail() default true;

    public String message() default "员工邮箱校验错误！";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}