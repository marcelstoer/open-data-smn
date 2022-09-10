package com.frightanic.smn.api

/**
 * Represents the entire data set for a point in time.
 */
class SmnData(sourceData: String) {
    private val smnRecords = sourceData
        .split("\n")
        .map { it.trim() }
        .filter {
            it.isNotEmpty() &&
            // Skip any non-data line (comments, column headers, etc.).
            // Line has to start with the 3-char station code.
            // Example below:
            /*
             * Station/Location;Date;tre200s0;rre150z0;sre000z0;gre000z0;ure200s0;tde200s0;dkl010z0;fu3010z0;fu3010z1;prestas0;pp0qffs0;pp0qnhs0;ppz850s0;ppz700s0;dv1towz0;fu3towz0;fu3towz1;ta1tows0;uretows0;tdetows0
             * TAE;202208280630;16.50;0.00;0.00;41.00;98.90;16.30;22.00;2.90;5.40;954.10;1016.10;1017.40;-;-;-;-;-;-;-;-
             * COM;202208280630;14.50;0.00;0.00;27.00;84.60;11.90;329.00;5.40;7.90;948.70;1015.20;1016.20;-;-;-;-;-;-;-;-
             */
            it.matches(Regex("^[A-Z]{3};.*\$"))
        }
        .associate {
            val record = SmnRecord(it)
            record.code to record
        }

    fun getAllRecords() = smnRecords.values

    fun getRecordFor(code: String)= smnRecords[code]
}
