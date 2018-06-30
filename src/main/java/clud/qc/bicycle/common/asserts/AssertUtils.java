package clud.qc.bicycle.common.asserts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clud.qc.bicycle.common.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AssertUtils {
    private static Logger logger = LoggerFactory.getLogger(AssertUtils.class);

    public AssertUtils() {
    }

    public static void isNull(Object object, AssertMessage errorCode, Object... params) {
        if (object != null) {
            logger.error("应该为空: object={}, errorCode={}, params={}", new Object[]{object, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void notNull(Object object, AssertMessage errorCode, Object... params) {
        if (object == null) {
            logger.error("不应为空: object={}, errorCode={}, params={}", new Object[]{null, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void isEmpty(Collection<?> collection, AssertMessage errorCode, Object... params) {
        if (collection != null && collection.size() != 0) {
            logger.error("应该为空: collection={}, errorCode={}, params={}", new Object[]{collection, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void notEmpty(Collection<?> collection, AssertMessage errorCode, Object... params) {
        if (collection == null || collection.size() == 0) {
            logger.error("不应为空: collection={}, errorCode={}, params={}", new Object[]{collection, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void isBlank(String string, AssertMessage errorCode, Object... params) {
        if (StringUtils.isNotBlank(string)) {
            logger.error("应该为空: string={}, errorCode={}, params={}", new Object[]{string, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void notBlank(String string, AssertMessage errorCode, Object... params) {
        if (StringUtils.isBlank(string)) {
            logger.error("不应为空: string={}, message={}, params={}", new Object[]{string, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void isTrue(boolean flag, AssertMessage errorCode, Object... params) {
        if (!flag) {
            logger.error("应该为TRUE: flag={}, errorCode={}, params={}", new Object[]{flag, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void isTrue(boolean flag, String errorCode, String errorMessage, Object... params) {
        if (!flag) {
            logger.error("应该为TRUE: flag={}, errorCode={}, errorMessage={}, params={}", new Object[]{flag, errorCode, errorMessage, params});
            throw new AssertException(errorCode, errorMessage);
        }
    }

    public static void isFalse(boolean flag, AssertMessage errorCode, Object... params) {
        if (flag) {
            logger.error("应该为FALSE: flag={}, errorCode={}, params={}", new Object[]{flag, errorCode, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void isFalse(boolean flag, String errorCode, String errorMessage, Object... params) {
        if (flag) {
            logger.error("应该为FALSE: flag={}, errorCode={}, errorMessage={}, params={}", new Object[]{flag, errorCode, errorMessage, params});
            throw new AssertException(errorCode, errorMessage);
        }
    }

    public static <T extends Enum<T>> void legalEnum(Enum<T> actual, Enum<T> expected, AssertMessage errorCode, Object... params) {
        if (actual != expected) {
            logger.error("状态错误：errorCode={}, actual={}, expected={}, params={}", new Object[]{errorCode, actual, expected, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static <T extends Enum<T>> void legalEnums(AssertMessage errorCode, Enum<T> actual, Enum... expected) {
        List<Enum<T>> enumList = Arrays.asList(expected);
        if (!enumList.contains(actual)) {
            logger.error("状态错误：errorCode={}, actual={}, expected={}", new Object[]{errorCode, actual, expected});
            throw new AssertException(errorCode, new Object[0]);
        }
    }

    public static <T extends Enum<T>> void legalEnums(Enum<T> actual, Enum<T>[] expected, AssertMessage errorCode, Object... params) {
        List<Enum<T>> enumList = Arrays.asList(expected);
        if (!enumList.contains(actual)) {
            logger.error("状态错误：errorCode={}, actual={}, expected={}, params={}", new Object[]{errorCode, actual, expected, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void isEquals(String actual, String expected, AssertMessage errorCode, Object... params) {
        if (StringUtils.notEquals(actual, expected)) {
            logger.error("应该为相同：errorCode={}, actual={}, expected={}, params={}", new Object[]{errorCode.getMessage(), actual, expected, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void notEquals(String actual, String expected, AssertMessage errorCode, Object... params) {
        if (StringUtils.equals(actual, expected)) {
            logger.error("应该不相同：errorCode={}, actual={}, expected={}, params={}", new Object[]{errorCode.getMessage(), actual, expected, params});
            throw new AssertException(errorCode, params);
        }
    }

    public static void fail(AssertMessage errorCode, Object... params) {
        logger.error("应该为失败: errorCode={}, params={}", errorCode, params);
        throw new AssertException(errorCode, params);
    }
}
