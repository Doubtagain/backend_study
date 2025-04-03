package com.study.study.member.service

import com.study.study.common.exception.InvalidInputException
import com.study.study.common.status.ROLE
import com.study.study.member.dto.MemberDtoRequest
import com.study.study.member.entity.Member
import com.study.study.member.entity.MemberRole
import com.study.study.member.repository.MemberRepository
import com.study.study.member.repository.MemberRoleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository
) {
    /**
     * Sign Up
     */

    fun signUp(memberDtoRequest: MemberDtoRequest):String{
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if (member != null){
            throw InvalidInputException("loginId", "Already Register ID")
        }

        member = memberDtoRequest.toEntity()
        memberRepository.save(member)

        val memberRole: MemberRole = MemberRole(null, ROLE.MEMBER, member)
        memberRoleRepository.save(memberRole)

        return "Success Sign Up";
    }
}