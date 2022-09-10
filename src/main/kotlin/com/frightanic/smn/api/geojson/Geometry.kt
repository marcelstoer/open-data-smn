package com.frightanic.smn.api.geojson

/**
 * Each feature has a 'Point' geometry with coordinates based on the selected CRS.
 */
class Geometry(val coordinates: Array<Number>) {
    val type = "Point"
}
