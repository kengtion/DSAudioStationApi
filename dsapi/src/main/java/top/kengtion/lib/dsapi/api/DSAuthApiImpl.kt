package top.kengtion.lib.dsapi.api

import kotlinx.coroutines.flow.Flow
import top.kengtion.lib.dsapi.bean.CommonQueryData
import top.kengtion.lib.dsapi.bean.CommonResp

object DSAuthApiImpl : DSAuthApi{

    fun query(host:String): Flow<CommonResp<Map<String,CommonQueryData>>>{

    }
}