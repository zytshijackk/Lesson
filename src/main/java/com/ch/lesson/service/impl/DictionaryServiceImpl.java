package com.ch.lesson.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.lesson.dao.DictionaryMapper;
import com.ch.lesson.entity.Dictionary;
import com.ch.lesson.service.DictionaryIService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-15
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryIService {
	
}
