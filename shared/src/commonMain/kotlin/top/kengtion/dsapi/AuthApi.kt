package top.kengtion.dsapi

import io.ktor.client.call.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import top.kengtion.dsapi.bean.*

object AuthApi {

    public suspend fun test():Customer{
        val customer: Customer = NetHelper.client.get("http://localhost:8080/customer/3").body<Customer>()
        println("First name: '${customer.firstName}', last name: '${customer.lastName}'")
        return customer
    }

    @Serializable
    data class Customer(val id: Int, val firstName: String, val lastName: String)


    public suspend fun query(): CommonResp<Map<String,CommonQueryData>> {
        val response = NetHelper.client.post {
            contentType(ContentType.Application.Json)
            url {
                protocol = URLProtocol.HTTP
                host = DSConfig.domain ?: ""
                port = 5000
                path("/webapi/query.cgi")
            }
            setBody(
                "api=SYNO.API.Info&method=query&query=all&version=1"
            )
            method = HttpMethod.Post
        }
        val jsonString = response.bodyAsText()
        return CommonResp.fromJSON(jsonString)
    }

    public suspend fun login(userName: String, userPwd: String): String {
        val response = NetHelper.authClient.post {
            url {
                protocol = URLProtocol.HTTP
                host = DSConfig.domain ?: ""
                path("/webapi/auth.cgi")
                port = 5000
            }
            contentType(ContentType.Application.Json)
            setBody(
                AuthReq(
                    account = userName,
                    passwd = userPwd,
                    api = "SYNO.API.Auth",
                    device_name = "DSApi",
                    enable_device_token = "yes",
                    format = "cookie",
                    method = "login",
                    session = "audiostation",
                    version = 6
                )
            )
            method = HttpMethod.Post
        }
        return response.bodyAsText()
    }

}