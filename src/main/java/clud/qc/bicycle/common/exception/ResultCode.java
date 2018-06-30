/*
 * 修订记录:
 * Yong.L 16/9/9 下午12:18 创建
 *
 */
package clud.qc.bicycle.common.exception;

import clud.qc.bicycle.common.asserts.AssertMessage;

import java.lang.reflect.Field;

/**
 * 结果码 Created by Yong.L on 16/9/9.
 */
public class ResultCode implements AssertMessage {

    //系统未知异常
    public static final ResultCode UNKNOW_EXCEPTION = new ResultCode("system_01_0000", "系统未知异常");
    //文件异常
    public static final ResultCode FILE_NOT_EXISTS = new ResultCode("file_02_0000", "文件不存在！");
    public static final ResultCode FILE_NAME_IS_BLANK = new ResultCode("file_02_0001", "文件名为空！");
    public static final ResultCode FILE_UPLOAD_EXCEPTION = new ResultCode("file_02_0002", "上传文件异常！");
    public static final ResultCode FILE_UPLOAD_TYPE_NO_MATCH = new ResultCode("file_02_0002", "上传文件类型不符合！");


    /**
     * 代码
     */
    private String code;
    /**
     * 描述
     */
    private String message;

    /**
     * 构建一个 ResultCode.java 。
     *
     * @param code    代码
     * @param message 描述
     */
    public ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCode getByCode(String code) {
        ResultCode rc = null;
        try {
            Field field = ResultCode.class.getDeclaredField(code);
            rc = (ResultCode) field.get(null);
        } catch (NoSuchFieldException e) {
        } catch (SecurityException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }
        return rc;
    }

    /**
     * 代码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 描述
     */
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResultCode [code=");
        builder.append(code);
        builder.append(", message=");
        builder.append(message);
        builder.append("]");
        return builder.toString();
    }

}
