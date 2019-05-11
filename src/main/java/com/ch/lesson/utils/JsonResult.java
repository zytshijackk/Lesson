package com.ch.lesson.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class JsonResult {

    private Integer code;
    private String message;
    private Object data;

    public JsonResult(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    public static JsonResult successResult(Object data){
        return new JsonResult(HttpStatus.OK.value(),HttpStatus.OK.name(),data);
    }
    public static JsonResult errorResult(Object data){
        return new JsonResult(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name(),data);
    }
    public static JsonResult errorResult(){
        return new JsonResult(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name());
    }
}
