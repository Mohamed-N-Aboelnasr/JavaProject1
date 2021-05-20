package Day2.Lab2;

public class MainClass {


    public static void main(String[] args) {
        String string1="Hello world";
        String string2="Welcome to iti Ismailia";

    //Solution using a lambda expression
        //1-this will return the longer string
        String longer=StringUtils.betterString(string1,string2,(s1,s2)->s1.length()>s2.length());
        System.out.println(longer);
        //2-this will always return the first string
        String first=StringUtils.betterString(string1,string2,(s1,s2)->true);
        System.out.println(first);
        System.out.println("============This Another Solution using a method reference===========");
    //Another Solution using a method reference
        //1-this will return the longer string
        longer=StringUtils.betterString(string1,string2,StringUtils::isLonger);
        System.out.println(longer);
        //2-this will always return the first string
        first=StringUtils.betterString(string1,string2,StringUtils::returntrue);
        System.out.println(first);
    }

}
