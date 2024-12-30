package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("Inventario", r -> r.path("/inventario/**")
                .uri("http://localhost:8090/"))
                .route("Registro", r -> r.path("/registro/**")
                .uri("http://localhost:8085/")).build();
    }
}
