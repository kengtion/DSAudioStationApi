package top.kengtion.lib.dsapi.bean

data class SYNOPostBody(
    val api:String,
    val method:String,
    val query:String,
    val version:Int
)