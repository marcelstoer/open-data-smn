package com.frightanic.smn.core

import com.frightanic.smn.ApplicationConfig
import com.frightanic.smn.api.SmnData
import io.quarkus.cache.Cache
import io.quarkus.cache.CacheName
import jakarta.enterprise.context.ApplicationScoped
import org.slf4j.LoggerFactory
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration


@ApplicationScoped
class GeoAdmin(
    @param:CacheName("smn") private val cache: Cache,
    private val applicationConfig: ApplicationConfig
) {
    private val logger = LoggerFactory.getLogger(GeoAdmin::class.java)
    private var lastLoadedSmnData: SmnData? = null
    private val httpClient: HttpClient = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .build()

    fun getSmnData(): SmnData {
        return try {
            cache["smn-data", { loadData() }].await().indefinitely()
        } catch (e: RuntimeException) {
            if (lastLoadedSmnData == null) {
                throw e
            } else {
                logger.warn("Loading data via the cache's data loader failed (cache was empty). " +
                        "Returning last available data set.", e)
                lastLoadedSmnData as SmnData
            }
        }
    }

    private fun loadData(): SmnData {
        logger.info("Loading data from source")
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(applicationConfig.dataUri())
            .GET()
            .build()
        val smnDataString = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body()
        logger.info("Successfully fetched {} bytes", smnDataString.length)
        lastLoadedSmnData = SmnData(smnDataString)
        return lastLoadedSmnData as SmnData
    }
}
