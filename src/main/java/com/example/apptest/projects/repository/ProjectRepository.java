package com.example.apptest.projects.repository;

import com.example.apptest.projects.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
