package com.frightanic.smn.api

import com.frightanic.smn.StationMap
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.OffsetDateTime
import java.time.ZoneOffset.UTC
import java.time.format.DateTimeFormatter

/**
 * Represents a data set from an SMN observation station.
 */
@Schema(
    description = "A single SMN data record",
)
private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm").withZone(UTC)
class SmnRecord(sourceDataRecord: String) {
    @Schema(description = "The SMN weather station", readOnly = true)
    val station: Station?

    @Schema(description = "3-char all upper-case station code", required = true, readOnly = true)
    val code: String

    @Schema(description = "Time in UTC", type = SchemaType.STRING, format = "date-time", example = "2022-08-28T10:10:00.0Z", required = true, readOnly = true)
    val dateTime: OffsetDateTime

    @Schema(description = "Air temperature 2 m above ground; current value", readOnly = true)
    val temperature: String?

    @Schema(description = "Sunshine duration; ten minutes total", readOnly = true)
    val sunshine: String?

    @Schema(description = "Precipitation; ten minutes total", readOnly = true)
    val precipitation: String?

    @Schema(description = "Wind direction; ten minutes mean", readOnly = true)
    val windDirection: String?

    @Schema(description = "Wind speed; ten minutes mean", readOnly = true)
    val windSpeed: String?

    @Schema(description = "Pressure reduced to sea level according to standard atmosphere (QNH); current value", readOnly = true)
    val qnhPressure: String?

    @Schema(description = "Gust peak (one second); maximum", readOnly = true)
    val gustPeak: String?

    @Schema(description = "Relative air humidity 2 m above ground; current value", readOnly = true)
    val humidity: String?

    @Schema(description = "Pressure at station level (QFE); current value", readOnly = true)
    val qfePressure: String?

    @Schema(description = "Pressure reduced to sea level (QFF); current value", readOnly = true)
    val qffPressure: String?

    init {
        val values: List<String> = sourceDataRecord.split(";")
        station = StationMap[values[0]]
        code = values[0]
        dateTime = OffsetDateTime.parse(values[1], dateTimeFormatter)
        temperature = replaceDashWithNull(values[2])
        sunshine = replaceDashWithNull(values[4])
        precipitation = replaceDashWithNull(values[3])
        windDirection = replaceDashWithNull(values[8])
        windSpeed = replaceDashWithNull(values[9])
        qnhPressure = replaceDashWithNull(values[13])
        gustPeak = replaceDashWithNull(values[10])
        humidity = replaceDashWithNull(values[6])
        qfePressure = replaceDashWithNull(values[11])
        qffPressure = replaceDashWithNull(values[12])
    }

    private fun replaceDashWithNull(s: String): String? {
        return if ("-" == s) {
            null
        } else {
            s
        }
    }
}
