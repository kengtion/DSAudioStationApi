package top.kengtion.dsapi.bean

@kotlinx.serialization.Serializable
data class AuthReq(
    val account: String,
    val api: String,
    val device_name: String,
    val enable_device_token: String,
    val format: String,
    val method: String,
    val passwd: String,
    val session: String,
    val version: Int
) {
}