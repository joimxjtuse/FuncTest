package cn.joim.string.sub;

public class TestSubString {

    /**
     * this pro is used for record some algorithm what I see during work and
     * life.
     * <p>
     * 2014.11.30 the first commit.
     */
    public static void main(String[] args) {

        SubStringMyNickName mNickNameSub = new SubStringMyNickName();

        for (int i = 0, length = nameArray.length; i < length; i++) {

            System.out.println("src=" + nameArray[i] + " ;result="
                    + mNickNameSub.subMyNickName(nameArray[i]));
        }

    }

    private static String nameArray[] = {"joim你好，大苏打丰富的斯蒂芬", "发生的房贷首付第三方的首付第",
            "fsdfsfsdfdsfdsdfdsfdsf", "打算fdfd发生g的房首付第三方岁"};

}
