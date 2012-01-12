import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * Make sure the necessary files are in the library
 */
public class ScoresFormatter {

    /**
     * @param args
     */
    /*
     * Basically this works by each person tests results being in its own file
     * And each answer is on a separate line. 
     * Doesn't matter is there are numbers in it like:
     * 1. a
     * 2. b
     * 3. d ...
     * This takes the first letter and stores that as an answer
     */
    public static void main(String[] args) {
        
        String fileLoc = JOptionPane.showInputDialog("What is the file name for each students answer? (names or id");
        Scanner fileName = null;
        
        if (fileLoc.equals("names")){
            fileName = NameFormatter.names;
        }else{
            fileName = NameFormatter.id;   
        }

        try{
            // Create file 
            FileWriter fstream = new FileWriter("scores.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
           
            
            while (fileName.hasNext()){
                
                Scanner a = new Scanner(new File(fileName.nextLine()));
                String fullAns = "";
                
                while (a.hasNext()){
                    
                   String curAns = a.nextLine();
                   
                   for (int x = 0; x<curAns.length(); x++){
                       if (Character.isLetter(curAns.charAt(x))){
                           fullAns += curAns.charAt(x);
                       }
                   }  
                }
                
                 out.write(fullAns);
                 out.newLine();
                 
            }
           
            //Close the output stream
            out.close();
            }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            }
    }

    

}
