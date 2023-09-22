package com.santana.api.gateway;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth", r -> r.path("/auth/**").uri("lb://auth"))
                .route("user", r -> r.path("/user/**").uri("lb://user"))
                .route("vehicle", r -> r.path("/vehicle/**").uri("lb://vehicle"))
                .build();
    }

}
