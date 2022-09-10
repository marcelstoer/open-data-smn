package com.frightanic.smn.api.geojson

import com.frightanic.smn.api.geojson.CrsType.CH1903
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

/**
 * Tests Crs.
 */
internal class CrsTest {
    @Test
    fun `should have type member with value name`() {
        // given
        val crs = Crs(CH1903)
        // when
        // then
        assertThat(crs.type, `is`("name"))
    }

    @Test
    fun `should place CRS type URN in property with key name`() {
        // given
        val crs = Crs(CH1903)
        // when
        // then
        assertThat(crs.properties["name"], `is`(CH1903.urn))
    }
}
