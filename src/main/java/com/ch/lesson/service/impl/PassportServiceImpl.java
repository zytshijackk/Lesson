package com.ch.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ch.lesson.dao.PassportMapper;
import com.ch.lesson.dao.UserMapper;
import com.ch.lesson.domain.Passport;
import com.ch.lesson.domain.User;
import com.ch.lesson.service.PassportIService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.lesson.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-03-31
 */
@Service
public class PassportServiceImpl extends ServiceImpl<PassportMapper, Passport> implements PassportIService {

    @Autowired
    private PassportMapper passportMapper;

    @Autowired
    private UserMapper userMapper;

//    @Override
//    public Passport login(String userName, String passWord) throws Exception{
//        List<Passport> passports = passportMapper.selectList(
//                new QueryWrapper<Passport>()
//                .lambda().eq(Passport::getUsername,userName)
//        );
//        if(passports.isEmpty())
//            throw new NotFoundException("账户不存在", Result.ErrorCode.PASSPORT_NOT_FOUND.getCode());
//        else if(!passports.get(0).getPassword().equals(passWord)){
//            throw new InfoErrorException("密码错误",Result.ErrorCode.PASSPORT_PASSWORD_ERROR.getCode());
//        }
//        return passports.get(0);
//    }

    @Override
    public ServiceResult login2(String userName, String passWord) {
        List<Passport> passports = passportMapper.selectList(
                new QueryWrapper<Passport>()
                        .lambda().eq(Passport::getUsername,userName)
        );
        ServiceResult result = new ServiceResult();
        if(passports.isEmpty()){
            result.setSuccess(false);
            result.setMessage("用户不存在");
        }else if(!passports.get(0).getPassword().equals(passWord)){
            result.setSuccess(false);
            result.setMessage("密码错误");
        }else{
            result.setSuccess(true);
            result.setMessage("登录成功");
            User user = userMapper.selectById(passports.get(0).getUserId());
            result.addData("account",user);
        }
        return result;
    }
}
