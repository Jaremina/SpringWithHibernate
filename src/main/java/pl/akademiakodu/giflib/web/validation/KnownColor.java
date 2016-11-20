package pl.akademiakodu.giflib.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Jaremina on 2016-11-20.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) // kiedy bedzie przetwarzana i do kiedy bedzie utrzymywana adnotacja
@Constraint(validatedBy = KnowColorValidator.class)// klasa odpalana przy walidacji
public @interface KnownColor {

    String message() default "wrong color"; // wiadomosc widoczna wtedy gdy walidator stwierdzi ze wartosc jest nie prawidlowa

    //szablon
    Class<?>[] groups() default {};

    //szablon
    Class<? extends Payload>[] payload() default {};

}
