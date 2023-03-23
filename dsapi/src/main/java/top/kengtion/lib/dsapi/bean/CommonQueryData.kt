package top.kengtion.lib.dsapi.bean

data class CommonQueryData(
    val maxVersion:Int,
    val minVersion:Int,
    val path:String,
    val requestFormat:String?
)