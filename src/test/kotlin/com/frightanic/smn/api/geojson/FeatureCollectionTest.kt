package com.frightanic.smn.api.geojson

import com.frightanic.smn.api.SmnRecord
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Tests FeatureCollection.
 */
internal class FeatureCollectionTest {
    private lateinit var smnRecord: SmnRecord

    @BeforeEach
    fun setup() {
        smnRecord = SmnRecord("TAE;201901061500;1.9;0.0;0;53;90;0.4;228;5.4;10.4;967.7;1034.1;1031.8;-;-;-;-;-;-;-;-")
    }

    @Test
    fun `should have 'type' member with value 'FeatureCollection'`() {
        // given
        val featureCollection = FeatureCollection(CrsType.CH1903, listOf(smnRecord))
        // when
        // then
        assertThat(featureCollection.type, `is`("FeatureCollection"))
    }

    @Test
    fun `should add 'SmnRecord's as features`() {
        // given
        val featureCollection = FeatureCollection(
            CrsType.CH1903, listOf(smnRecord, smnRecord)
        )
        // when
        // then
        assertThat(featureCollection.features.size, `is`(2))
    }
}
