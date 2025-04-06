package com.study.study.member.service

import com.study.study.common.authority.JwtTokenProvider
import com.study.study.common.authority.TokenInfo
import com.study.study.common.exception.InvalidInputException
import com.study.study.common.status.ROLE
import com.study.study.member.dto.LoginDto
import com.study.study.member.dto.MemberDtoRequest
import com.study.study.member.entity.Member
import com.study.study.member.entity.MemberRole
import com.study.study.member.repository.MemberRepository
import com.study.study.member.repository.MemberRoleRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder
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

    /**
     * Login -> Generate Token
     */
    fun login(loginDto: LoginDto): TokenInfo{
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.loginId, loginDto.password)
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        return jwtTokenProvider.createToken(authentication)
    }
}