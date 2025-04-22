package com.janz.hexarchksb_ecommerce.infrastructure.configurations

import com.janz.hexarchksb_ecommerce.infrastructure.configurations.entities.BearerToken
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.Date

@Component
class JwtSupport {
    private val key = Keys.hmacShaKeyFor("9rSPQFeqLUhTtn9haBaWzPNMKiF6tVxkJhSd8sH7hyk=".toByteArray())
    private val parser = Jwts.parser().verifyWith(key).build();


    fun generate(username: String): BearerToken {
        val builder = Jwts.builder()
            .subject(username)
            .issuedAt(Date.from(Instant.now()))
            .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
            .signWith(key)
        return BearerToken(builder.compact())
    }

    fun getUserName(token: BearerToken): String {
        return parser.parseSignedClaims(token.value).payload.subject
    }

    fun isValid(token: BearerToken): Boolean {
        val claims = parser.parseSignedClaims(token.value).payload
        val expired = claims.expiration.before(Date.from(Instant.now()))
        return !expired
    }
}