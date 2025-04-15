package com.study.study.board.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.study.study.board.entity.Board
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class BoardDtosRequsest (
    var id: Long?,

    @JsonProperty("uploadId")
    var uploadId: String?,

    @JsonProperty("uploadName")
    var uploadName: String?,

    @field:NotBlank
    @JsonProperty("title")
    private val _title: String?,

    @field:NotBlank
    @JsonProperty("description")
    private val _description: String?,

    @field:NotBlank
    @JsonProperty("uploadDate")
    private val _uploadDate: String?,
) {
    val title: String
        get() = _title!!
    val description: String
        get() = _description!!
    val uploadDate: LocalDateTime
        get() = _uploadDate!!.toLocalDateTime()

    fun toEntity(): Board =
        Board(id, uploadId, uploadName, title, description, uploadDate)

    private fun String.toLocalDateTime(): LocalDateTime =
        LocalDateTime.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
}

/**
 * Add BoardInfoFunction Later.
data class BoardDtoResponse(
    val id: Long,
    var uploadId: String,
    val title: String,
    val description: String,
    val uploadDate: LocalDateTime,
)
 */