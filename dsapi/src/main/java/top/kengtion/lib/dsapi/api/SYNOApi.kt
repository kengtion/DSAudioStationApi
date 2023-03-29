package top.kengtion.lib.dsapi.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap
import top.kengtion.lib.dsapi.bean.CommonResp
import top.kengtion.lib.dsapi.bean.SYNOPostBody

interface SYNOApi {
    @POST("/webapi/{path}")
    fun <T> commonPostRequest(@Path("path") path:String , @Body body:SYNOPostBody): Flow<CommonResp<T>>

    @POST("/webapi/{path}")
    fun <T> commonGetRequest(@Path("path") path:String , @QueryMap queryData:Map<String,String>): Flow<CommonResp<T>>

}