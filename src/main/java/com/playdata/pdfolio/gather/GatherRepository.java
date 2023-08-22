package com.playdata.pdfolio.gather;

import com.playdata.pdfolio.domain.entity.gather.Gather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatherRepository extends JpaRepository<Gather, Long> {

}
