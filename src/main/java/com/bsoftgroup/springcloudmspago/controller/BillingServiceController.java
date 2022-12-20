package com.bsoftgroup.springcloudmspago.controller;

import com.bsoftgroup.springcloudmspago.bean.BillingServiceBean;
import com.bsoftgroup.springcloudmspago.bean.TransactionBean;
import com.bsoftgroup.springcloudmspago.service.BillingServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BillingServiceController {

    private final BillingServiceService billingServiceService;

    private final Environment environment;

    @PutMapping(path = "/billing/pay")
    public TransactionBean payService(@RequestBody BillingServiceBean billingServiceBean) {

        log.info("Port: " + environment.getProperty("local.server.port"));

        billingServiceService.payService(billingServiceBean);
        return new TransactionBean("0000", "Successful process", environment.getProperty("local.server.port"));
    }

}
