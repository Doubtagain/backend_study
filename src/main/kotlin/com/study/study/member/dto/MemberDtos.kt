package com.study.study.member.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.study.study.common.annotation.ValidEnum
import com.study.study.common.status.UnivHouseType
import com.study.study.member.entity.Member
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class MemberDtoRequest (
    val id: Long?,

    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,

    @field:NotBlank
    @field:Pattern(
        regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[a-zA-Z0-9!@#\$%^&*]{8,20}\$",
        message = "Involve Alphabet, Number, Special Char and limited 8~20 char"
    )
    @JsonProperty("password")
    private val _password: String?,

    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,
    @field:NotBlank
    @field:ValidEnum(enumClass = UnivHouseType::class, message = "Choose MAN or WOMAN")
    @JsonProperty("univHouseType")
    private val _univHouseType: String?,

    @field:NotBlank
    @field:Email
    @JsonProperty("email")
    private val _email: String?,
) {
    val loginId: String
        get() = _loginId!!
    val password: String
        get() = _password!!
    val name: String
        get() = _name!!
    val univHouseType : UnivHouseType
        get() = UnivHouseType.valueOf(_univHouseType!!)
    val email : String
        get() = _email!!

    fun toEntity(): Member =
        Member(id, loginId, password, name, univHouseType, email)
}

