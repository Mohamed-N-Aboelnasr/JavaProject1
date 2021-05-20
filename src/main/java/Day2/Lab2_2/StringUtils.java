package Day2.Lab2_2;

import java.util.function.Predicate;

    public class StringUtils {

        public static void isalphabet(String s, Predicate<String> p) {
            if (p.test(s)) {
                System.out.println("The string contains only alphabets");
            }else {
                System.out.println("The string doesn't contain alphabets only");
            }
        }

        public static boolean isLetter(String s){
            char []l=s.toCharArray();
            for(char c:l){
                if(!Character.isLetter(c))
                    return false;
            }
            return true;
        }
    }
