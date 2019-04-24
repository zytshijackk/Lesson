package com.ch.lesson.service.impl;

import com.ch.lesson.domain.Role;
import com.ch.lesson.dao.RoleMapper;
import com.ch.lesson.service.RoleIService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleIService {
	
}
