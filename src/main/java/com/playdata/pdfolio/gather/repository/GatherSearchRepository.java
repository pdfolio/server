package com.playdata.pdfolio.gather.repository;

import com.playdata.pdfolio.domain.dto.gather.SearchDto;
import com.playdata.pdfolio.domain.response.gather.GatherResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface GatherSearchRepository {
    Page<GatherResponse> findAllByCondition(
            PageRequest request,
            SearchDto searchDto
    );

}
