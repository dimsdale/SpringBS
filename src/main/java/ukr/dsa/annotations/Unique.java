package ukr.dsa.annotations;

import ukr.dsa.annotations.impl.UniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Surger on 17.05.2016.
 */
@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String message() default "{NotUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
