package com.playdata.pdfolio.project.repository;

import com.playdata.pdfolio.domain.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
