package clud.qc.bicycle.common.constant;

import clud.qc.bicycle.common.util.PropertiesUtil;

public class ConstantConfig extends PropertiesUtil {

    public static final String USER_LOGIN_SESSION;
    public static final String FILE_HANDLER_PATH;
    public static final String FILE_DOWN;
    public static final String FILE_UPLOAD;
    public static final Integer FILE_SIZE_DEFAULT;
    public static final String FILE_SUFFIX;

    static {
        init("ConstantConfig.properties");
        USER_LOGIN_SESSION = getProperty("config.redis.session");
        FILE_HANDLER_PATH = getProperty("config.file.handler");
        FILE_DOWN = getProperty("config.file.down");
        FILE_UPLOAD = getProperty("config.file.upload");
        FILE_SIZE_DEFAULT = Integer.valueOf(getProperty("config.file.size.default"));
        FILE_SUFFIX = getProperty("config.file.suffix");
    }
}
