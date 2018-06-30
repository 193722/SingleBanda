/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * husheng@yiji.com 2015年3月2日 下午3:11:31创建
 */
package clud.qc.bicycle.common.enums;

import clud.qc.bicycle.common.asserts.AssertMessage;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author husheng@yiji.com
 */
public enum ErrorCodeEnum implements AssertMessage {
    DATA_DUPLICATE("T000_00_0001", "数据重复"),
    OPERATE_NOT_SUPPORTED("T000_00_0002", "操作不支持"),
    QUERY_FAIL("T000_00_0003", "查询失败"),
    DATA_NOT_EXISTS("T000_00_0004", "数据不存在"),
    SYSTEM_ERROR("T000_00_0005", "系统内部错误"),
    PARAM_ERROR("T000_00_0006", "参数错误"),
    TIME_ILLEGAL("T000_00_0007", "非业务时间"),
    // ====================系统配置 T000_01_1001
    SYSTEM_CONFIG_CACHE_NOT_EXISTS("T000_01_1001", "系统配置缓存不存在"),
    // ====================其他
    ;

    public static void selfCheck() {
        Set<String> set = new HashSet<>();
        String lastCode = null;
        for (ErrorCodeEnum errorCode : ErrorCodeEnum.values()) {
            String code = errorCode.getCode();
            String message = errorCode.getMessage();
            Assert.hasText(code, "错误码编码必须有值");
            Assert.isTrue(code.length() == 12, "错误码只能是12位：" + code);
            Assert.hasText(message, "错误码描述必须有值");
            Assert.isTrue(set.add(code), "有重复错误码：" + code);

            if (lastCode != null) {
                Assert.isTrue(lastCode.compareTo(code) < 0, "错误码必须按顺序编排：" + code);
            }
            lastCode = code;
        }
    }

    /**
     * 枚举值
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * @param code    枚举值
     * @param message 枚举描述
     */
    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the code.
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return ErrorCodeEnum
     */
    public static ErrorCodeEnum getByCode(String code) {
        for (ErrorCodeEnum _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ErrorCodeEnum>
     */
    public static java.util.List<ErrorCodeEnum> getAllEnum() {
        java.util.List<ErrorCodeEnum> list = new java.util.ArrayList<ErrorCodeEnum>(values().length);
        for (ErrorCodeEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static java.util.List<String> getAllEnumCode() {
        java.util.List<String> list = new java.util.ArrayList<String>(values().length);
        for (ErrorCodeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 通过code获取msg
     *
     * @param code 枚举值
     * @return
     */
    public static String getMsgByCode(String code) {
        if (code == null) {
            return null;
        }
        ErrorCodeEnum _enum = getByCode(code);
        if (_enum == null) {
            return null;
        }
        return _enum.getMessage();
    }

    /**
     * 获取枚举code
     *
     * @param _enum
     * @return
     */
    public static String getCode(ErrorCodeEnum _enum) {
        if (_enum == null) {
            return null;
        }
        return _enum.getCode();
    }

    @Override
    public String toString() {
        return getCode() + ":" + getMessage();
    }

}
