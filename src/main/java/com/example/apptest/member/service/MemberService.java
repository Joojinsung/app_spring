package com.example.apptest.member.service;

import com.example.apptest.member.entity.MemberEntity;
import com.example.apptest.member.model.LoginRecord;
import com.example.apptest.member.repository.RepositoryMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final RepositoryMember repositoryMember;

    public Optional<MemberEntity> saveMember(LoginRecord user) {
        MemberEntity oldMember = repositoryMember.findByUid(user.uid());
        if (oldMember != null) {

            return Optional.of(oldMember);
        }

        MemberEntity member = MemberEntity.builder()
                .memberName(user.memberName())
                .member_phone(user.phoneNumber())
                .nickname(user.nickname())
                .uid(user.uid())
                .build();

        MemberEntity savedMember = repositoryMember.save(member);
        return Optional.of(savedMember);
    }
}
