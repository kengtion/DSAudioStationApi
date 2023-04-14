package top.kengtion.dsapi.bean

@kotlinx.serialization.Serializable
data class SYNOPostBody(
    val api:String,
    val method:String,
    val query:String,
    val version:Int
)