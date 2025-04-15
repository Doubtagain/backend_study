package com.study.study.board.service

import com.study.study.board.dto.BoardDtosRequsest
import com.study.study.board.repository.BoardRepository
import com.study.study.common.exception.InvalidInputException
import com.study.study.member.entity.Member
import com.study.study.member.dto.MemberDtoRequest
import com.study.study.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class BoardService (
    private val boardRepository: BoardRepository,
    private val memberRepository: MemberRepository,
) {
    /**
     * Upload Board
     */

    fun upload(boardDtosRequsest: BoardDtosRequsest):String{
        var member: Member? = memberRepository.findByLoginId(boardDtosRequsest.uploadId)

        if (member == null){
            throw InvalidInputException("loginId", "No Register ID, Please Login.")
        }

        var board = boardDtosRequsest.toEntity()
        boardRepository.save(board)

        return "Success Upload Board"
    }
}