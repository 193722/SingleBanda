package clud.qc.bicycle.common.asserts;

import clud.qc.bicycle.common.util.VelocityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clud.qc.bicycle.common.env.Env;

import java.util.HashMap;
import java.util.Map;

public class AssertException extends IllegalArgumentException {
    private static final Logger logger = LoggerFactory.getLogger(AssertException.class);
    private static final long serialVersionUID = 3611026590046491155L;
    private String errorCode;
    private String errorMessage;

    public AssertException() {
    }

    public AssertException(AssertMessage errorCode, Object... params) {
        super(errorCode.getCode() + ":" + formatMessage(errorCode.getMessage(), params));
        this.errorCode = errorCode.getCode();
        this.errorMessage = formatMessage(errorCode.getMessage(), params);
    }

    public AssertException(String errorCode, String errorMessage) {
        super(errorCode + ":" + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public synchronized Throwable fillInStackTrace() {
        try {
            return (Throwable) (Env.isOnline() ? this : super.fillInStackTrace());
        } catch (Exception var2) {
            return this;
        }
    }

    private static String formatMessage(String message, Object[] params) {
        try {
            if (params != null && params.length != 0 && message.contains("$")) {
                if (params.length % 2 != 0) {
                    logger.warn("错误原因参数个数必须为偶数");
                    return message;
                } else {
                    Map<String, Object> messageParam = new HashMap();
                    for (int i = 0; i < params.length; i += 2) {
                        messageParam.put(String.valueOf(params[i]), params[i + 1]);
                    }
                    return VelocityUtils.parse(message, messageParam);
                }
            } else {
                return message;
            }
        } catch (Exception var4) {
            logger.warn("错误原因参数解析出现异常", var4);
            return message;
        }
    }
}
