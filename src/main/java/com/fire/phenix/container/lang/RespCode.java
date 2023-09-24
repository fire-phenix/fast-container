package com.fire.phenix.container.lang;

import lombok.Getter;

/**
 * @author fire-phenix
 * @since 2023-09-24
 */
@Getter
public enum RespCode {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功"),
    /**
     * 请求失败
     */
    BAD_REQUEST(400, "请求失败"),
    /**
     * 认证失败/登录失效
     */
    UNAUTHORIZED(401, "认证失败/登录失效"),
    /**
     * 没有权限
     */
    FORBIDDEN(403, "没有权限"),
    /**
     * 请求资源不存在
     */
    NOT_FOUND(404, "请求资源不存在"),
    /**
     * 请求方式不允许
     */
    METHOD_NOT_ALLOWED(405, "请求方式不允许"),
    /**
     * 请求超时
     */
    REQUEST_TIMEOUT(408, "请求超时"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    /**
     * 远程服务器接收到了一个无效的响应
     */
    BAD_GATEWAY(502, "远程服务器接收到了一个无效的响应"),
    /**
     * 网关响应超时
     */
    GATEWAY_TIMEOUT(504, "网关响应超时"),
    /**
     * 自定义异常信息
     */
    CUSTOM_EXCEPTION(-1, ""),
    ID_TOKEN_CHECK_FAILED( 7001, "Id-Token校验失败"),
    SET_CHECK_PARAMETER_ERROR( 7002, "SET权限校验,参数异常"),

    SET_CHECK_PERMISSION_DENIED( 7003, "SET权限校验失败，无目标id访问权限"),

    CHECK_PERMISSION_CODE_FAILED( 7004, "接口权限码校验失败"),

    CHECK_ROLE_CODE_FAILED( 7005, "角色权限码校验失败"),

    SA_TOKEN_ERROR( 7006, "Sa-Token权限校验异常")
    ;

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 响应消息
     */
    private final String message;

    RespCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
