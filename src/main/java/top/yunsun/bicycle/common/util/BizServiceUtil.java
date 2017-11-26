package top.yunsun.bicycle.common.util;


import top.yunsun.bicycle.common.UUIDIPGenerator;

public class BizServiceUtil extends UUIDIPGenerator {

    private static String getUUID() {
        StringBuffer strBuffer = new StringBuffer(20);
        return strBuffer.append(format(getIP())).append(format(getJVM())).append(format(getHiTime())).toString();
    }

    public static String bizNO(String preFix) {
        StringBuffer strBuffer = new StringBuffer(preFix);
        return strBuffer.append(getUUID()).toString();
    }
}
