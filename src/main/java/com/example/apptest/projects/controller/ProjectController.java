package com.example.apptest.projects.controller;

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
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping(value = "/addItem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, Object>> createProject(
            @RequestPart("projectDTO") AddProjectDTO projectDTO,
            @RequestPart("images") List<MultipartFile> images) {

        Map<String, Object> response = new HashMap<>();
        try {
            List<String> imageUrls = projectService.createProjectWithFiles(projectDTO, images);
            response.put("status", true);
            response.put("message", "Project created successfully");
            response.put("body", imageUrls);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", false);
            response.put("message", "An error occurred while creating the project");
            response.put("body", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}