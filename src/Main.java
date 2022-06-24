import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private final static char[] allowedLowercase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
    private final static char[] allowedUppercase = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
    private final static char[] allowedNumbers = {'0','1','2','3','4','5','6','7','8','9'};

    public static void main(String[] args) {
        System.out.println(generateString());
    }

    private static String generateString() { return generateString(10); }

    private static String generateString(int length) {
        StringBuilder string= new StringBuilder();
        for (int i = 0; i < length; i++) {
            switch (getRandomNum(3)) {
                case 0 -> string.append(allowedLowercase[getRandomNum(allowedLowercase.length)]);
                case 1 -> string.append(allowedUppercase[getRandomNum(allowedUppercase.length)]);
                case 2 -> string.append(allowedNumbers[getRandomNum(allowedNumbers.length)]);
            }
        }
        return string.toString();
    }

    private static int getRandomNum(int max) { return ThreadLocalRandom.current().nextInt(0, max); }

}
