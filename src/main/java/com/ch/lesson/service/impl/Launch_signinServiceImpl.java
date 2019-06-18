package com.ch.lesson.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.lesson.dao.PermissionMapper;
import com.ch.lesson.entity.Launch_signin;
import com.ch.lesson.dao.Launch_signinMapper;
import com.ch.lesson.service.Launch_signinIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-06-18
 */
@Service
public class Launch_signinServiceImpl extends ServiceImpl<Launch_signinMapper, Launch_signin> implements Launch_signinIService {
    @Autowired
    private Launch_signinMapper launch_signinMapper;

//    @Override
//    public Launch_signin findLastLaunchByCourseId(Integer cid, int lastMiute) {
//        return launch_signinMapper;
//    }
}
