package com.frightanic.smn.api.geojson

import com.frightanic.smn.api.SmnRecord
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.util.ArrayList

/**
 * Represents the entire data set in GeoJSON format.
 */
@Schema(description = "A GeoJSON feature collection")
class FeatureCollection(crsType: CrsType, smnRecords: Collection<SmnRecord>) {
    val type = "FeatureCollection"
    val features = createFeatures(crsType, smnRecords)
    val crs = Crs(crsType)

    private fun createFeatures(crsType: CrsType, smnRecords: Collection<SmnRecord>): ArrayList<Feature> {
        val features = ArrayList<Feature>(smnRecords.size)
        for (smnRecord in smnRecords) {
            features.add(Feature(crsType, smnRecord))
        }
        return features
    }
}
