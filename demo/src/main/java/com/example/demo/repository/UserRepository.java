package com.example.demo.repository;

import com.example.demo.model.user;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<user, Long> {


    Optional<user> findById(@Param("id") Long id);

    @Query("SELECT u FROM user u WHERE u.dial = :dial")
    Optional<user> findByDial(@Param("dial") String dial);

    @Query("SELECT u FROM user u")
    List<user> findAllUsers();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users (id, doi, previous_gifts_id, gift_id) " +
            "VALUES (:id, :doi, :previous_gifts_id, :gift_id)", nativeQuery = true)
    void insertUser(@Param("id") Long id,
                    @Param("doi") Date doi,
                    @Param("previous_gifts_id") Integer previousGiftsId,
                    @Param("gift_id") Integer giftId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE \"user\" u SET u.doi = :doi, u.previousGiftsId = :previousGiftsId, u.giftId = :giftId WHERE u.id = :id",nativeQuery = true)
    void updateUser(@Param("id") Long id, @Param("doi") Date doi, @Param("previousGiftsId") Integer previousGiftsId, @Param("giftId") Integer giftId);



    @Modifying
    @Query("DELETE FROM user u WHERE u.id = :id")
    void deleteUser(@Param("id") Long id);
}
