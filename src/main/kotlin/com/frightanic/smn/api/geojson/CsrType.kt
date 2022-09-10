package com.frightanic.smn.api.geojson

/**
 * Supported CRS types.
 */
enum class CrsType(
    val urn: String
) {
    CH1903("urn:ogc:def:crs:EPSG::21781"),
    WGS84("urn:ogc:def:crs:EPSG::4326");
}
