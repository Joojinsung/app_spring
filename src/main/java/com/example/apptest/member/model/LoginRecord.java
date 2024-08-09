package com.example.apptest.member.model;

import org.antlr.v4.runtime.misc.NotNull;

public record LoginRecord(

        @NotNull
        String uid,
        @NotNull
        String phoneNumber,
        @NotNull
        String memberName,
        String nickname

) {
}
