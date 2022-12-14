package lesson10;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Runner {
    private static HashMap<String,Double> shops = new HashMap<String,Double>();

    public static void main(String[] args) {

        String PATH = "D:\\lesson10\\reports";

        try {
            DataGenerator.createReports(PATH);
            //первый отчет
            Stream<Path> pathsFirst = Files.walk(Paths.get(PATH));
            pathsFirst.filter(Files::isRegularFile).forEach(Runner::reportFist);
            //второй отчет
            System.out.println("_______________________________________________");
            Stream<Path> pathsSecond = Files.walk(Paths.get(PATH));
            pathsSecond.filter(Files::isRegularFile).forEach(Runner::reportSecond);
            for (Map.Entry<String, Double> entry : shops.entrySet()) {
                System.out.println("Расходы " + entry.getKey() + " за весь период: " + String.format("%.2f",entry.getValue()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Каталог не найден");
        }
    }

    private static void reportFist(Path path) {
        int countLines = 0;
        Double profit = 0.0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()));
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                if (countLines == 0) {
                    countLines++;
                    continue;
                }
                String[] fields = line.split(";");
                if (fields[0].equals("pyterochka")){
                    profit += Double.parseDouble(fields[1])-Double.parseDouble(fields[2]);
                }

            }
            String[] fieldsFileName = path.getFileName().toString().split("_");
            System.out.println(String.format(fieldsFileName[1] + "."+fieldsFileName[2].substring(0,4)+": "+"%.2f",profit));
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Файлы не найдены");
        }
    }
    private static void reportSecond(Path path) {
        int countLines = 0;
             try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()));
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                if (countLines == 0) {
                    countLines++;
                    continue;
                }
                String[] fields = line.split(";");
                if (!shops.containsKey(fields[0])){
                    shops.put(fields[0],Double.parseDouble(fields[2]));
               } else {
                    shops.put(fields[0],Double.parseDouble(fields[2])+Double.parseDouble(shops.get(fields[0]).toString()));
                }
            }
            bufferedReader.close();
         } catch (IOException e) {
            throw new RuntimeException("Файлы не найдены");
        }
    }
}