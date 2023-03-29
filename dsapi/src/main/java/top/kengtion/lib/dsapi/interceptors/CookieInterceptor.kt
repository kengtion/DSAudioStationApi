package top.kengtion.lib.dsapi.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class CookieInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request()) // TODO: insert cookie
    }

}