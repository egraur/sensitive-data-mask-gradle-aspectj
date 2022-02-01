package gradleAspects;

import lombok.ToString;

@ToString
public class Entity {
    @LogMasking
    String sensitiveData="SENSITIVE DATA";
}



