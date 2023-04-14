package top.kengtion.dsapi.bean

@kotlinx.serialization.Serializable
data class AuthResp(
    val is_portal_port: Boolean,
    val sid: String
)