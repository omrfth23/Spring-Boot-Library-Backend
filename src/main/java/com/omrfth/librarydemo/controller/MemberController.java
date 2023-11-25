package com.omrfth.librarydemo.controller;

import com.omrfth.librarydemo.model.Member;
import com.omrfth.librarydemo.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable int id){
        return memberService.getMemberById(id);
    }

    @PostMapping("/members")
    public Member saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @PutMapping("/members/{id}")
    public Member updateMember(@RequestBody Member member){
        return memberService.updateBook(member);
    }

    @DeleteMapping("/members/{id}")
    public String deleteMemberById(@PathVariable int id){
        memberService.deleteMemberById(id);
        return "Member with id: " + id + " has been deleted.";
    }
}
