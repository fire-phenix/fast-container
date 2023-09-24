package com.fire.phenix.container.exception;

import com.fire.phenix.container.lang.RespCode;
import com.fire.phenix.container.lang.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author fire-phenix
 * @since 2023-09-24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result doException(Exception ex) {
        log.info("服务出现的异常:{}", ex.getMessage());
        ex.printStackTrace(System.err);
        return Result.failed(RespCode.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result doException(HttpMessageNotReadableException ex) {
        log.info("服务出现的异常:{}", ex.getMessage());
        return Result.failed("Http 消息不可读异常");
    }

    @ExceptionHandler(IllegalStateException.class)
    public Result doIllegalStateException(IllegalStateException ex) {
        log.info("运行服务出现的IllegalStateException异常:{}", ex.getMessage());
        return Result.failed(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result doIllegalStateException(IllegalArgumentException ex) {
        log.info("运行服务出现的IllegalArgumentException异常:{}", ex.getMessage());
        return Result.failed(ex.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(";");
        }
        return Result.failed(sb.toString());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        return Result.failed(ex.getMessage());
    }
}
