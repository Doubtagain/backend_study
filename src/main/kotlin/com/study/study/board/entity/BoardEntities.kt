package com.study.study.board.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import com.study.study.board.dto.BoardDtoResponse

@Entity
class Board (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(nullable = false, length = 30, updatable = false)
    var uploadId: String? = null,

    @Column(nullable = false, length = 30, updatable = false)
    var uploadName: String? = null,

    @Column(nullable = false, length = 100)
    var title: String,

    @Column(nullable = false, length = 3000)
    var description: String,

    @Column(nullable = false)
    var uploadDate: LocalDateTime,

) {
    fun toDto(): BoardDtoResponse =
        BoardDtoResponse(id!!, uploadId!!, uploadName!!, title, description, uploadDate)
}