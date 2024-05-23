package com.med.medai.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.med.medai.model.dto.order.AiFrequencyOrderQueryRequest;
import com.med.medai.model.dto.order.AiFrequencyOrderUpdateRequest;
import com.med.medai.model.entity.AiFrequencyOrder;

import javax.servlet.http.HttpServletRequest;

/**
* @description 针对表【ai_frequency_order(次数订单表)】的数据库操作Service
*/
public interface AiFrequencyOrderService extends IService<AiFrequencyOrder> {


    /**
     * 分页获取订单列表
     * @param orderQueryRequest
     * @return
     */
    QueryWrapper<AiFrequencyOrder> getOrderQueryWrapper(AiFrequencyOrderQueryRequest orderQueryRequest);

    /**
     * 修改订单信息
     * @param orderUpdateRequest
     * @param request
     * @return
     */
    boolean updateOrderInfo(AiFrequencyOrderUpdateRequest orderUpdateRequest,
                         HttpServletRequest request);

}
