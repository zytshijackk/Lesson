package com.ch.lesson.utils.exception;


/**
 * 用来表示各种类型资源不存在的异常情况
 */
public class NotFoundException extends GlobalException
{
    public NotFoundException(String message, int code)
    {
        super(message, code);
    }
}