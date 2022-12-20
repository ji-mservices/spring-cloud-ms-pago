package com.bsoftgroup.springcloudmspago.bean;

import java.math.BigDecimal;

public record ProductBean(Long id, String description, BigDecimal price) {

}
