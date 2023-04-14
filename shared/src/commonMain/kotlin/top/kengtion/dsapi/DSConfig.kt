package top.kengtion.dsapi

object DSConfig {

    public var domain: String? = null
    public var cookieId: String? = null

    public fun getCookie(): String {
        return "id=${cookieId}"
    }

}

