package com.study.study.common.exception

class InvalidInputException (
    val fieldName: String = "",
    message: String? = "Invalid input",
) : RuntimeException(message)