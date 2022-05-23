package com.shop.mall.service;

import com.shop.mall.domain.Member;
import com.shop.mall.dto.*;
import com.shop.mall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void authorization(String nickname){
        // 반복되는 어쏘리제이션을 따로 빼서 관리해보자
    }

    @Transactional
    public String memberRegist(MemberRegistRequestDto dto){
        if (!dto.getPassword().equals(dto.getPasswordCheck())){
            return "msg : 패스워드 일치 하지 않음";
        }
        if(memberRepository.existsByEmailOrNickname(dto.getEmail(),dto.getNickname())){
            return "msg : 이메일 혹은 닉네임 중복";
        }
        Member member = new Member(dto.getEmail(),
                dto.getNickname(),
                dto.getAddress(),
                dto.getPassword(),
                0);
        memberRepository.save(member);
        return "msg : 회원가입 완료";
    }

    //로그인
    public MemberLoginResponseDto memberLogin(MemberLoginRequestDto dto) {
        Member member = memberRepository.findByEmailAndPassword(dto.getEmail(),dto.getPassword()).orElseThrow(
                ()->new IllegalArgumentException("not found member")
        );
        MemberLoginResponseDto responseDto = new MemberLoginResponseDto(member.getNickname());
        return responseDto;
    }

    //정보 보기
    public MemberInfoResponseDto memberInfo(String nickname) {
        Member member = memberRepository.findByNickname(nickname).orElseThrow(
                ()->new IllegalArgumentException("not found nickname")
        );
        MemberInfoResponseDto responseDto = new MemberInfoResponseDto(member.getNickname(),
                member.getAddress(),member.getCash());
        return responseDto;
    }

    @Transactional
    public MemberCashResponseDto cashCharge(String nickname, int chargeCash) {
        Member member = memberRepository.findByNickname(nickname).orElseThrow(
                ()->new IllegalArgumentException("not found nickname")
        );
        int totalCash = member.charge(chargeCash);
        MemberCashResponseDto responseDto = new MemberCashResponseDto(totalCash);
        return responseDto;
    }

    @Transactional
    public MemberAddressResponseDto addressChange(String nickname, String afterAddress) {
        Member member = memberRepository.findByNickname(nickname).orElseThrow(
                ()->new IllegalArgumentException("not found nickname")
        );
        member.addressUpdate(afterAddress);
        MemberAddressResponseDto responseDto = new MemberAddressResponseDto(afterAddress);
        return responseDto;
    }

    @Transactional
    public MemberNameResponseDto nameChange(String nickname, String afterName) {
        Member member = memberRepository.findByNickname(nickname).orElseThrow(
                ()->new IllegalArgumentException("not found nickname")
        );
        member.nameUpdate(afterName);
        MemberNameResponseDto responseDto = new MemberNameResponseDto(afterName);
        return responseDto;
    }

    @Transactional
    public String memberDelete(String nickname) {
        memberRepository.deleteByNickname(nickname).orElseThrow(
                ()->new IllegalArgumentException("not found nickname")
        );
        return "msg : 회원 탈퇴 완료";
    }
}
