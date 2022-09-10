package com.frightanic.smn

import io.quarkus.runtime.annotations.StaticInitSafe
import io.smallrye.config.ConfigMapping
import java.net.URI

@StaticInitSafe
@ConfigMapping(prefix = "open-data-smn")
interface ApplicationConfig {
    fun dataUri(): URI
}
