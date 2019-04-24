package com.ch.lesson.utils.exception;


/**
 * 用来表示各种类型资源信息错误的异常情况
 */
public class InfoErrorException extends GlobalException
{
    public InfoErrorException(String message, int code)
    {
        super(message, code);
    }
}