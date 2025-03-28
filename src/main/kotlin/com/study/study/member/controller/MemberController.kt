package com.study.study.member.controller

import com.study.study.common.dto.BaseResponse
import com.study.study.member.dto.MemberDtoRequest
import com.study.study.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/api/member")
@RestController
class MemberController (private val memberService: MemberService) {
    /**
     * Sign Up
     */
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMsg: String = memberService.signUp(memberDtoRequest)
        return BaseResponse(msg = resultMsg)
    }
}