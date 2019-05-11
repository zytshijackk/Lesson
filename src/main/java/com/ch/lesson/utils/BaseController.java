package com.ch.lesson.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BaseController<T> {
//    static Map<String, String> map = Maps.newConcurrentMap();
//
//    static {
//        map.put("Equal", "eq");
//        map.put("Like", "like");
//        map.put("GreaterThanOrEqual", "ge");
//        map.put("LessThanOrEqual", "le");
//        map.put("In", "in");
//    }
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    BaseMapper<T> baseMapper;

/**
     * 自定义查询列表
     *
     * @return {@link List<T>}
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
*/

    public List<T> getList() throws Exception {
        //从request中获取参数列表
        Map<String, String[]> parameterMap = request.getParameterMap();
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        Class<QueryWrapper> queryWrapperClass = QueryWrapper.class;
        //循坏参数key
        //String[] sizes = parameterMap.get("size");
        for (String s : parameterMap.keySet()) {
            int firstIndex = s.indexOf("[");
            int lastIndex = s.lastIndexOf("]");
            //获取中括号内的关键字 如eq,in,like等
            //统一关键字 Like, Equal, GreaterThanOrEqual, LessThanOrEqual,In
            String keyword;
            try {
                keyword = s.substring(firstIndex + 1, lastIndex);
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }
            //获取查询的列名 并把驼峰规则转成下划线
            String column = humpToUnderline(s.substring(lastIndex + 1));
            Method method;
            Object value;
            //关键字为in时，把参数值转为集合类型
            if (SqlKeyword.IN.name().toLowerCase().equals(keyword)) {
                value = Arrays.asList(parameterMap.get(s)[0].split(","));
                method = queryWrapperClass.getMethod(keyword, boolean.class, Object.class, Collection.class);
            } else {
                value = parameterMap.get(s)[0];
                method = queryWrapperClass.getMethod(keyword, boolean.class, Object.class, Object.class);
            }
            //反射调用相关方法
            method.invoke(queryWrapper, true, column, value);
        }
        //反射调用排序方法
        Method method = queryWrapperClass.getMethod("orderByDesc", Object.class);
        method.invoke(queryWrapper, "sort_index");
        //baseMapper.selectPage()
        //判断是否分页
//        boolean isPage = parameterMap.get("page") != null
//                && Integer.parseInt(parameterMap.get("page")[0]) > 0
//                && parameterMap.get("size") != null
//                && Integer.parseInt(parameterMap.get("size")[0]) > 0;
//        if (isPage) {
//            Page page = new Page((long) Integer.parseInt(parameterMap.get("page")[0]), Integer.parseInt(parameterMap.get("size")[0]));
//            IPage iPage = baseMapper.selectPage(page, queryWrapper);
//            return PageWapper.pageToPageDTO((Page) iPage);
//        }
        List<T> selectList = baseMapper.selectList(queryWrapper);
        return selectList;
    }

/**
     * 驼峰转下划线
     *
     * @param str hump String
     * @return underline String
*/

    private String humpToUnderline(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
