package clud.qc.bicycle.controller.result;

import clud.qc.bicycle.common.util.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author zheye1024(zheye1024@sina.com)
 * @version 1.0
 * @since 2017-07-11
 */
public class BaseResult implements Serializable {

    protected static final Logger logger = LoggerFactory.getLogger(BaseResult.class);

    private boolean success = false;// 是否成功
    private String message = "操作失败";// 提示信息
    private Object data = null;// 其他信息

    public static BaseResult getSuccessResult() {
        return getSuccessResult(null, null);
    }

    public static BaseResult getSuccessResult(String msg) {
        return getSuccessResult(msg, null);
    }

    public static BaseResult getSuccessResult(Object data) {
        return getSuccessResult(null, data);
    }

    public static BaseResult getSuccessResult(String msg, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(true);
        baseResult.setMessage(StringUtils.isNotBlank(msg) ? msg : "操作成功");
        baseResult.setData(data);
        logger.info("响应Success结果：{}", baseResult);
        return baseResult;
    }

    public static BaseResult getFailResult() {
        return getFailResult(null, null);
    }

    public static BaseResult getFailResult(Object data) {
        return getFailResult(null, data);
    }

    public static BaseResult getFailResult(String msg) {
        return getFailResult(msg, null);
    }

    public static BaseResult getFailResult(String msg, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(false);
        baseResult.setMessage(StringUtils.isNotBlank(msg) ? msg : "操作失败");
        baseResult.setData(data);
        logger.info("响应Fail结果：{}", baseResult);
        return baseResult;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
