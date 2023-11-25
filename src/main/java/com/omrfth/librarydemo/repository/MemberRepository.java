package com.omrfth.librarydemo.repository;

import com.omrfth.librarydemo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer>{
}
