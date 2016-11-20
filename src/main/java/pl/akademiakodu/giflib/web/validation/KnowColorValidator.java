package pl.akademiakodu.giflib.web.validation;

import pl.akademiakodu.giflib.web.Color;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Jaremina on 2016-11-20.
 */
public class KnowColorValidator implements ConstraintValidator<KnownColor,  String> {

    @Override
    public void initialize(KnownColor constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for(Color color : Color.values()){
            if(value.equalsIgnoreCase(color.getHexCode())){
                return true;
            }
        }
        return false;
    }
}
