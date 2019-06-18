package com.ch.lesson.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ch.lesson.entity.Passport;
import com.ch.lesson.utils.ServiceResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-03-31
 */
public interface PassportIService extends IService<Passport> {


//    Passport login(String userName, String passWord) throws Exception;

    ServiceResult login2(String userName, String passWord);
}
