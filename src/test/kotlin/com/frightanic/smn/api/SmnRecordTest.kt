package com.frightanic.smn.api

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test

/**
 * Tests SmnRecord.
 */
internal class SmnRecordTest {
    @Test
    fun `should detect station`() {
        // given
        val rawData = "HOE;201901061500;-1.9;0.0;0;31;96;-2.4;271;15.1;24.1;898.5;-;1029.2;1573.2;-;-;-;-;-;-;-"
        // when
        val record = SmnRecord(rawData)
        // then
        val station = record.station
        assertThat(station!!.code, `is`(record.code))
        assertThat(station.code, `is`("HOE"))
    }

    @Test
    fun `should replace dash with null`() {
        // given
        val rawData = "HOE;201901061500;-1.9;0.0;0;31;96;-2.4;271;15.1;24.1;898.5;-;1029.2;1573.2;-;-;-;-;-;-;-"
        // when
        val record = SmnRecord(rawData)
        // then
        assertThat(record.qffPressure, `is`(nullValue()))
    }

    @Test
    fun `should map station to null if unknown`() {
        // given
        val rawData = "FOO;201901061500;-1.9;0.0;0;31;96;-2.4;271;15.1;24.1;898.5;-;1029.2;1573.2;-;-;-;-;-;-;-"
        // when
        val record = SmnRecord(rawData)
        // then
        assertThat(record.station, `is`(nullValue()))
    }
}
