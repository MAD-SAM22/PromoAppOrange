package com.example.demo.repository;

import com.example.demo.model.gift;
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

@Table
@Repository
public interface GiftRepository extends CrudRepository <gift,Long>{

    @Query("SELECT g FROM gift g WHERE g.giftId = :giftId")
    Optional<gift> findById(@Param("giftId") Long giftId);

    @Query("SELECT g FROM gift g")
    List<gift> findAllGifts();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO gift (gift_id, description, max_bonus, validity, capping, service_classes, offer_availability, expiry_date) " +
            "VALUES (:giftId, :description, :maxBonus, :validity, :capping, :serviceClasses, :offerAvailability, :expiryDate)", nativeQuery = true)
    void insertGift(@Param("giftId") Long giftId, @Param("description") String description, @Param("maxBonus") Float maxBonus,
                    @Param("validity") int validity, @Param("capping") String capping, @Param("serviceClasses") String serviceClasses,
                    @Param("offerAvailability") String offerAvailability, @Param("expiryDate") Date expiryDate);

    @Modifying
    @Query("UPDATE gift g SET g.description = :description, g.maxBonus = :maxBonus, g.validity = :validity, g.capping = :capping, " +
            "g.serviceClasses = :serviceClasses, g.offerAvailability = :offerAvailability, g.expiryDate = :expiryDate WHERE g.giftId = :giftId")
    void updateGift(@Param("giftId") Long giftId, @Param("description") String description, @Param("maxBonus") Float maxBonus,
                    @Param("validity") int validity, @Param("capping") String capping, @Param("serviceClasses") String serviceClasses,
                    @Param("offerAvailability") String offerAvailability, @Param("expiryDate") Date expiryDate);

    @Transactional
    @Modifying
    @Query("DELETE FROM gift g WHERE g.giftId = :giftId")
    void deleteGift(@Param("giftId") Long giftId);
}
