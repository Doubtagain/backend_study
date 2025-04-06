package com.study.study.board.controller

import com.study.study.board.dto.BoardDtosRequsest
import com.study.study.board.service.BoardService
import com.study.study.common.dto.BaseResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/board")
@RestController
class BoardController (private val boardService: BoardService) {
    /**
     * Upload Board
     */
    @PostMapping("/upload")
    fun upload(@RequestBody @Valid boardDtosRequsest: BoardDtosRequsest): BaseResponse<Unit> {
        val resultMsg: String = boardService.upload(boardDtosRequsest)
        return BaseResponse(msg = resultMsg)
    }
}