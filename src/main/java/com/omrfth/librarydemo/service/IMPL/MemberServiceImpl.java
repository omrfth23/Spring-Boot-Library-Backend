package com.omrfth.librarydemo.service.IMPL;

import com.omrfth.librarydemo.model.Member;
import com.omrfth.librarydemo.repository.MemberRepository;
import com.omrfth.librarydemo.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.findById(id).get();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateBook(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(int id) {
        memberRepository.deleteById(id);
    }
}
