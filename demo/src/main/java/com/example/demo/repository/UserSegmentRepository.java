package com.example.demo.repository;

import com.example.demo.model.UserSegment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSegmentRepository extends CrudRepository <UserSegment, Long> {


    @Transactional
    @Query(value = "SELECT * FROM user_segments where dial = :dial", nativeQuery = true)
    Optional<UserSegment> findUserByDial(@Param("dial") String dial);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_segments (user_id, dial, segment) " +
            "VALUES (:user_id, :dial, :segment)", nativeQuery = true)
    void setSegmentToUser(@Param("user_id") Integer userId, @Param("dial") String dial, @Param("segment") String segment);

    @Transactional
    @Modifying
    @Query(value = "UPDATE \"user_segment\" u SET u.user_id = :user_id, u.dial = :dial, u.segment = :segment WHERE u.user_id = :user_id",nativeQuery = true)
    void updateUserSegment(@Param("user_id") Integer user_id, @Param("dial") String dial, @Param("segment") String segment);


    @Override
    Iterable<UserSegment> findAll();


}
