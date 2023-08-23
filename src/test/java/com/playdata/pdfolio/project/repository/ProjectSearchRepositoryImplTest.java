package com.playdata.pdfolio.project.repository;

import com.playdata.pdfolio.RepositoryTest;
import com.playdata.pdfolio.domain.request.project.ProjectSearchParameter;
import org.junit.jupiter.api.Test;

class ProjectSearchRepositoryImplTest extends RepositoryTest {

    @Test
    void test() {
        ProjectSearchParameter parameter = ProjectSearchParameter
                .of("1", "10", "createdAt", "JAVA");

//        assertThat(projectSearchRepository.findAllProjectByCondition(parameter)).hasSize(1);
        projectRepository.findAllProjectByCondition(parameter).forEach(System.out::println);
    }
}