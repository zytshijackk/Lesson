package com.ch.lesson.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ch.lesson.entity.Launch_signin;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-06-18
 */
public interface Launch_signinIService extends IService<Launch_signin> {

    /**
     * 找到前两分中内的发布课程
     * @param cid 课程ID
     * @param lastMiute
     * @return
     */
//    Launch_signin findLastLaunchByCourseId(Integer cid,String time int lastMiute);
}
