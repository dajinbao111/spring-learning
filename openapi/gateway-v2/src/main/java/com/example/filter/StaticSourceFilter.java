package com.example.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class StaticSourceFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("StaticSourceFilter");

        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if (path.contains(".js") || path.contains(".css") || path.contains("swagger") || path.contains("api-docs") || path.contains("webjars")) {
            exchange.getAttributes().put("is_static_source", true);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
