package top.kengtion.dsapi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform