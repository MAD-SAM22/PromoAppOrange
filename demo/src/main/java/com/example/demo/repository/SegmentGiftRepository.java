package com.example.demo.repository;

import com.example.demo.model.SegmentGift;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SegmentGiftRepository extends CrudRepository<SegmentGift, String> {



    @Transactional
    @Query(value = "SELECT * FROM segment_gifts", nativeQuery = true)
    List<SegmentGift> findAllSegmentsAndGifts();

    @Transactional
    @Query(value = "SELECT * FROM segment_gifts WHERE segment = :segment", nativeQuery = true)
    SegmentGift findSegmentGiftBySegment(@Param("segment") String segment);


}
