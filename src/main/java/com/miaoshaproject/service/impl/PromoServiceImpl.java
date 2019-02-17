package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.PromoDOMapper;
import com.miaoshaproject.dataobject.PromoDO;
import com.miaoshaproject.service.PromoService;
import com.miaoshaproject.service.model.PromoModule;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    PromoDOMapper promoDOMapper;

    @Override
    public PromoModule getPromoByItemId(Integer itemId) {
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);
        PromoModule promoModule = conversFromDataObject(promoDO);
        if(promoModule == null)
            return null;

        DateTime now = new DateTime();
        if(promoModule.getStartDate().isAfterNow()){
            promoModule.setStatus(1);
        }else if(promoModule.getEndDate().isBeforeNow()){
            promoModule.setStatus(3);
        }else{
            promoModule.setStatus(2);
        }

        return promoModule;
    }

    private PromoModule conversFromDataObject(PromoDO promoDO){
        if(promoDO == null)
            return null;
        PromoModule promoModule = new PromoModule();
        BeanUtils.copyProperties(promoDO, promoModule);
        promoModule.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
        promoModule.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModule.setEndDate(new DateTime(promoDO.getEndDate()));
        return promoModule;
    }
}
