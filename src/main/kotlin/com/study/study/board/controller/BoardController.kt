package com.study.study.board.controller

import com.study.study.board.dto.BoardDtosRequsest
import com.study.study.board.service.BoardService
import com.study.study.common.dto.BaseResponse
import com.study.study.common.dto.CustomUser
import com.study.study.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/board")
@RestController
class BoardController (private val boardService: BoardService, private val memberService: MemberService) {
    /**
     * Upload Board
     */
    @PostMapping("/upload")
    fun upload(@RequestBody @Valid boardDtosRequsest: BoardDtosRequsest): BaseResponse<Unit> {
        val userId = (SecurityContextHolder.getContext().authentication.principal as CustomUser).userId
        val response = memberService.searchMyInfo(userId)
        boardDtosRequsest.uploadId = response.loginId
        val resultMsg: String = boardService.upload(boardDtosRequsest)

        return BaseResponse(msg = resultMsg)
    }
}