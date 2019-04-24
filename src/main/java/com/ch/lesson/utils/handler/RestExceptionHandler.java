package com.ch.lesson.utils.handler;

import com.ch.lesson.utils.Result;
import com.ch.lesson.utils.exception.InfoErrorException;
import com.ch.lesson.utils.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 使用@ControllerAdvice，
 * 类RestExceptionHandler就可以实现全局异常的拦截处理功能
 */
@ControllerAdvice
public class RestExceptionHandler
{
    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 自定义方法handleResourceNotFoundException
     * 拦截NotFoudException异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = NotFoundException.class)//要拦截的异常
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)//可以指定http响应的状态码
    public Result handleResourceNotFoundException(NotFoundException e)
    {
        logger.error(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }
    @ExceptionHandler(value = InfoErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleResourceInfoErrorException(InfoErrorException e)
    {
        logger.error(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }
}