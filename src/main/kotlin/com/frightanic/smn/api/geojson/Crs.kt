package com.frightanic.smn.api.geojson

/**
 * Coordinate reference system (CRS) of a GeoJSON object
 */
class Crs(crs: CrsType) {
    val type = "name"
    val properties: Map<String, String> = mapOf("name" to crs.urn)
}
