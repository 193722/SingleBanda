package alone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static final Logger logger = LoggerFactory.getLogger(AtomicIntegerTest.class);
    public static void main(String[] args) {
        AtomicInteger ai= new AtomicInteger();
        int i1=ai.get();
        logger.info(String.valueOf(i1));
        int i2=ai.getAndSet(5);
        logger.info(String.valueOf(i2));
        int i3=ai.get();
        logger.info(String.valueOf(i3));
        int i4=ai.getAndIncrement();
        logger.info(String.valueOf(i4));
        logger.info(String.valueOf(ai.get()));
    }
}
