package com.example.apptest.member.controller;

import ch.qos.logback.core.status.Status;
import com.example.apptest.member.model.LoginRecord;
import com.example.apptest.member.service.MemberService;
import com.example.apptest.projects.model.AddProjectDTO;
import com.example.apptest.projects.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/submitUserData")
    public ResponseEntity<Status> submitUserData(@RequestBody LoginRecord user) {

        memberService.saveMember(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
