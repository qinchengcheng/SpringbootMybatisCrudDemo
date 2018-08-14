package com.giveu.common.validate;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    public boolean phone() default true;

    public String message() default "员工电话校验错误！";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
