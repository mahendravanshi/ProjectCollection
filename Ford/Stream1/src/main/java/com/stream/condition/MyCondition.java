package com.stream.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Implement your condition logic here
        // Return true if the bean should be registered, false otherwise
        return someConditionCheck();
    }

    private boolean someConditionCheck() {
        // Your custom condition logic
        return true;
    }
}
