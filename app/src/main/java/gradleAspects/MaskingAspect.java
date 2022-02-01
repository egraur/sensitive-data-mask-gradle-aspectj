package gradleAspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Field;


@Aspect
public class MaskingAspect {
    @Around("execution (* toString())")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Field[] fields = joinPoint.getTarget().getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(LogMasking.class)) {
                return MaskingToStringBuilder.toString(joinPoint.getTarget());
            }
        }
        return joinPoint.proceed();
    }
}
