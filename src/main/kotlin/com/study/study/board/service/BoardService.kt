package com.study.study.board.service

import com.study.study.board.dto.BoardDtoResponse
import com.study.study.board.dto.BoardDtosRequsest
import com.study.study.board.dto.SearchDto
import com.study.study.board.repository.BoardRepository
import com.study.study.common.exception.InvalidInputException
import com.study.study.member.entity.Member
import com.study.study.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.collections.ArrayList

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

    /**
     * searchAllBoard
     */

    fun searchAllBoard(): ArrayList<BoardDtoResponse> {
        var boards = boardRepository.findAll()
        var boardDtoList = ArrayList<BoardDtoResponse>()

        for(board in boards) {
            var boardDto = BoardDtoResponse(board.id!!, board.uploadId!!, board.uploadName!!, board.title, board.description, board.uploadDate)
            boardDtoList.add(boardDto)
        }
        return boardDtoList
    }

    /**
     * search Specific Board
     */

    fun searchSpecificBoard(uploadId: String): ArrayList<BoardDtoResponse> {
        var boards = boardRepository.findAllByUploadId(uploadId) ?: throw InvalidInputException("uploadId", "No Register ID, Please Insert loginID.")
        var boardDtoList = ArrayList<BoardDtoResponse>()

        for(board in boards) {
            var boardDto = BoardDtoResponse(board.id!!, board.uploadId!!, board.uploadName!!, board.title, board.description, board.uploadDate)
            boardDtoList.add(boardDto)
        }

        return boardDtoList
    }
}