package com.med.medai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.med.medai.model.entity.AlipayInfo;

/**
* @description 针对表【alipay_info(次数订单表)】的数据库操作Service
*/
public interface AlipayInfoService extends IService<AlipayInfo> {

    long getPayNo(long orderId, long userId);

}
