package com.study.study.board.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Board (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 30, updatable = false)
    var uploadId: String,

    @Column(nullable = false, length = 100)
    var title: String,

    @Column(nullable = false, length = 3000)
    var description: String,

    @Column(nullable = false)
    var uploadDate: LocalDateTime,
)