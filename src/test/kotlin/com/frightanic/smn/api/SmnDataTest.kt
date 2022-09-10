package com.frightanic.smn.api

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasSize
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

/**
 * Tests .
 */
internal class SmnDataTest {
    @Test
    fun `should skip the column header row and other metadata`() {
        // given
        val rawData =
            """
                some arbitrary not real-world metadata
                
                Station/Location;Date;tre200s0;rre150z0;sre000z0;gre000z0;ure200s0;tde200s0;dkl010z0;fu3010z0;fu3010z1;prestas0;pp0qffs0;pp0qnhs0;ppz850s0;ppz700s0;dv1towz0;fu3towz0;fu3towz1;ta1tows0;uretows0;tdetows0
                TAE;201901061500;1.9;0.0;0;53;90;0.4;228;5.4;10.4;967.7;1034.1;1031.8;-;-;-;-;-;-;-;-
            """.trimIndent()
        // when
        val data = SmnData(rawData)
        // then
        assertThat(data.getAllRecords(), hasSize(1))
        assertThat(data.getRecordFor("TAE")!!.code, `is`("TAE"))
    }

    @Test
    fun `should parse sample input`() {
        // given
        val inputString = SmnDataTest::class.java.getResource("/VQHA80.csv")!!.readText()
        // when
        val data = SmnData(inputString)
        // then
        assertThat(data.getAllRecords(), hasSize(158))
        assertThat(data.getRecordFor("TAE")!!.code, `is`("TAE")) // first
        assertThat(data.getRecordFor("KLO")!!.code, `is`("KLO")) // last
    }
}
