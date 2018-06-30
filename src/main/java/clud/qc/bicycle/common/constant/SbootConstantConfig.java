package clud.qc.bicycle.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource(value = "classpath:ConstantConfig.properties", encoding = "utf-8")
public class SbootConstantConfig {

    @Value("${config.redis.session}")
    public static String user_login_session;
    @Value("${config.file.handler}")
    public static String file_handler_path;
    @Value("${config.file.down}")
    public static String file_down;
    @Value("${config.file.upload}")
    public static String file_upload;
    @Value("${config.file.size.default}")
    public static Integer file_size_default;
    @Value("#{'${config.file.suffix}'.split(',')}")
    public static List<String> file_suffix;

}
