package com.iecloud.util;

import com.iecloud.common.ServerResponse;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lanmeiniu on 2017/7/12.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerResponse<String> processMethod(Exception ex){
        System.out.println("Catch an Exception !" +ex.getLocalizedMessage());
        //打印全部异常堆栈
        log.error(ExceptionUtils.getFullStackTrace(ex));
        return ServerResponse.createByErrorMessage("出现异常");
    }
}

