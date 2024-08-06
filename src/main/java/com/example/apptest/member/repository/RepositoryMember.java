package com.example.apptest.member.repository;


import com.example.apptest.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMember extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByUid(String uid);

}
