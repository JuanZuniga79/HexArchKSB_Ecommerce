package com.janz.hexarchksb_ecommerce.infrastructure.configurations

import com.janz.hexarchksb_ecommerce.infrastructure.configurations.entities.BearerToken
import org.springframework.http.HttpHeaders
import org.springframework.security.core.Authentication
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class JwtServerAuthenticationConverter : ServerAuthenticationConverter {

    override fun convert(exchange: ServerWebExchange): Mono<Authentication> {
        return Mono.justOrEmpty(exchange.request.headers.getFirst(HttpHeaders.AUTHORIZATION))
            .filter { it.startsWith("Bearer ")}
            .map { it.substring(7) }
            .map { jwt -> BearerToken(jwt) }
    }
}