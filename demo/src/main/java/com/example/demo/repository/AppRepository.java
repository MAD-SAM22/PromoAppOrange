package com.example.demo.repository;

import com.example.demo.model.user;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AppRepository extends CrudRepository<user, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE users  SET previous_gifts_id = :previousGiftsId, gift_id = :giftId WHERE id = :id", nativeQuery = true)
    void firstDownload(@Param("id") Long id, @Param("previousGiftsId") Integer previousGiftsId, @Param("giftId") Integer giftId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users  SET previous_gifts_id = :giftId, gift_id = :giftId+1 WHERE id = :id", nativeQuery = true)
    void billpay(@Param("id") Long id,  @Param("giftId") Integer giftId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users ( dial,doi, previous_gifts_id, gift_id) " +
            "VALUES (:dial, :doi, :previous_gifts_id, :gift_id)", nativeQuery = true)
    void createNewUser(@Param("dial") String dial,
                    @Param("doi") Date doi,
                    @Param("previous_gifts_id") Integer previousGiftsId,
                    @Param("gift_id") Integer giftId);

}
