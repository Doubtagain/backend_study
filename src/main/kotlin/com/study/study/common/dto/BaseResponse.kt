package com.study.study.common.dto

import com.study.study.common.status.ResultCode

data class BaseResponse<T>(
    val resultCode: String = ResultCode.SUCCESS.name,
    val data: T? = null,
    val msg: String = ResultCode.SUCCESS.msg,
)