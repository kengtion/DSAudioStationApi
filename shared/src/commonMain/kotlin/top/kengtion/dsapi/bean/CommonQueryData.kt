package top.kengtion.dsapi.bean

@kotlinx.serialization.Serializable
data class CommonQueryData(
    val maxVersion:Int,
    val minVersion:Int,
    val path:String,
    val requestFormat:String?
) {
}