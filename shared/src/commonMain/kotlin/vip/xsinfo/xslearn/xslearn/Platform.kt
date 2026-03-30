package vip.xsinfo.xslearn.xslearn

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform