package com.example.apptest.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "member")
@Setter
@RequiredArgsConstructor
public class MemberEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_phone")
    private String member_phone;

    @Column(name = "member_uid", unique = true)
    private String uid;

    @Column(name = "nick_name", unique = true)
    private String nickname;

    @Builder
    public MemberEntity(Long id, String memberName, String member_phone, String uid, String nickname) {
        this.memberName = memberName;
        this.member_phone = member_phone;
        this.uid = uid;
        this.nickname = nickname;
    }
}

