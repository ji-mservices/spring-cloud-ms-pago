package com.bsoftgroup.springcloudmspago.repository;

import com.bsoftgroup.springcloudmspago.entity.BillingService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillingServiceRepository extends JpaRepository<BillingService, Long> {

    List<BillingService> findAllByClientIdAndClientCompanyId(Long clientId, Long clientCompanyId);

    @Modifying
    @Transactional
    @Query("update BillingService b set b.status = '1' where b.id = :id and b.client.id = :clientId and b.product.id = :productId")
    void payService(@Param("id") Long id, @Param("clientId") Long clientId, @Param("productId") Long productId);
}
