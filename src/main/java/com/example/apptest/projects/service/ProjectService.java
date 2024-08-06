package com.example.apptest.projects.service;

import com.example.apptest.projects.model.AddProjectDTO;
import com.example.apptest.projects.entity.Project;
import com.example.apptest.projects.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    // 서버에서의 기본 파일 경로와 URL 경로 설정
    private final String uploadDir = "/src/main/resources/static/files";
    private final String baseUrl = "https://port-0-app-spring-lzi5bu5ddf0ec5b5.sel4.cloudtype.app/files/";

    public List<String> createProjectWithFiles(AddProjectDTO projectDTO, List<MultipartFile> images) {
        try {
            // 파일 저장 및 경로 수집
            List<String> imageUrls = images.stream()
                    .map(this::saveFile)
                    .collect(Collectors.toList());

            // 프로젝트 저장
            Project project = mapToEntity(projectDTO, imageUrls);
            projectRepository.save(project);
            return imageUrls;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String saveFile(MultipartFile file) {
        try {
            // 파일 저장 경로 설정
            Path uploadPath = Paths.get(System.getProperty("user.dir") + uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());

            // 파일의 URL을 반환
            return baseUrl + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Project mapToEntity(AddProjectDTO dto, List<String> imageUrls) {
        Project project = new Project();
        project.setProductName(dto.productName());
        project.setProductPrice(dto.productPrice());
        project.setDescription(dto.description());
        project.setDeadLine(dto.deadLine());
        project.setMakerDate(dto.makerDate());
        project.setTransactionType(dto.transactionType());
        project.setQuantity(dto.quantity());
        project.setImagePaths(imageUrls); // 이미지 경로 추가
        return project;
    }

}