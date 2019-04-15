package cn.joim.algorithm;

/**
 * 将IP地址转换为整型，将整型转换为IP地址.
 */
public class Ip2Int {

    public static void main(String[] args) {

        handleTest();
    }

    private static void handleTest() {

        String[] ips4Test = new String[]{"0.0.0.0", "127.0.0.1",
                "192.168.1.1", "255.0.0.255", "255.255.255.255"};

        for (String ipStr : ips4Test) {

            long parseInt = ip2Int(ipStr);
            String parseStr = int2Ip(parseInt);

            System.out.println("源IP：" + ipStr +
                    "; 转换为整型，IP： " + parseInt +
                    "; 二进制IP： " + Long.toBinaryString(parseInt) +
                    "; 转化为内字符串，IP： " + parseStr);
        }
    }

    /**
     * ip2Int("192.168.0.1") = 1 + 0 x 2^8 + 168 x 2^16 + 192 x 2^24.
     * <p>
     * 1、通过String的split方法按.分隔得到4个长度的数组
     * <p>
     * 2、通过左移位操作（<<）给每一段的数字加权，第一段的权为2的24次方，第二段的权为2的16次方，
     * 第三段的权为2的8次方，最后一段的权为1
     */
    static long ip2Int(String valuedIp) {

        String[] ipArray = valuedIp.split("\\.");
        return ((Long.valueOf(ipArray[0]) << 24) & 0xFF000000) |
                ((Long.valueOf(ipArray[1]) << 16) & 0xFF0000) |
                ((Long.valueOf(ipArray[2]) << 8) & 0xFF00) |
                (Long.valueOf(ipArray[3]));
    }

    /**
     * 1、将整数值进行右移位操作（>>>），右移24位，右移时高位补0，得到的数字即为第一段IP。
     * <p>
     * 2、通过与操作符（&）将整数值的高8位设为0，再右移16位，得到的数字即为第二段IP。
     * <p>
     * 3、通过与操作符吧整数值的高16位设为0，再右移8位，得到的数字即为第三段IP。
     * <p>
     * 4、通过与操作符吧整数值的高24位设为0，得到的数字即为第四段IP。
     */
    static String int2Ip(long ip) {
        String fst, sec, thd, fourth;
        fst = String.valueOf((ip >> 24));
        sec = String.valueOf((ip & 0x00FFFFFF) >> 16);
        thd = String.valueOf((ip & 0x0000FFFF) >> 8);
        fourth = String.valueOf(ip & 0x000000FF);

        return new StringBuilder(fst).append(".")
                .append(sec).append(".")
                .append(thd).append(".")
                .append(fourth)
                .toString();
    }
}
