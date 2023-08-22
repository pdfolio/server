package com.playdata.pdfolio.project;

import com.playdata.pdfolio.domain.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
