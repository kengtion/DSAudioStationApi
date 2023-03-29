package top.kengtion.lib.dsapi.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class HttpLogInterceptor : Interceptor {
    companion object {
        private val logger = HttpLogInterceptor()
        fun logger(): Interceptor {
            return logger
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }
}