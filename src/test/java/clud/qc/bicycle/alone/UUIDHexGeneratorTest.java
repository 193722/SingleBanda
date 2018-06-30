package clud.qc.bicycle.alone;

import org.hibernate.id.UUIDHexGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clud.qc.bicycle.common.UUIDIPGenerator;

import java.net.InetAddress;

public class UUIDHexGeneratorTest {

    private static final Logger logger = LoggerFactory.getLogger(UUIDHexGeneratorTest.class);

    private String sep = "";
    private static final int IP;

    static {
        int ipAddress;
        try {
            ipAddress = toInt(InetAddress.getLocalHost().getAddress());
        } catch (Exception e) {
            ipAddress = 0;
        }
        IP = ipAddress;
    }

    private static short counter = (short) 0;
    private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

    public static int toInt(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            logger.info(String.valueOf(bytes[i]));
            result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }

    /**
     * Unique in a local network
     */
    protected int getIP() {
        return IP;
    }

    /**
     * Unique down to millisecond
     */
    protected short getHiTime() {
        return (short) (System.currentTimeMillis() >>> 32);
    }

    protected int getLoTime() {
        return (int) System.currentTimeMillis();
    }

    /**
     * Unique across JVMs on this machine (unless they load this class in the
     * same quater second - very unlikely)
     */
    protected int getJVM() {
        return JVM;
    }

    protected String format(int intval) {
        String formatted = Integer.toHexString(intval);
        StringBuffer buf = new StringBuffer("00000000");
        buf.replace(8 - formatted.length(), 8, formatted);
        return buf.toString();
    }

    protected String format(short shortval) {
        String formatted = Integer.toHexString(shortval);
        StringBuffer buf = new StringBuffer("0000");
        buf.replace(4 - formatted.length(), 4, formatted);
        return buf.toString();
    }

    public String generate() {
        return new StringBuilder(36).append(format(getIP())).append(sep)
                .append(format(getJVM())).append(sep)
                .append(format(getHiTime())).append(sep)
                .append(format(getLoTime())).append(sep)
                .append(format(getCount())).toString();
    }

    /**
     * Unique in a millisecond for this JVM instance (unless there are >
     * Short.MAX_VALUE instances created in a millisecond)
     */
    protected short getCount() {
        synchronized (UUIDHexGenerator.class) {
            if (counter < 0)
                counter = 0;
            return counter++;
        }
    }

    public static void main(String[] args) {
        long times = System.currentTimeMillis();
        UUIDHexGeneratorTest uuidHexGenerator = new UUIDHexGeneratorTest();
        int ip2 = uuidHexGenerator.getIP();
        System.out.println(ip2);
        System.out.println(times);
        System.out.println("JVM" + (int) (System.currentTimeMillis() >>> 8));
        System.out.println("int" + Integer.toHexString((int) times));
        System.out.println("short" + Integer.toHexString((short) (times >>> 32)));
        System.out.println(Integer.toHexString((int) System.currentTimeMillis()));
        String generate = uuidHexGenerator.generate();
        System.out.println(generate);
        System.out.println(UUIDIPGenerator.generate());
    }

}
