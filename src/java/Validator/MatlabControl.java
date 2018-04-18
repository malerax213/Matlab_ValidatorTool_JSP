package Validator;
// This file has been created in order to learn how to control matlab from the command line
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatlabControl {

    public MatlabControl(){
        
    }
    
    public static void main(String[] args) {
        String output = executeCommand("matlab -nodesktop -nosplash -r \"run('D:\\Carrera\\TFG\\creaTaulaTH(2,3,4)');\" -logfile D:\\Carrera\\TFG\\logfile.txt");

        System.out.println(output);

    }

    public static String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
