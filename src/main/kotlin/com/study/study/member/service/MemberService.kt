package com.study.study.member.service

import com.study.study.common.exception.InvalidInputException
import com.study.study.member.dto.MemberDtoRequest
import com.study.study.member.entity.Member
import com.study.study.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional
@Service
class MemberService (private val memberRepository: MemberRepository) {
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

        return "Success Sign Up";
    }
}