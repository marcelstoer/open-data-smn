package com.frightanic.smn.api.geojson

import com.frightanic.smn.api.SmnRecord
import com.frightanic.smn.api.Station

/**
 * Representation of a single feature within a feature collection.
 */
@Suppress("MemberVisibilityCanBePrivate")
class Feature(crs: CrsType, val properties: SmnRecord){
    val type = "Feature"
    val geometry: Geometry = createGeometry(crs, properties.station)

    private fun createGeometry(crs: CrsType, station: Station?): Geometry {
        val coordinates: Array<Number> = if (crs === CrsType.WGS84){
            // lat/lng are inverted according to GeoJSON spec: http://geojson.org/geojson-spec.html#id2
            arrayOf(station!!.lng, station.lat)
        } else {
            arrayOf(station!!.ch1903X, station.ch1903Y)
        }
        return Geometry(coordinates)
    }
}
