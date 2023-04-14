package top.kengtion.dsapi.bean

import io.ktor.client.plugins.cookies.*
import io.ktor.http.*

class DSCookieStorage : CookiesStorage {

    var cookieList = mutableListOf<Cookie>()

    override suspend fun addCookie(requestUrl: Url, cookie: Cookie) {
        cookieList = mutableListOf(cookie)
    }

    override suspend fun get(requestUrl: Url): List<Cookie> {
        return cookieList
    }

    override fun close() {

    }
}