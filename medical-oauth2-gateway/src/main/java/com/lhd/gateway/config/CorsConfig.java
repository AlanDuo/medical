package com.lhd.gateway.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.config.GlobalCorsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;

/**
 * 处理跨域
 * @author alan
 * @date 2021/3/28
 */
//@Configuration
//@Order(Ordered.HIGHEST_PRECEDENCE)
//EnableConfigurationProperties(GlobalCorsProperties.class)
public class CorsConfig {
    private static final String MAX_AGE = "18000L";


//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    @RefreshScope
//    @Bean
//    public CorsWebFilter corsWebFilter(GlobalCorsProperties globalCorsProperties){
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
//        globalCorsProperties.getCorsConfigurations().forEach((k,v) -> source.registerCorsConfiguration(k, v));
//        return new CorsWebFilter(source);
//    }

    //@Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                HttpHeaders requestHeaders = request.getHeaders();
                ServerHttpResponse response = ctx.getResponse();
                HttpMethod requestMethod = requestHeaders.getAccessControlRequestMethod();
                HttpHeaders headers = response.getHeaders();
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
                headers.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                        requestHeaders.getAccessControlRequestHeaders());
                if (requestMethod != null) {
                    headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requestMethod.name());
                }
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
                headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };

    }
    /*@Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();

                URI uri = request.getURI();
                PathMatcher pathMatcher = new AntPathMatcher();
                //白名单路径移除JWT请求头
                List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
                for (String ignoreUrl : ignoreUrls) {
                    if (pathMatcher.match(ignoreUrl, uri.getPath())) {
                        request = exchange.getRequest().mutate().header("Authorization", "").build();
                        exchange = exchange.mutate().request(request).build();
                        return chain.filter(exchange);
                    }
                }
                return chain.filter(exchange);
            }
        };
    }*/
}
