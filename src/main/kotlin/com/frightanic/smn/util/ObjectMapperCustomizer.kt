package com.frightanic.smn.util

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import io.quarkus.jackson.ObjectMapperCustomizer
import io.quarkus.jackson.ObjectMapperCustomizer.MINIMUM_PRIORITY
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import jakarta.inject.Singleton

@Singleton
class ObjectMapperCustomizer : ObjectMapperCustomizer {
    override fun priority(): Int {
        // to ensure that the customer Serializers will be applied last and thus override the default ones
        return MINIMUM_PRIORITY
    }

    override fun customize(objectMapper: ObjectMapper) {
        registerOffsetDateTimeToRfc3339Serializer(objectMapper)
    }

    private fun registerOffsetDateTimeToRfc3339Serializer(objectMapper: ObjectMapper) {
        objectMapper.registerModule(
            SimpleModule().addSerializer(
                OffsetDateTime::class.java,
                object : JsonSerializer<OffsetDateTime?>() {
                    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.S]XXX")

                    override fun serialize(value: OffsetDateTime?, generator: JsonGenerator, sp: SerializerProvider?) {
                        if (value != null) {
                            generator.writeString(value.format(formatter))
                        }
                    }
                })
        )
    }
}
