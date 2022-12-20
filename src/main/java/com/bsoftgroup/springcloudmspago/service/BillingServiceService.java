package com.bsoftgroup.springcloudmspago.service;

import com.bsoftgroup.springcloudmspago.bean.BillingServiceBean;
import com.bsoftgroup.springcloudmspago.entity.BillingService;
import com.bsoftgroup.springcloudmspago.repository.BillingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceService {

    @Autowired
    private BillingServiceRepository billingServiceRepository;

    public List<BillingService> getServices() {
        return billingServiceRepository.findAll();
    }

    public List<BillingService> getServices(Long clientId, Long productId) {
        return billingServiceRepository.findAllByClientIdAndClientCompanyId(clientId, productId);
    }

    public void payService(BillingServiceBean billingServiceBean) {
        billingServiceRepository.payService(billingServiceBean.id(), billingServiceBean.client().id(), billingServiceBean.product().id());
    }
}
