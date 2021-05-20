package Day2.Lab2_2;

public class MainClass {


    public static void main(String[] args) {
        //Solution using a lambda expression
        String string1="Helloworld";
        StringUtils.isalphabet(string1,(s)->StringUtils.isLetter(s));
        String string2="Hello7world";
        StringUtils.isalphabet(string2,(s)->StringUtils.isLetter(s));
        System.out.println("============This Another Solution using a method reference===========");
        //Another Solution using a method reference
        string1="Helloworld";
        StringUtils.isalphabet(string1,StringUtils::isLetter);
        string2="Hello7world";
        StringUtils.isalphabet(string2,StringUtils::isLetter);
    }

}
