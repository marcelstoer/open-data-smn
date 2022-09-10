package com.frightanic.smn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test

/**
 * Tests StationMap.
 */
internal class StationMapTest {
    @Test
    fun `should return null for unknown code`() {
        // given
        // when
        // then
        assertThat(StationMap["fooBar4711"], `is`(nullValue()))
    }

    @Test
    fun `should return null for lower case codes`() {
        // given
        // when
        // then
        assertThat(StationMap["hoe"], `is`(nullValue()))
    }

    @Test
    fun `should return station for valid upper-case code`() {
        // given
        // when
        // then
        assertThat(StationMap["HOE"]!!.code, `is`("HOE"))
    }
}
