package com.frightanic.smn

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import jakarta.ws.rs.core.HttpHeaders.CACHE_CONTROL

@QuarkusTest
internal class SmnResourceTest {

    @Nested
    inner class List {
        @Test
        fun `should return array`() {
            given()
                .`when`().get("/smn")
                .then()
                .statusCode(200)
                .body(containsString("[{\"station\":{\"code\":\"TAE\""))
        }

        @Test
        fun `should have cache-control max-age 5min`() {
            given()
                .`when`().get("/smn")
                .then()
                .header(CACHE_CONTROL, "max-age=300")
        }
    }
}
