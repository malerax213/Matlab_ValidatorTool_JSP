package Validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Validator {

    public static double getMatch(String inputFileName1, String inputFileName2,
            int tupleSize) throws IOException {
        List<NTuple<String>> nTuples1 = NTuple.loadTuplesFromFile(inputFileName1,
                tupleSize);
        List<NTuple<String>> nTuples2 = NTuple.loadTuplesFromFile(inputFileName2,
                tupleSize);

        int count = Service.countMatches(nTuples1, nTuples2);

        double percentMatch = 0.0;
        if (nTuples1.size() > 0) {
            percentMatch = (100 * count) / nTuples1.size();
        }
        return percentMatch;
    }



    public static void compareFilesWithModelWithNames(File[] files, int numTuples,
            File model, String[] names, String[] sum) throws IOException {
        String comparisonFileName;

        int i = 0;
        PrintWriter log2 = new PrintWriter(System.getProperty("user.dir")
                + "/solFile/results.csv", "UTF-8");
        log2.println("Student ID,Student Name,Percentage of Match");
        for (File file : files) {
            PrintWriter log = new PrintWriter(System.getProperty("user.dir")
                    + "/solFile/wlog" + i + ".txt", "UTF-8");

            if (file.canRead() && file.isFile()) {
                log.println("The name of the student is: " + names[i]);
            }
            comparisonFileName = file.toString();
            double percentage = getMatch(comparisonFileName, model.toString(), numTuples);
            log.println("Percentage of match: " + percentage + "%");
            String temp = names[i].substring(0, names[i].length() - 1);
            log2.println(sum[i] + ",\"" + temp + "\"," + percentage);

            log.close();
            i++;
        }
        log2.close();
    }

    public static void compareFilesWithModel(File[] files, int numTuples,
            File model) throws IOException {
        String comparisonFileName;

        int i = 0;
        for (File file : files) {
            PrintWriter log = new PrintWriter(System.getProperty("user.dir")
                    + "/solFile/wlog" + i + ".txt", "UTF-8");
            if (file.canRead() && file.isFile()) {
            }
            comparisonFileName = file.toString();
            log.println("Percentage of match: "
                    + getMatch(comparisonFileName, model.toString(), numTuples)
                    + "%");
            log.close();
            i++;
        }
    }


    
}
