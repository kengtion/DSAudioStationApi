package top.kengtion.dsapi.bean

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

@kotlinx.serialization.Serializable
data class CommonResp<T>(
    val success: Boolean,
    val data: T
) {
    /**
     * content ContentNegotiation not working , manual serialization instead
     */
    companion object {
        @OptIn(ExperimentalSerializationApi::class)
        val jsonConverter = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
            explicitNulls = false
        }

        inline fun <reified T> fromJSON(json: String): T {
            return jsonConverter.decodeFromString(json)
        }
    }

}
