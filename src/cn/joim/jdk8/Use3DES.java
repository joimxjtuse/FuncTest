package cn.joim.jdk8;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 对字节码文件进行加密的一种3DES算法.
 */
public class Use3DES {

    private static final String ALGORITHM = "DESede";

    /**
     * @param key 192位的加密key
     * @param src 需要执行加密的数据
     */
    public static byte[] encrpt(byte[] key, byte[] src) {

        byte value[] = null;
        try {
            //秘钥key.
            SecretKey desKey = new SecretKeySpec(key, ALGORITHM);
            //执行加密操作.
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            value = cipher.doFinal(src);
        } catch (Exception exce) {
            exce.printStackTrace();
        }
        return value;
    }
}
