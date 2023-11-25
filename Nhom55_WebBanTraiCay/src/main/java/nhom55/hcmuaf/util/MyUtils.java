package nhom55.hcmuaf.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

public class MyUtils {
    public MyUtils() {
        super();
    }
    public String encodePass(String pass) {
        return DigestUtils.md5Hex(pass);
    }
    public String createHash() {
        Random random = new Random ();
        random.nextInt (999999);
        return DigestUtils.md5Hex (random.toString ());
    }
}
