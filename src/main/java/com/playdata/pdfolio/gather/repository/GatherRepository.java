package com.playdata.pdfolio.gather.repository;

import com.playdata.pdfolio.domain.entity.gather.Gather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GatherRepository extends JpaRepository <Gather,Long> {
    @Query("select g from Gather g " +
            "where g.id = :id and g.isDeleted = false")
    Optional<Gather> findByGather(@Param("id") Long id);
}
