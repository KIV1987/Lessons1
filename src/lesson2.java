import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class lesson2 {

    public static void main(String[] args) {
    String inputText = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Ivanov Ivan Ivanovich</data></client>",outPutString ="";
    System.out.println(inputText);
    int begin = inputText.indexOf("<data>")+6;
        Pattern pattern = Pattern.compile(";");
        String[] strings = pattern.split(inputText.substring(inputText.indexOf("<data>") + 6, inputText.indexOf("</data>")));
        outPutString = inputText.substring(0,inputText.indexOf("<data>")+6);
        Pattern patternMail = Pattern.compile("[0123456789]");
        Matcher matcher = patternMail.matcher(inputText);
        System.out.println(matcher.replaceAll("*"));
        ;
        for (String string:strings) {

        if (string.indexOf("@")>0) //почта
        {
            outPutString +=string + ";";
        } else if (new Scanner(string).hasNextLong()) //телефон
        {
            outPutString +=string+ ";";
        } else //ФИО
        {
            outPutString +=string+ ";";
        }
        }
        outPutString = outPutString.substring(0,outPutString.length()-1) + inputText.substring(inputText.indexOf("</data>"));
        System.out.println(outPutString);
    }
}
