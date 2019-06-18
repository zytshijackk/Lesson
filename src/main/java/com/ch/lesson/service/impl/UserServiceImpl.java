package com.ch.lesson.service.impl;

import com.ch.lesson.entity.User;
import com.ch.lesson.dao.UserMapper;
import com.ch.lesson.service.UserIService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserIService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectStudentByCourseId(Long id) {
        return userMapper.selectStudentByCourseId(id);
    }
}
