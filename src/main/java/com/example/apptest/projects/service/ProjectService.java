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

    public boolean createProjectWithFiles(AddProjectDTO projectDTO, List<MultipartFile> images) {
        try {
            // 파일 저장 및 경로 수집
            List<String> imagePaths = images.stream()
                    .map(this::saveFile)
                    .collect(Collectors.toList());

            // 프로젝트 저장
            Project project = mapToEntity(projectDTO, imagePaths);
            projectRepository.save(project);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String saveFile(MultipartFile file) {
        try {
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/files";
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());
            return filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Project mapToEntity(AddProjectDTO dto, List<String> imagePaths) {
        Project project = new Project();
        project.setProductName(dto.productName());
        project.setProductPrice(dto.productPrice());
        project.setDescription(dto.description());
        project.setDeadLine(dto.deadLine());
        project.setMakerDate(dto.makerDate());
        project.setTransactionType(dto.transactionType());
        project.setQuantity(dto.quantity());
        project.setImagePaths(imagePaths); // 이미지 경로 추가
        return project;
    }
}
