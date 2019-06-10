package helper;


import org.apache.commons.lang3.RandomStringUtils;

public class RandomText {

     public String randomAlphabetic() {
         String string = RandomStringUtils.randomAlphabetic(64);
         return string;
    }

    public static String randomAscii() {
        String string = RandomStringUtils.randomAscii(32);
        return string;
    }
}
