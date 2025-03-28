package com.study.study.common.status

enum class UnivHouseType (val type: String) {
    GOUNA("고운A"),
    GOUNB("고운B"),
    GOUNC("고운C"),
    KYS11("경상11"),
    KYS12("경상12"),
    KYS13("경상13"),
    KYS14("경상14"),
}

enum class Gender (val desc: String) {
    MAN("남"),
    WOMAN("여"),
}

enum class ResultCode (val msg: String) {
    SUCCESS("Process Succeed."),
    ERROR("Process Failed."),
}