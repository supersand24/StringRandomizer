import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private final static char[] allowedLowercase = {'a','b','c','d','e','f','h','j','k','m','n','o','p','r','s','t','x','y','z'};
    private final static char[] allowedUppercase = {'A','B','C','D','E','F','H','J','K','M','N','P','Q','R','T','X','Y','Z'};
    private final static char[] allowedNumbers = {'3','4','5','7','8','9'};

    private static int times = 1;

    public static void main(String[] args) {
        System.out.println("Number of Command Line Arguments = " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.printf("Command Line Argument %d is %s%n",i,args[i]);
            switch (args[i]) {
                case "-times" -> {
                    times = Integer.parseInt(args[i+1]);
                    i++;
                }
            }
        }

        for (int i = 0; i < times; i++) {
            System.out.println(generateString());
        }
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
