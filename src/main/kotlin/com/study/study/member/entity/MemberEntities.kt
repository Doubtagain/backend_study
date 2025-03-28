package com.study.study.member.entity

import com.study.study.common.status.Gender
import com.study.study.common.status.UnivHouseType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])]
)
class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(nullable = false, length = 30, updatable = false)
    var loginId: String,

    @Column(nullable = false, length = 100)
    var password: String,

    @Column(nullable = false, length = 10)
    var name: String,

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    var univHouseType: UnivHouseType,

    @Column(nullable = false, length = 30)
    val email: String,
)