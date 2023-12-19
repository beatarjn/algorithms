package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WordOccurencesInFile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        Objects.nonNull(target);

        checkForWordOccurences(target);
    }

    private static void checkForWordOccurences(String target) {
        if (target instanceof String) {
            if (target.equalsIgnoreCase("quit")) {
                System.out.println("The end");
            } else {
                List<String> file;
                try {
                    file = readFile();

                    Map<String, Integer> occurrences = countOccurrences(target, file);
                    if (occurrences.isEmpty()) {
                        System.out.println(String.format("Słowo “%s” nie występuje w żadnym zdaniu.", target));
                    } else {
                        occurrences.entrySet().stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                .limit(3)
                                .map(Map.Entry::getKey)
                                .forEach(System.out::println);
                    }
                } catch (IOException e) {
                    System.out.println(e);
                    System.out.println("The end");
                }
            }
        }
    }

    private static List<String> readFile() throws IOException {
        return Files.lines(Paths.get("src/main/resources/values.txt")).collect(Collectors.toList());
    }

    private static Map<String, Integer> countOccurrences(String target, List<String> lines) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String line : lines) {
            int counter = 0;
            for (String word : line.split(" ")) {
                if (target.equalsIgnoreCase(word)) {
                    counter++;
                    String key = line;
                    map.put(key, counter);
                }
            }
        }
        return map;
    }
}