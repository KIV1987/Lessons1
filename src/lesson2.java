import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class lesson2 {

    public  static String Mask(String inputText){
        System.out.println(inputText);
        Pattern pattern = Pattern.compile(";");
        String[] strings = pattern.split(inputText.substring(inputText.indexOf("<data>") + 6, inputText.indexOf("</data>")));
        String outPutString = inputText.substring(0,inputText.indexOf("<data>")+6);
        for (String string:strings) {
            if (string.indexOf("@")>0) //почта
            {
                outPutString += string.substring(0,string.indexOf("@")-1)+"*@"+string.substring(string.indexOf("@")+1,string.indexOf(".")).replaceAll(".", "*")+
                        string.substring(string.indexOf("."))+";";
            } else if (new Scanner(string).hasNextLong()) //телефон
            {
                outPutString +=string.substring(0,4) + "***" + string.substring(7,11) +";";
            } else //ФИО
            {
                String[] FIO = string.split(" ");
                outPutString += FIO[0].charAt(0)+FIO[0].substring(1,FIO[0].length()-1).replaceAll(".", "*") + FIO[0].charAt(FIO[0].length()-1)  + " "+
                        FIO[1] +" "+ FIO[2].charAt(0)+".;";
            }
        }
        return outPutString.substring(0,outPutString.length()-1) + inputText.substring(inputText.indexOf("</data>"));
    }
    public static void main(String[] args) {
    String inputText = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Ivanov Ivan Ivanovich</data></client>";
        System.out.println(Mask(inputText));
    }
}
