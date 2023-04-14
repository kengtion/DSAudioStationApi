package top.kengtion.dsapi

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.api.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object NetHelper {

    private val headerPlugin = createClientPlugin("HeaderPlugin") {
        onRequest { request, _ ->
            request.headers.append("User-Agent", "DS Audio 5.16.3")
        }
    }

    public val client = HttpClient() {
        install(headerPlugin)
        install(ContentEncoding) {
            deflate(1.0f)
            gzip(0.9f)
        }
        expectSuccess = true
        install(HttpCookies)
        install(ContentNegotiation) {
            json(Json {//TODO find out why this not working
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.log(
                        priority = io.github.aakira.napier.LogLevel.INFO,
                        tag = "DSClient",
                        message = message
                    )
                }
            }
            level = LogLevel.ALL
        }
    }


    public val authClient = HttpClient() {
        install(headerPlugin)
//        install(ContentEncoding) {
//            deflate(1.0f)
//            gzip(0.9f)
//        }
        install(ContentNegotiation) {
            json(json = Json)
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.log(
                        priority = io.github.aakira.napier.LogLevel.INFO,
                        tag = "AuthClient",
                        message = message
                    )
                }
            }
            level = LogLevel.ALL
        }
    }


}