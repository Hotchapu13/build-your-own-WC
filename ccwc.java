import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


public class ccwc {
    public static void main(String args[]) {

        // making sure the right instruction format is used
        if (args.length < 3 || !args[0].startsWith("ccwc") || !args[1].startsWith("-")) {
            System.out.println("instruction format: ccwc [-c/-l/-w/-m] <filename>");
            // main(args);  review this later to see what happens 
        }

        //assigning main method arguments                                                                                                                                                                                     
        String option = args[1];
        String filename = args[2];

        File file = new File(filename);

        //checks if the specified file doesn't exist and returns a notification stating so. 
        if (!file.exists()) {
            System.out.println("File not found" + filename);
            return;
        }

        //return the required output according to the instruction given by the user
        long count;
        switch (option) {
            case "-c":
                count = countBytes(file);
                System.out.println("no. of bytes in " + filename + ": " + count);
                break;
            case "-l":
                count = countLines(file);
                System.out.println("no. of lines in " + filename + ": " + count);
                break;
            case "-w":
                count = countWords(file);
                System.out.println("no. of words in " + filename + ": " + count);
                break;
            case "-m":
                count = countChar(file);
                break;
            default:
                System.out.println("invalid option: " + option);
                break;   
        }
    }
    
    public static long countBytes(File file) {
        long byteCount = 0; //initialize bytecount to 0 
        FileInputStream inputStream = null; // reads the data from the file

        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[7099];

            int bytesRead;

            /* reads bytes from the file into the buffer array 
             * and assigns them to bytesRead
             * byteCount increments everytime more bytes are read
             * the read() method returns -1 when it is done reading to the
             * end of the stream
             */
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteCount += bytesRead;
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            /* if inputStream = null then the file wasn't successfully opened
             * attempting to close it if the above was true would cause a nullPointerException
             * 
             */
            if (inputStream != null) {
                try{
                    inputStream.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return byteCount;
    }

    public static long countLines(File file) {
        long lineCount = 0; // initialize line count
        BufferedReader reader = null;
       
        try {
            reader = new BufferedReader(new FileReader(file));
            String linesRead;

            while((linesRead = reader.readLine()) != null){
                lineCount++;
            } 
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lineCount;
    }

    public static long countWords(File file) {
        long wordCount = 0;

        // try {
            // Scanner scanner = new Scanner(file);
            /* using the Scanner class to read words from the file */

        //     while (scanner.hasNext()) {
        //         // String word = scanner.next();
        //         wordCount++;
        //     }

        //     // while ((String word = scanner.next()) != null) {

        //     // }
        //     scanner.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } 

        /*using the bufferedReader class to read words from the file */
         
        BufferedReader reader = null;

        try {
            //create BufferedReader object to read the file
            reader = new BufferedReader(new FileReader(file));
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                //split the line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    wordCount++;
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return wordCount; 
    }

    public static long countChar(File file) {
        long Charcount = 0;
        
        // trying to make some changes to learn more git

        return Charcount;
    }

}