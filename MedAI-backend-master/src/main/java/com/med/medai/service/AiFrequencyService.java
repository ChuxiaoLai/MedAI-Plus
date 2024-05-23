package com.med.medai.service;

import com.med.medai.model.entity.AiFrequency;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @description 针对表【ai_frequency(ai调用次数表)】的数据库操作Service
*/
public interface AiFrequencyService extends IService<AiFrequency> {

    /**
     * 调用智能分析接口次数自动减一
     * @param userId
     * @return
     */
    boolean invokeAutoDecrease(long userId);

    /**
     * 查看用户有无调用次数
     * @param userId
     * @return
     */
    boolean hasFrequency(long userId);

}
