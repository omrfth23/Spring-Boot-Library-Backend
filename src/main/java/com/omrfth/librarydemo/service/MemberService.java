package com.omrfth.librarydemo.service;

import com.omrfth.librarydemo.model.Book;
import com.omrfth.librarydemo.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();

    Member getMemberById(int id);

    Member saveMember(Member member);

    Member updateBook(Member member);

    void deleteMemberById(int id);
}
