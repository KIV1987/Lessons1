
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class lesson4 {
    public static Set finderCar(String regex, Map<Integer, Map<String, String[]>> data) {
        HashSet<String> setCars = new HashSet<>();
        for (Map.Entry<Integer, Map<String, String[]>> region:data.entrySet()        ) {
            for (Map.Entry<String, String[]> arrayNumbers : region.getValue().entrySet()) {
                for (String number : arrayNumbers.getValue()) {
                    if (Pattern.matches(regex,number)){
                        setCars.add(number);
                    }
                }
            }
        }
        return setCars;
    }

    public static void main(String[] args) {
        final String FIRST = "М";
        final String SECOND = "АВ";
        String regex = "("+FIRST+")\\w+("+SECOND+")\\w+";
        Map<Integer, Map<String, String[]>> data = GeneratorExpertHomework.getData();
        finderCar(regex,data).stream().forEach(System.out::println);
        System.out.println(finderCar(regex,data).size());
    }
}