package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModule;

public interface PromoService {
    PromoModule getPromoByItemId(Integer itemId);
}
