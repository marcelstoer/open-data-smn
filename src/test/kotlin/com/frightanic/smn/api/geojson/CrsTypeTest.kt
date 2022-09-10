package com.frightanic.smn.api.geojson

import com.frightanic.smn.api.geojson.CrsType.CH1903
import com.frightanic.smn.api.geojson.CrsType.WGS84

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.core.Is
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests CrsType.
 */
internal class CrsTypeTest {
    @Test
    fun `should have OGN URN 4326 for WGS84`() {
        // given
        // when
        // then
        assertThat(WGS84.urn, `is`("urn:ogc:def:crs:EPSG::4326"))
    }

    @Test
    fun `should have OGN URN 21781 for CH1903`() {
        // given
        // when
        // then
        assertThat(CH1903.urn, `is`("urn:ogc:def:crs:EPSG::21781"))
    }
}
