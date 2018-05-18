package Validator;
// This file has been created in order to learn how to control matlab from the command line

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class MatlabControl {

    public MatlabControl() {

    }

    public static void main(String[] args) {

        //String output = executeCommand("/Applications/MATLAB_R2017a.app/bin/matlab -nodesktop -nosplash -r \"run('/Users/alex/Documents/TFG/Tests/Tests/2/test_plab11617_tarda_test2');\" -logfile /Users/alex/Documents/TFG/Tests/wmlog.txt");
        String output;
        output = executeCommand("/Applications/MATLAB_R2017a.app/bin/matlab -nodesktop -nosplash -r "
                + "run('/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/config/solFile/selectedFile/aa_TestAct_wscript'); "
                + "-logfile /Users/alex/Documents/TFG/Tests/Test_Folders/Sumalla Rosell, Roger(rsr3)/logFile0.txt");

        System.out.println(output);

    }

    public static String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            Thread.sleep(40000);
            p.destroyForcibly();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
