package gradleAspects;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.lang.reflect.Field;

public class MaskingToStringBuilder extends ReflectionToStringBuilder {
    private static final String MASK = "****";

    public MaskingToStringBuilder(Object object) {
        super(object);
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        if ((field.getAnnotation(LogMasking.class) != null) && (
            String.class.equals(field.getType()))) {
            return MASK;
        }
        return super.getValue(field);
    }

    public static String toString(Object value) {
        return new MaskingToStringBuilder(value).toString();
    }
}
