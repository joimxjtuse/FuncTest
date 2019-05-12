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

    public static byte[] decrypt(byte[] key, byte[] src) {
        byte value[] = null;
        try {
            //秘钥key.
            SecretKey desKey = new SecretKeySpec(key, ALGORITHM);
            //执行解密操作.
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            value = cipher.doFinal(src);
        } catch (Exception exce) {
            exce.printStackTrace();
        }
        return value;
    }


    public static void main(String[] args) {
        try {
            byte key[] = "01234567899876543210abcd".getBytes();
            byte[] src = "测试数据".getBytes("UTF-8");

            byte encoded[] = encrpt(key, src);

            byte decodede[] = decrypt(key, encoded);
            System.out.println("加密后数据: " + new String(encoded) + " ; 解密后数据: " + new String(decodede, "UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
