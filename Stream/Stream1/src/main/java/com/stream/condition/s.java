//package com.stream.condition;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    @Conditional(EnvironmentCondition.class)
//    public MyEnvironmentDependentBean environmentDependentBean() {
//        return new MyEnvironmentDependentBean();
//    }
//
//    @Bean
//    @Conditional(FeatureToggleCondition.class)
//    public MyFeatureDependentBean featureDependentBean() {
//        return new MyFeatureDependentBean();
//    }
//
//
//
//}
