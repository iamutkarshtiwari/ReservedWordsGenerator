import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReservedFinder {


    public static void main(String[] args)throws IOException {



        /* Opening the  Reserved words  container file */
        File reservedFile = new File("ReservedKeywords.dat");

        FileWriter fw = new FileWriter(reservedFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        /**** FINDING KEYWORDS AFTER "public" ***/

        /* Scanning all the files from the class folder */
        File folder = new File("ProcessingClasses/");
        File[] listOfFiles = folder.listFiles();




        for (File file : listOfFiles) {
            if (file.isFile()) {
                String name = file.getName();

                //System.out.println(name);




                /* Opening the file to be checked */
                File inputFile = new File("ProcessingClasses/"+name);
                FileReader fileReader = new FileReader(inputFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {

                    // Regular Expression for extraction

                    /*** KEYWORD AFTER 'class' ***/ 
                    Pattern pattern = Pattern.compile("clas{2}\\p{Blank}(\\w+)\\p{Blank}.*\\{");
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        out.println(matcher.group(1));
                    }

                    /*** KEYWORD AFTER 'interface' ***/
                    pattern = Pattern.compile("interface\\p{Blank}(\\w+)\\p{Blank}.*\\{");
                    matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        out.println(matcher.group(1));
                    }

                }

            
            fileReader.close();
            }
        }


        out.close();
        fw.close();



    }
}