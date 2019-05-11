package com.ch.lesson.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.lesson.dao.DepartmentMapper;
import com.ch.lesson.domain.Department;
import com.ch.lesson.service.DepartmentIService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentIService {
	
}
