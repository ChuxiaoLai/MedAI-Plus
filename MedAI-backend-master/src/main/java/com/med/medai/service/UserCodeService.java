package com.med.medai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.med.medai.model.entity.UserCode;

/**
* @description 针对表【user_code(用户)】的数据库操作Service
*/
public interface UserCodeService extends IService<UserCode> {

    /**
     * 查看用户有无调用次数
     * @param userId
     * @return
     */
    UserCode getUserCodeByUserId(long userId);
}
