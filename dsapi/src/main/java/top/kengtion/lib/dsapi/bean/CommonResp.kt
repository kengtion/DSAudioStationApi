package top.kengtion.lib.dsapi.bean


data class CommonResp<T> (
    val success:Boolean,
    val data:T
)
