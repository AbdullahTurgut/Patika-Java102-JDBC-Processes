package DiffScannerStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] fileNames = {
                "src/mobydick.txt", "src/hamlet.txt", "src/tomsawyer.txt",
                "src/mobydick.txt", "src/hamlet.txt", "src/tomsawyer.txt",
                "src/mobydick.txt", "src/hamlet.txt", "src/tomsawyer.txt",
                "src/mobydick.txt", "src/hamlet.txt", "src/tomsawyer.txt",
                "src/mobydick.txt", "src/hamlet.txt", "src/tomsawyer.txt"};

        System.out.println("Arama işlemi scan ile yapılıyor " + fileNames.length);
        long startTime = System.currentTimeMillis();
        processFileOldWay(fileNames, "the");
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Çalışma zamanı : " + elapsedTime + " ms.");

        System.out.println();

        System.out.println("Arama işlemi stream ile yapılıyor " + fileNames.length);
        startTime = System.currentTimeMillis();
        processFileWithStream(fileNames, "the");
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Çalışma zamanı : " + elapsedTime + " ms.");
    }

    public static void processFileOldWay(String[] fileNames, String word) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        for (String filename : fileNames) {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains(word))
                    lines.add(line);
            }
        }
        System.out.println("Toplamda " + lines.size() + " satir bulundu.");
    }

    public static void processFileWithStream(String[] fileNames, String word) {
        List<String> lines = Arrays.stream(fileNames)
                .flatMap(filename -> Files_linesSafe(filename))
                .filter(line -> line.contains(word))
                .collect(Collectors.toList());
    }

    public static Stream<String> Files_linesSafe(String filename) {
        try {
            return Files.lines(Paths.get(filename));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

