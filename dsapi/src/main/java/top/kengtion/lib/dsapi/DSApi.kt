package top.kengtion.lib.dsapi

import top.kengtion.lib.dsapi.api.DSAuthApi
import top.kengtion.lib.dsapi.api.DSAuthApiImpl

object DSApi {
    fun getAuthAPi():DSAuthApi{
         return DSAuthApiImpl
    }
}