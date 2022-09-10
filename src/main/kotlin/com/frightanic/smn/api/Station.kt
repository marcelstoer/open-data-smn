package com.frightanic.smn.api

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(description = "SMN station meta data")
data class Station(
    @Schema(description = "3-char all upper-case station code", required = true, readOnly = true)
    val code: String,

    @Schema(description = "Original name in local language", required = true, readOnly = true)
    val name: String,

    @Schema(description = "CH1903 (Swiss grid) y-axis value", required = true, readOnly = true)
    val ch1903Y: Int,

    @Schema(description = "CH1903 (Swiss grid) x-axis value", required = true, readOnly = true)
    val ch1903X: Int,

    @Schema(description = "WGS84 latitude", required = true, readOnly = true)
    val lat: Double,

    @Schema(description = "WGS84 longitude", required = true, readOnly = true)
    val lng: Double,

    @Schema(description = "meters above sea level", required = true, readOnly = true)
    val elevation: Int,
)
