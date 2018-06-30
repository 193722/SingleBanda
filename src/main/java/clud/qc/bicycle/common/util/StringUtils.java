package clud.qc.bicycle.common.util;

public class StringUtils extends org.apache.commons.lang3.StringUtils{

    public static boolean notEquals(String str1, String str2) {
        if (StringUtils.equals(str1, str2)) {
            return false;
        } else {
            return true;
        }
    }

}
