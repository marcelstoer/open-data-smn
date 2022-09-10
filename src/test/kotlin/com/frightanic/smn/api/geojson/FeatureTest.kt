package com.frightanic.smn.api.geojson

import com.frightanic.smn.api.SmnRecord
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Tests Feature.
 */
internal class FeatureTest {
    private lateinit var smnRecord: SmnRecord

    @BeforeEach
    fun setup() {
        smnRecord = SmnRecord("TAE;201901061500;1.9;0.0;0;53;90;0.4;228;5.4;10.4;967.7;1034.1;1031.8;-;-;-;-;-;-;-;-")
    }

    @Test
    fun `should have type member with value feature`() {
        // given
        val feature = Feature(CrsType.CH1903, smnRecord)
        // when
        // then
        assertThat(feature.type, `is`("Feature"))
    }

    @Test
    fun `should use 'SmnRecord' for 'properties' member`() {
        // given
        val feature = Feature(CrsType.CH1903, smnRecord)
        // when
        // then
        assertThat(feature.properties, `is`(smnRecord))
    }

    @Test
    fun `should use CH1903 coordinates if CRS type is CH1903`() {
        // given
        val feature = Feature(CrsType.CH1903, smnRecord)
        // when
        val geometry = feature.geometry
        // then
        assertThat(geometry.coordinates[0], `is`(smnRecord.station!!.ch1903X))
        assertThat(geometry.coordinates[1], `is`(smnRecord.station!!.ch1903Y))
    }

    @Test
    fun `should use WGS84 coordinates if CRS type is WGS84`() {
        // given
        val feature = Feature(CrsType.WGS84, smnRecord)
        // when
        val geometry = feature.geometry
        // then
        assertThat(geometry.coordinates[0], `is`(smnRecord.station!!.lng))
        assertThat(geometry.coordinates[1], `is`(smnRecord.station!!.lat))
    }
}
