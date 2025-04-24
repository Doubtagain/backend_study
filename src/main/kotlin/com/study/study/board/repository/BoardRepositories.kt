package com.study.study.board.repository

import com.study.study.board.dto.BoardDtoResponse
import com.study.study.board.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long>{
    fun findByUploadId(uploadId: String?): Board
    fun findAllByUploadId(uploadId: String): ArrayList<BoardDtoResponse>
}