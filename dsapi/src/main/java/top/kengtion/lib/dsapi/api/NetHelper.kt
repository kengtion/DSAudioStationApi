package top.kengtion.lib.dsapi.api

import me.sianaki.flowretrofitadapter.FlowCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import top.kengtion.lib.dsapi.interceptors.CookieInterceptor
import top.kengtion.lib.dsapi.interceptors.HttpLogInterceptor

object NetHelper {
    private val clientMap:MutableMap<String,Retrofit> = mutableMapOf()

    public fun getClient(domain:String) : Retrofit{
        var client = clientMap[domain]
        if(client == null){
            client = buildClient(domain)
            clientMap[domain] = client
        }
        return client
    }

    private fun buildClient(domain:String):Retrofit{
        val client = OkHttpClient.Builder()
            .addInterceptor(CookieInterceptor())
            .addInterceptor(HttpLogInterceptor.Companion.logger())
            .build()
        return Retrofit.Builder()
            .client(client)
            .baseUrl(domain)
            .addCallAdapterFactory(FlowCallAdapterFactory.create())
            .build()
    }
}